/**
 * @description PDF文件加密服务
 */
package com.kaifangqian.modules.opensign.service.business;

import com.kaifangqian.utils.MyStringUtils;
import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.AccessPermission;
import org.apache.pdfbox.pdmodel.encryption.StandardProtectionPolicy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * @Description: PdfEncryptionService
 * @Package: com.kaifangqian.modules.opensign.service.business
 * @ClassName: PdfEncryptionService
 * @author: FengLai_Gong
 */
@Service
public class PdfEncryptionService {

    @Value("${paas.pdf-encryption-enable}")
    private Boolean pdfEncryptionFlag;
    @Value("${paas.pdf-encryption-password}")
    private String pdfEncryptionPassword;

    /**
     * 安全失败：开启 PDF 加密但未配置口令时拒绝启动，避免使用空口令或历史弱默认值。
     * 未开启加密（默认）时不校验，不影响本地 PDF 签名链路。
     */
    @PostConstruct
    public void validatePasswordWhenEnabled() {
        if (Boolean.TRUE.equals(pdfEncryptionFlag) && MyStringUtils.isBlank(pdfEncryptionPassword)) {
            throw new IllegalStateException(
                    "已开启 PDF 加密（paas.pdf-encryption-enable=true）但未配置口令"
                            + "（paas.pdf-encryption-password / PAAS_PDF_ENCRYPTION_PASSWORD），拒绝启动");
        }
    }


    /**
     * 文件加密
     * @param pdfFileBytes
     * @throws Exception
     */
    public byte[] pdfToEncrypted(byte[] pdfFileBytes){
        byte[] pdfByte = null ;
        if(pdfEncryptionFlag){
            try{
                //读取PDF文件
                PDDocument doc = Loader.loadPDF(pdfFileBytes) ;
                //判断是否加密过
                if (doc.isEncrypted()) {
                    pdfByte = pdfFileBytes ;
                }else {
                    // 创建访问权限对象
                    AccessPermission ap = new AccessPermission();
                    // 设置权限
                    ap.setCanModify(false); // 不允许修改
                    ap.setCanPrint(true); // 允许打印
                    ap.setCanExtractContent(false);//
                    ap.setReadOnly();// 只读
                    ap.setCanFillInForm(false); // 不允许填写表单
                    // 创建保护策略，ownerPassword设置后，用户另存为其它文件时，需要输入ownerPassword才能执行
                    StandardProtectionPolicy spp = new StandardProtectionPolicy(pdfEncryptionPassword, null, ap);
                    spp.setEncryptionKeyLength(128); // 设置加密密钥长度
                    // 应用保护策略
                    doc.protect(spp);

                    ByteArrayOutputStream out = new ByteArrayOutputStream();
                    doc.save(out);
                    doc.close();
                    //输出文件字节数组
                    pdfByte = out.toByteArray();
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }else {
            pdfByte = pdfFileBytes ;
        }

        return pdfByte ;
    }

    /**
     * @Description # 文件解密
     * @Param [pdfFileBytes]
     * @return byte[]
     **/
    public byte[] pdfToDecrypted(byte[] pdfFileBytes) {
        byte[] pdfByte = null ;
        if(pdfEncryptionFlag){
            try{
                //读取PDF文件，并且指定解密密码
                PDDocument doc = Loader.loadPDF(pdfFileBytes,pdfEncryptionPassword) ;
                ByteArrayOutputStream out = new ByteArrayOutputStream();
                doc.save(out);
                doc.close();
                //输出文件字节数组
                pdfByte = out.toByteArray();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }else {
            pdfByte = pdfFileBytes ;
        }

        return pdfByte ;

    }

    public Boolean isEncryption() {
        return pdfEncryptionFlag;
    }

    public String getPdfEncryptionPassword() {
        return pdfEncryptionPassword;
    }




}