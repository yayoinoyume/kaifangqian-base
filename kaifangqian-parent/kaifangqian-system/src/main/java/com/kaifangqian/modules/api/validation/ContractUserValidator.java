/**
 * @description API签署用户验证
 */
package com.kaifangqian.modules.api.validation;

import com.kaifangqian.modules.api.anno.ContractUserValid;
import com.kaifangqian.modules.api.vo.base.ContractUser;

import javax.validation.*;
import java.util.Set;

/**
 * @Description: ContractUserValidator
 * @Package: com.kaifangqian.modules.api.validation
 * @ClassName: ContractUserValidator
 * @author: FengLai_Gong
 * @Date: 2025/5/23
 */
public class ContractUserValidator implements ConstraintValidator<ContractUserValid, ContractUser> {


    @Override
    public void initialize(ContractUserValid constraintAnnotation) {

    }

    @Override
    public boolean isValid(ContractUser contractUser, ConstraintValidatorContext context) {
        if(contractUser == null){
            return true ;
        }
        String s = LocalData.THREAD_LOCAL.get();
        System.out.println(s);

        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        //验证公共参数
        Set<ConstraintViolation<ContractUser>> publicParamErrorSet = validator.validate(contractUser, ValidationSorts.Sort.class);
        if(publicParamErrorSet.size() > 0){
            ConstraintViolation<ContractUser> publicParamError = publicParamErrorSet.stream().findFirst().get();
            //获取当前异常参数的注解

            String path = publicParamError.getPropertyPath().toString();
            System.out.println(path);

            Object errorAnnotation = publicParamError.getConstraintDescriptor().getAnnotation();
            System.out.println(errorAnnotation);

            String message = publicParamError.getMessage();
            System.out.println(message);
        }
        LocalData.THREAD_LOCAL.remove();
        return false;
    }
}