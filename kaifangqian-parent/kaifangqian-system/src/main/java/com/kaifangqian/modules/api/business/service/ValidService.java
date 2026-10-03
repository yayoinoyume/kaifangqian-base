/**
 * @description 请求数据校验服务
 */
package com.kaifangqian.modules.api.business.service;

import com.kaifangqian.modules.api.exception.RequestParamsException;
import com.kaifangqian.common.constant.ApiCode;
import com.kaifangqian.modules.api.vo.request.AnnexFileRequest;
import com.kaifangqian.modules.api.vo.request.CompanyCreateAndAuthRequest;
import com.kaifangqian.modules.api.vo.request.DocumentFileRequest;
import com.kaifangqian.modules.api.vo.request.PersonCreateAndAuthRequest;
import com.kaifangqian.modules.opensign.enums.SignFileSuffixEnum;
import com.kaifangqian.utils.MyStringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: ValidService
 * @Package: com.kaifangqian.modules.api.business.service
 * @ClassName: ValidService
 * @author: FengLai_Gong
 * @Date: 2024/5/23 10:09
 */
@Service
public class ValidService {

    public void personalCreateAndAuthRequestValid(PersonCreateAndAuthRequest request){

        if(request == null){
            throw new RequestParamsException(ApiCode.PARAM_MISSING,"参数缺失");
        }
        if(request.getAccount() == null){
            throw new RequestParamsException(ApiCode.PARAM_MISSING,"account参数缺失");
        }
        if(request.getAccount().getContactType() == null || request.getAccount().getContactType().length() == 0){
            throw new RequestParamsException(ApiCode.PARAM_MISSING,"contactType参数缺失");
        }
        if(!"MOBILE".equals(request.getAccount().getContactType()) && !"EMAIL".equals(request.getAccount().getContactType())){
            throw new RequestParamsException(ApiCode.BUSINESS_HANDLE_ERROR,"账号类型仅支持MOBILE、EMAIL");
        }
        if(MyStringUtils.isNotBlank(request.getMobile())){
            if(!request.getMobile().matches("^1[3-9]\\d{9}$")){
                throw new RequestParamsException(ApiCode.PARAM_FORMAT_ERROR,"mobile参数格式不正确,手机号格式不合法");
            }
        }
        if(request.getAccount().getContactType().equals("EMAIL")){
            if(request.getAccount().getContact() == null || !request.getAccount().getContact().matches("^[A-Za-z0-9+_.-]+@([A-Za-z0-9.-]+\\.[A-Za-z]{2,})$")){
                throw new RequestParamsException(ApiCode.PARAM_FORMAT_ERROR,"contact参数格式不正确,邮箱格式不合法");
            }
        }else if(request.getAccount().getContactType().equals("MOBILE")){
            if(request.getAccount().getContact() == null || !request.getAccount().getContact().matches("^1[3-9]\\d{9}$")){
                throw new RequestParamsException(ApiCode.PARAM_FORMAT_ERROR,"contact参数格式不正确,手机号格式不合法");
            }
        }

    }

    public void companyCreateAndAuthRequestValid(CompanyCreateAndAuthRequest request){

        if(request == null){
            throw new RequestParamsException(ApiCode.PARAM_MISSING,"参数缺失");
        }
        if(request.getAccount() == null){
            throw new RequestParamsException(ApiCode.PARAM_MISSING,"account参数缺失");
        }
        if(request.getAccount().getContactType() == null || request.getAccount().getContactType().length() == 0){
            throw new RequestParamsException(ApiCode.PARAM_MISSING,"contactType参数缺失");
        }
        if(!"MOBILE".equals(request.getAccount().getContactType()) && !"EMAIL".equals(request.getAccount().getContactType())){
            throw new RequestParamsException(ApiCode.BUSINESS_HANDLE_ERROR,"账号类型仅支持MOBILE、EMAIL");
        }
        if(request.getAccount().getContact() == null || request.getAccount().getContact().length() == 0){
            throw new RequestParamsException(ApiCode.PARAM_MISSING, "contact参数缺失");
        }
//        if(request.getCompanyName() == null || request.getCompanyName().length() == 0){
//            throw new RequestParamsException(ApiCode.PARAM_MISSING,"companyName参数缺失");
//        }
//        if(request.getCreditCode() == null || request.getCreditCode().length() == 0){
//            throw new RequestParamsException(ApiCode.PARAM_MISSING,"creditCode参数缺失");
//        }

        if(request.getAccount().getContactType().equals("EMAIL")){
            if(request.getAccount().getContact() == null || !request.getAccount().getContact().matches("^[A-Za-z0-9+_.-]+@([A-Za-z0-9.-]+\\.[A-Za-z]{2,})$")){
                throw new RequestParamsException(ApiCode.PARAM_FORMAT_ERROR,"contact参数格式不正确,邮箱格式不合法");
            }
        }else if(request.getAccount().getContactType().equals("MOBILE")){
            if(request.getAccount().getContact() == null || !request.getAccount().getContact().matches("^1[3-9]\\d{9}$")){
                throw new RequestParamsException(ApiCode.PARAM_FORMAT_ERROR,"contact参数格式不正确,手机号格式不合法");
            }
        }
//        if(request.getIdentity() == null || request.getIdentity().length() == 0){
//            throw new RequestParamsException(ApiCode.PARAM_MISSING,"identity参数缺失");
//        }
//        if(request.getLegalPerson() == null || request.getLegalPerson().length() == 0){
//            throw new RequestParamsException(ApiCode.PARAM_MISSING,"legalPerson参数缺失");
//        }


    }

