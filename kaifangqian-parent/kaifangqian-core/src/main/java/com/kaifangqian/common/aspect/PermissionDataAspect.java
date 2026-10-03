/**
 * @description 数据权限切面处理类
 * 当被请求的方法有注解PermissionData时,会在往当前request中写入数据权限信息
 */
package com.kaifangqian.common.aspect;

import cn.hutool.core.collection.CollUtil;
import com.kaifangqian.common.system.util.PaasDataAutorUtils;
import com.kaifangqian.common.system.vo.SysPermissionDataRuleModel;
import com.kaifangqian.common.util.SpringContextUtils;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import com.kaifangqian.common.api.CommonAPI;
import com.kaifangqian.common.aspect.annotation.PermissionData;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.List;

/**
 * @Author: zhh
 * @DateTime 2022/6/6 14:08
 */
@Aspect
@Component
@Slf4j
public class PermissionDataAspect {

    @Resource
    private CommonAPI commonAPI;

    @Pointcut("@annotation(com.kaifangqian.common.aspect.annotation.PermissionData)")
    public void pointCut() {

    }

    @Around("pointCut()")
    public Object arround(ProceedingJoinPoint point) throws Throwable {
        HttpServletRequest request = SpringContextUtils.getHttpServletRequest();
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        PermissionData pd = method.getAnnotation(PermissionData.class);
        String perms = pd.perms();
        //查询数据权限信息
        List<List<List<List<SysPermissionDataRuleModel>>>> dataRules = commonAPI.queryPermissionDataRule(perms);
        if (CollUtil.isNotEmpty(dataRules)) {
            //临时存储
            PaasDataAutorUtils.installDataSearchConditon(request, dataRules);
        }
        return point.proceed();
    }
}
