/**
 * @description 电子印章文件类型枚举
 */
package com.kaifangqian.modules.opensign.enums;

/**
 * @Description: 电子印章文件类型枚举
 * @Package: com.kaifangqian.modules.sign.enums
 * @ClassName: SignFileEnum
 * @author: FengLai_Gong
 */
public enum SignFileEnum {


    CERT("jks","jks","cert_cert"),
    JKS("jks","jks","cert_jks"),
    P7B("p7b","p7b","cert_p7b"),
    PFX("pfx","pfx","cert_pfx"),

    SEAL_FILE_ENT("png","png","seal_file_ent"),
    SEAL_FILE_PERSON("png","png","seal_file_person"),

    SEAL_FILE_TEMPORARY("png","png","seal_file_temporary"),

    SIGN_FILE_IMAGE("png","png","sign_file_image"),

    SIGN_FILE_MAIN("pdf","pdf","sign_file_main"),
    SIGN_FILE_OTHER("pdf","pdf","sign_file_other"),



    SIGN_FILE_REPORT("pdf","pdf","sign_file_report"),



    ;

    //文件后缀
    private String suffix ;
    //文件类型
    private String fileType ;
    //附件种类
    private String dataCategory ;

    SignFileEnum(String suffix , String fileType , String dataCategory ){
        this.suffix = suffix ;
        this.fileType = fileType ;
        this.dataCategory = dataCategory ;
    }

    public String getSuffix(){
        return this.suffix ;
    }

    public String getFileType(){
        return this.fileType ;
    }

    public String getDataCategory(){
        return this.dataCategory ;
    }





}