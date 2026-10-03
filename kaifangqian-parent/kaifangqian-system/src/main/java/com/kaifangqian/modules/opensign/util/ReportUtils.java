/**
 * @description jasper打印工具类
 */
package com.kaifangqian.modules.opensign.util;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.ObjectUtils;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;


/**
 * @Description: jasper打印工具类
 * @Package: com.kaifangqian.modules.opensign.service.doc.impl
 * @ClassName: JasperReportUtil
 * @author: Fusion
 * CreateTime: 2023/8/25 10:57
 * @copyright 本平台运营方
 */
public class ReportUtils {
    private final static String baseDir="templates";

    /**
     * @Author Fusion
     * @Description 根据模板名获取jasper模板路径
     * @Param [templateName]
     * @return java.lang.String
     **/
    public static String getJasperTemplateDir(String templateName){
        return baseDir+ File.separator+templateName+".jasper";
    }

    /**
     * @Author Fusion
     * @Description 获取响应得contentType
     * @Param [type]
     * @return java.lang.String
     **/
    private static String getContentType(ReportType type) {
        String contentType;
        switch (type) {
            case HTML:
                contentType = "text/html;charset=utf-8";
                break;
            case PDF:
                contentType = "application/pdf";
                break;
            case XLS:
                contentType = "application/vnd.ms-excel";
                break;
            case XLSX:
                contentType = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
                break;
            case XML:
                contentType = "text/xml";
                break;
            case RTF:
                contentType = "application/rtf";
                break;
            case CSV:
                contentType = "text/plain";
                break;
            case DOC:
                contentType = "application/msword";
                break;
            default:
                contentType = "text/html;charset=utf-8";
        }
        return contentType;
    }

    /**
     * @Author Fusion
     * @Description 获取jasperPrint对象
     * @Param [jasperStream 模板得输入流, parameters 模板输入参数, list 打印内容]
     * @return net.sf.jasperreports.engine.JasperPrint
     **/
    public static JasperPrint getJasperPrint(InputStream jasperStream, Map parameters, List<?> list) throws JRException {
        JRDataSource dataSource=null;
        if(ObjectUtils.isEmpty(list)){
            dataSource=new JREmptyDataSource();
        }else {
            dataSource=new JRBeanCollectionDataSource(list);
        }
        JasperPrint jasperPrint= JasperFillManager.fillReport(jasperStream,parameters,dataSource);
        return jasperPrint;
    }

    /**
     * @Author Fusion
     * @Description pdf输出
     * @Param [jasperPath, parameters, list, response]
     * @return void
     **/
    public static void exportToPdf(String jasperPath, Map parameters, List<?>list, HttpServletResponse response) throws IOException, JRException {
        OutputStream out=response.getOutputStream();
        ClassPathResource resource=new ClassPathResource(jasperPath);
        response.setContentType(getContentType(ReportType.PDF));
        InputStream jasperStream=resource.getInputStream();
        JasperPrint jasperPrint=getJasperPrint(jasperStream,parameters,list);
        JasperExportManager.exportReportToPdfStream(jasperPrint,out);
        out.flush();
        out.close();
    }

    enum ReportType {
        HTML,
        PDF,
        XLS,
        XLSX,
        XML,
        RTF,
        CSV,
        DOC
    }


    public static void setResponse(HttpServletResponse response, String fileName) {
        try {
            String fileNameencode = URLEncoder.encode(fileName, "UTF-8");
            response.setCharacterEncoding("utf-8");
            response.setContentType("application/vnd.ms-excel");
            response.setHeader("Content-Disposition", "attachment;fileName=" + fileNameencode);
            response.setHeader("fileName", fileNameencode);
            response.setHeader("Access-Control-Expose-Headers", "fileName");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

}
