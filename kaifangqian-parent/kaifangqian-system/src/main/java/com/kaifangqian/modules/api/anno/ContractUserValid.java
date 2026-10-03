/**
 * @description 签署文件用户信息验证
 */
package com.kaifangqian.modules.api.anno;

import com.kaifangqian.modules.api.validation.ContractUserValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Description: ContractUserValid
 * @Package: com.kaifangqian.modules.api.validation
 * @ClassName: ContractUserValid
 * @author: FengLai_Gong
 */
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.ANNOTATION_TYPE,
        ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {ContractUserValidator.class})
public @interface ContractUserValid {

    String message() default "param_enum_invalid";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default { };


}