    public void annexFileRequestValid(AnnexFileRequest request){
        if(request == null){
            throw new RequestParamsException(ApiCode.PARAM_MISSING,"参数缺失");
        }
        if(request.getFile() == null || request.getFile().length() == 0){
            throw new RequestParamsException(ApiCode.PARAM_MISSING,"file参数缺失");
        }
        if(request.getFileName() == null || request.getFileName().length() == 0){
            throw new RequestParamsException(ApiCode.PARAM_MISSING,"fileName参数缺失");
        }
        if(request.getFileName().length() > 128){
            throw new RequestParamsException(ApiCode.PARAM_SIZE_INVALID,"fileName参数格式不正确，长度不合法");
        }
//        if(request.getFileName().contains(" ")){
//            throw new RequestParamsException(ApiCode.PARAM_SIZE_INVALID,"fileName参数格式不正确，不能包含空格");
//        }

        if(request.getFileSuffix() == null || request.getFileSuffix().length() == 0){
            throw new RequestParamsException(ApiCode.PARAM_MISSING,"fileSuffix参数缺失");
        }
        if(request.getFileSuffix().length() > 10){
            throw new RequestParamsException(ApiCode.PARAM_SIZE_INVALID,"fileSuffix参数格式不正确，长度不合法");
        }
        if(request.getFileSuffix().contains(" ")){
            throw new RequestParamsException(ApiCode.PARAM_SIZE_INVALID,"fileSuffix参数格式不正确，不能包含空格");
        }
        //校验文件格式
        List<String> suffixList = SignFileSuffixEnum.getSuffixList();
        if(!suffixList.contains(request.getFileSuffix())){
            throw new RequestParamsException(ApiCode.PARAM_SIZE_INVALID,"fileSuffix参数格式不正确,文件格式不支持");
        }
    }

    public void documentFileRequestValid(DocumentFileRequest request){
        if(request == null){
            throw new RequestParamsException(ApiCode.PARAM_MISSING,"参数缺失");
        }
        if(request.getFile() == null || request.getFile().length() == 0){
            throw new RequestParamsException(ApiCode.PARAM_MISSING,"file参数缺失");
        }
        if(request.getFileName() == null || request.getFileName().length() == 0){
            throw new RequestParamsException(ApiCode.PARAM_MISSING,"fileName参数缺失");
        }
        if(request.getFileName().length() > 128){
            throw new RequestParamsException(ApiCode.PARAM_SIZE_INVALID,"fileName参数格式不正确，长度不合法");
        }
//        if(request.getFileName().contains(" ")){
//            throw new RequestParamsException(ApiCode.PARAM_SIZE_INVALID,"fileName参数格式不正确，不能包含空格");
//        }

        if(request.getFileSuffix() == null || request.getFileSuffix().length() == 0){
            throw new RequestParamsException(ApiCode.PARAM_MISSING,"fileSuffix参数缺失");
        }

        if(!request.getFileSuffix().equals(".pdf") &&
                !request.getFileSuffix().equals(".doc") &&
                !request.getFileSuffix().equals(".docx") &&
                !request.getFileSuffix().equals(".xls") &&
                !request.getFileSuffix().equals(".xlsx")){
            throw new RequestParamsException(ApiCode.PARAM_SIZE_INVALID,"fileSuffix参数格式不正确");
        }
        if(request.getFileSuffix().length() > 10){
            throw new RequestParamsException(ApiCode.PARAM_SIZE_INVALID,"fileSuffix参数格式不正确，长度不合法");
        }
        if(request.getFileSuffix().contains(" ")){
            throw new RequestParamsException(ApiCode.PARAM_SIZE_INVALID,"fileSuffix参数格式不正确，不能包含空格");
        }
    }

}