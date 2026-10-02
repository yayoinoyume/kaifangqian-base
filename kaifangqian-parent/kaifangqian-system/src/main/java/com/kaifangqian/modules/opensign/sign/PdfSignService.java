/**
 * @description 文件签署服务
 *
 * Copyright (C) [2025] [版权所有者（北京资源律动科技有限公司）]. All rights reserved.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 *
 * 注意：本代码基于 AGPLv3 协议发布。若通过网络提供服务（如 Web 应用），
 * 必须公开修改后的完整源代码（包括衍生作品），详见协议全文。
 */
package com.kaifangqian.modules.opensign.sign;

import com.kaifangqian.exception.PaasException;
import com.kaifangqian.modules.account.enums.SignConsumeTypeEnum;
import com.kaifangqian.modules.opensign.enums.PersonalSignAuthTypeEnum;
import com.kaifangqian.modules.opensign.enums.SignTypeEnum;
import com.kaifangqian.modules.opensign.service.business.PdfEncryptionService;
import com.kaifangqian.modules.opensign.service.business.vo.YundunSignPositionArrayData;
import com.kaifangqian.modules.opensign.service.business.vo.YundunSignPositionData;
import com.kaifangqian.modules.opensign.service.tool.pojo.RealPositionProperty;
import com.kaifangqian.modules.opensign.vo.base.sign.PdfSignResult;
import com.kaifangqian.modules.opensign.vo.base.sign.PdfSignVoInfo;
import com.kaifangqian.pdfbox.vo.AssinaturaPosition;
import com.kaifangqian.utils.MyStringUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @Description: PdfSignService
 * @Package: com.kaifangqian.modules.opensign.pdfbox
 * @ClassName: PdfSignService
 * @author: yxb
 * @Date 2025/5/31
 */
@Slf4j
@Service
public class PdfSignService {

    private static final String LOCAL_CA_DIR_PROPERTY = "kfq.local-ca.dir";
    private static final String LOCAL_CA_DIR_DEFAULT = "/app/storage/local-ca";

    @Autowired
    private PdfEncryptionService pdfEncryptionService;

    /**
     * 本地签名证书（PFX）口令，必须由部署方通过 kfq.local-ca.password（环境变量 KFQ_LOCAL_CA_PASSWORD）注入；
     * 不允许硬编码弱口令，未配置时直接失败。
     */
    @Value("${kfq.local-ca.password:}")
    private String localSignCertPassword;

    public Integer getPdfPage(byte[] pdfByte){
        Integer page = 0 ;

        try {
            PDDocument document = Loader.loadPDF(pdfByte);
            if (document == null) {
                throw new PaasException("pdf文件解析失败");
            }
            page = document.getNumberOfPages();
            document.close();
        } catch (Exception e) {
            throw new PaasException("pdf文件异常");
        }

        return page ;
    }

    /**
     * @Description #签署
     * @Param [pdfFile 文档, signByte 签章, certInfo 证书, positions 位置]
     * @return byte[]
     **/
    public PdfSignResult signWithYundunHash(PdfSignVoInfo pdfSignVoInfo){
        //签署返回信息
        PdfSignResult pdfSignResult = new PdfSignResult();
        Map<String, byte[]> signedDocFileByteMap = new HashMap<>();

        LocalPdfSigner localPdfSigner = loadLocalSigner();
        String location = pdfSignVoInfo.getAppName()+"："+pdfSignVoInfo.getAppId();
        String reason = buildSignReason(pdfSignVoInfo);

        //遍历每个文件，设置签署位置，执行本地签署
        for (Map.Entry<String, byte[]> entry : pdfSignVoInfo.getNewDocFileByteMap().entrySet()) {
            String docId = entry.getKey();
            byte[] docBytes = entry.getValue();

            //文件加密（配置关闭时不改变文件）
            byte[] newDocFileByte = pdfEncryptionService.pdfToEncrypted(docBytes);
            List<AssinaturaPosition> realPositions = buildSignPositions(docId, pdfSignVoInfo);

            try {
                byte[] signedFile = localPdfSigner.sign(
                        newDocFileByte,
                        pdfSignVoInfo.getEntSealByte(),
                        realPositions,
                        null,
                        location,
                        reason);
                signedDocFileByteMap.put(docId, signedFile);
            } catch (Exception e) {
                log.error("本地签署失败, docId={}", docId, e);
                throw new PaasException("签署失败", e);
            }
        }

        pdfSignVoInfo.getNewDocFileByteMap().putAll(signedDocFileByteMap);

        if (SignTypeEnum.AUTH_SIGN.getCode().equals(pdfSignVoInfo.getSignType())) {
            pdfSignResult.setFinalSignType(SignConsumeTypeEnum.VALID_SIGN.getCode());
            pdfSignResult.setAuthType(SignConsumeTypeEnum.VALID_SIGN.getCode());
        } else {
            pdfSignResult.setFinalSignType(SignConsumeTypeEnum.AUTO_SIGN.getCode());
            pdfSignResult.setAuthType(SignConsumeTypeEnum.AUTO_SIGN.getCode());
        }
        if (MyStringUtils.isNotBlank(pdfSignVoInfo.getPersonalSignAuthType())) {
            pdfSignResult.setPersonalSignAuth(pdfSignVoInfo.getPersonalSignAuthType());
        } else {
            pdfSignResult.setPersonalSignAuth(PersonalSignAuthTypeEnum.REQUIRED.getType());
        }
        pdfSignResult.setNewDocFileByteMap(pdfSignVoInfo.getNewDocFileByteMap());
        return pdfSignResult ;
    }

