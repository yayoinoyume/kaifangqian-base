/**
 * @description PDF文件转换服务
 */
package com.kaifangqian.modules.opensign.service.business;

import com.alibaba.fastjson.JSONObject;
import com.kaifangqian.modules.cert.service.HttpUtils;
import com.kaifangqian.modules.opensign.utils.Base64;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * @Description: PdfConvertService
 * @Package: com.kaifangqian.modules.opensign.service.business
 * @ClassName: PdfConvertService
 * @author: FengLai_Gong
 */
@Service
public class PdfConvertService {


    @Value("${office-convert.enable}")
    private Boolean convertFlag ;
    @Value("${office-convert.word-service}")
    private String wordConvertPdfUrl ;
    @Value("${office-convert.excel-service}")
    private String excelConvertPdfUrl ;


    public byte[] wordConvertPdf(byte[] wordFile){
//        if(!convertFlag){
//            return null ;
//        }
//        String wordConvertPdfUrl = "http://192.168.0.116:8787/kaifangqian-file-convert/office/word/pdf";
        byte[] decode = null ;
        JSONObject param = new JSONObject();
        param.put("fileBase64", Base64.encode(wordFile));
        String returnJson = null ;
        try {
            returnJson  = HttpUtils.executePost(wordConvertPdfUrl, param.toJSONString(), new HashMap<>());
            if(returnJson != null && returnJson.length() > 0){
                JSONObject jsonObject = JSONObject.parseObject(returnJson);
                JSONObject data = jsonObject.getJSONObject("data");
                if(data != null){
                    String pdfBase64 = data.getString("pdfBase64");
                    if(pdfBase64 != null && pdfBase64.length() > 0) {
                        decode  = Base64.decode(pdfBase64);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return decode ;
    }

    public byte[] excelConvertPdf(byte[] excelFile){
//        if(!convertFlag){
//            return null ;
//        }
//        String excelConvertPdfUrl = "http://192.168.0.116:8787/kaifangqian-file-convert/office/excel/pdf";
        byte[] decode = null ;
        JSONObject param = new JSONObject();
        param.put("fileBase64", Base64.encode(excelFile));
        String returnJson = null ;
        try {
            returnJson  = HttpUtils.executePost(excelConvertPdfUrl, param.toJSONString(), new HashMap<>());
            if(returnJson != null && returnJson.length() > 0){
                JSONObject jsonObject = JSONObject.parseObject(returnJson);
                JSONObject data = jsonObject.getJSONObject("data");
                if(data != null){
                    String pdfBase64 = data.getString("pdfBase64");
                    if(pdfBase64 != null && pdfBase64.length() > 0) {
                        decode  = Base64.decode(pdfBase64);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return decode ;
    }


//    public static final String baseUrl = "http://192.168.0.116:8787/kaifangqian-file-convert";
//    public static void main(String[] args) {
//
//        try {
//            byte[] wordFileByte = IOUtils.toByteArray(new FileInputStream(new File("/Users/gongfenglai/Desktop/test/convert/word_test.docx")));
//            byte[] wordConvertPdf = wordConvertPdf(wordFileByte);
//            if(wordConvertPdf != null){
//                IOUtils.write(wordConvertPdf,new FileOutputStream(new File("/Users/gongfenglai/Desktop/test/convert/word_convert02.pdf")));
//            }
//            byte[] excelFileByte = IOUtils.toByteArray(new FileInputStream(new File("/Users/gongfenglai/Desktop/test/convert/excel_test.xlsx")));
//            byte[] excelConvertPdf = excelConvertPdf(excelFileByte);
//            if(excelConvertPdf != null){
//                IOUtils.write(excelConvertPdf,new FileOutputStream(new File("/Users/gongfenglai/Desktop/test/convert/excel_convert02.pdf")));
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }


    public Boolean isConvert(){
        return convertFlag;
    }

    public void test(){
        System.out.println(convertFlag);
        System.out.println(wordConvertPdfUrl);
        System.out.println(excelConvertPdfUrl);
    }


}