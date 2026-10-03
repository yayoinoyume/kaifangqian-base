/**
 * @description 在线签名验签接口
 */
package com.kaifangqian.modules.opensign.service.verify.impl;

import com.alibaba.fastjson.JSONObject;
import com.kaifangqian.common.vo.Result;
import com.kaifangqian.config.FileProperties;
import com.kaifangqian.modules.opensign.enums.SignStatus;
import com.kaifangqian.modules.opensign.service.verify.SignVerifyService;
import com.kaifangqian.modules.opensign.util.VerifySign;
import com.kaifangqian.modules.opensign.vo.base.SignPdfInfoVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


/**
 * @Description: 在线签名验签服务实现类
 * @Package: com.kaifangqian.modules.opensign.service.doc.impl
 * @ClassName: SignVerifyServiceImpl
 * @author: Fusion
 * CreateTime:  2023/8/120  10:53
 * @copyright 本平台运营方
 */


@Slf4j
@Service
public class SignVerifyServiceImpl implements SignVerifyService {

    @Autowired
    private FileProperties fileProperties;
    /**
     * 获取pdf签名图片信息
     * @param  file
     * @return 提取结果
     */
    public Result<?> getImageFromPdf(MultipartFile file) throws IOException {
        Result<JSONObject> result = new Result<>();
//        String signFileUrl = fileProperties.getPath().getPath();

        //String signFileUrl = System.getProperty("user.dir") +"/resrun-paas-system/src/main/resources/upload/";    //本地测试路径
//        String signFilePath = signFileUrl + file.getOriginalFilename();
//        File oldFile = new File(signFilePath);
        byte[] bytes = file.getBytes();
        SignPdfInfoVo signPdfInfo = new SignPdfInfoVo();
        try {
//            Path path = Paths.get(signFileUrl + file.getOriginalFilename());
//            Files.write(path, bytes);

            signPdfInfo = VerifySign.getSignFromPdf(bytes);
            signPdfInfo.setPdfName(file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("/") + 1));
            signPdfInfo.setPdfSize(String.format("%.2f",bytes.length/1024.0));
            switch (signPdfInfo.getPdfSingResult()) {
                case 1:
                    return Result.OK(SignStatus.SIGN_STATUS_NOSIGNATURE.getMsg(), signPdfInfo);
                case 2:
                    return Result.OK(SignStatus.SIGN_STATUS_ERROR.getMsg(), signPdfInfo);
                case 3:
                    return Result.OK(SignStatus.SIGN_STATUS_FIDDLE.getMsg(), signPdfInfo);
                default:
                    return Result.OK(SignStatus.SIGN_STATUS_RIGHT.getMsg(), signPdfInfo);
            }


        }catch (Exception e){
//            signPdfInfo.setPdfName(signFilePath.substring(signFilePath.lastIndexOf("/") + 1));
//            signPdfInfo.setPdfSize(String.valueOf(oldFile.length()));
            signPdfInfo.setPdfName(file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("/") + 1));
            signPdfInfo.setPdfSize(String.valueOf(bytes.length/1024));

            signPdfInfo.setPdfSingResult(SignStatus.SIGN_STATUS_NOSIGNATURE.getCode());
//            deleteDirectory(oldFile);
            return Result.OK(SignStatus.SIGN_STATUS_NOSIGNATURE.getMsg(),signPdfInfo);
        }
    }

}