    private List<AssinaturaPosition> buildSignPositions(String docId, PdfSignVoInfo pdfSignVoInfo) {
        List<AssinaturaPosition> realPositions = new ArrayList<>();
        if (pdfSignVoInfo.getYundunSignPositionArrayDatas() == null) {
            return realPositions;
        }

        for (YundunSignPositionArrayData yundunSignPositionArrayData : pdfSignVoInfo.getYundunSignPositionArrayDatas()) {
            if (!docId.equals(yundunSignPositionArrayData.getDocId())) {
                continue;
            }
            List<YundunSignPositionData> yundunSignPositionDataList = yundunSignPositionArrayData.getYundunSignPositionDataList();
            if (yundunSignPositionDataList == null) {
                continue;
            }
            for (YundunSignPositionData yundunSignPositionData : yundunSignPositionDataList) {
                RealPositionProperty realPositionProperty = yundunSignPositionData.getSealPosition();
                byte[] sealImgByte = yundunSignPositionData.getSealImgByte();

                AssinaturaPosition position = new AssinaturaPosition();
                position.setPage(realPositionProperty.getPageNum());
                position.setOffsetX(realPositionProperty.getStartx() + "");
                position.setSignWidth((realPositionProperty.getEndx() - realPositionProperty.getStartx()) + "");
                //纵坐标，pdfbox是从下向上计算的
                float signHeight = realPositionProperty.getStarty() - realPositionProperty.getEndy();
                if(signHeight < 0){
                    signHeight = realPositionProperty.getEndy() - realPositionProperty.getStarty() ;
                }
                position.setSignHeight(signHeight + "");
                position.setOffsetY((realPositionProperty.getRealPdfHeight() - realPositionProperty.getStarty() - signHeight) + "");
                position.setSeal(sealImgByte);
                position.setFieldName(UUID.randomUUID().toString().replace("-", ""));

                realPositions.add(position);
            }
        }
        return realPositions;
    }

    private String buildSignReason(PdfSignVoInfo pdfSignVoInfo) {
        if (PersonalSignAuthTypeEnum.NOT_REQUIRED.getType().equals(pdfSignVoInfo.getPersonalSignAuthType())) {
            return "ID:"+pdfSignVoInfo.getSignRu().getId()+"，该证书仅能保障文件在电子签名后不被篡改，不具备《电子签名法》所规定的法律效力。";
        }
        return "ID:"+pdfSignVoInfo.getSignRu().getId()+"，依据电子签名法此电子签名与本人的签名/签章具有同等法律效力。";
    }

    private LocalPdfSigner loadLocalSigner() {
        try {
            if (MyStringUtils.isBlank(localSignCertPassword)) {
                throw new PaasException("未配置本地签名证书口令 kfq.local-ca.password（KFQ_LOCAL_CA_PASSWORD），拒绝使用弱默认口令");
            }
            String caDirectory = System.getProperty(LOCAL_CA_DIR_PROPERTY, LOCAL_CA_DIR_DEFAULT);
            LocalCertificateManager.LocalCertificateMaterial material =
                    LocalCertificateManager.loadOrCreate(caDirectory, localSignCertPassword);
            return new LocalPdfSigner(material.getPfxBytes(), localSignCertPassword);
        } catch (Exception e) {
            throw new PaasException("本地签名证书初始化失败", e);
        }
    }
}
