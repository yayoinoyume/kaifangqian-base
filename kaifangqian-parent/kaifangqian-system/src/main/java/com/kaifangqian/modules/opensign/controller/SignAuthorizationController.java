/**
 * @description 资助审批电子签章系统-业务权限
 */
package com.kaifangqian.modules.opensign.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kaifangqian.annotation.ResrunLogModule;
import com.kaifangqian.common.aspect.LicenseBean;
import com.kaifangqian.common.base.entity.BaseEntity;
import com.kaifangqian.common.system.vo.Authorization;
import com.kaifangqian.common.system.vo.LoginUser;
import com.kaifangqian.common.util.MySecurityUtils;
import com.kaifangqian.common.vo.Result;
import com.kaifangqian.modules.opensign.entity.SignRe;
import com.kaifangqian.modules.opensign.entity.SignTemplate;
import com.kaifangqian.modules.opensign.service.re.SignReService;
import com.kaifangqian.modules.opensign.service.template.SignTemplateService;
// import io.swagger.annotations.Api;
// import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description: SignAuthorizationController
 * @Package: com.kaifangqian.modules.opensign.controller
 * @ClassName: SignAuthorizationController
 * @author: FengLai_Gong
 */
@Slf4j
@RestController
@RequestMapping("/sign/authorization")
@ResrunLogModule(name = "资助审批电子签章系统-业务权限")
// @Api(tags = "资助审批电子签章系统-业务权限")
public class SignAuthorizationController {

    @Autowired
    private LicenseBean licenseBean ;

    @Autowired
    private SignTemplateService templateService ;

    @Autowired
    private SignReService reService ;

    // @ApiOperation("模板授权校验")
    @GetMapping("/template")
    @ResponseBody
    public Result<?> template() {

        if(licenseBean == null || licenseBean.getGrant() == null){
            return Result.error("没有授权",null);
        }
        Map<String,Object> result = new HashMap<>(2);
        LoginUser currentUser = MySecurityUtils.getCurrentUser();
        Authorization grant = licenseBean.getGrant();
//        if(!grant.isTemplateUseFlag()){
//            return Result.OK(false);
//        }
        QueryWrapper<SignTemplate> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(SignTemplate::getSysTenantId,currentUser.getTenantId());
        wrapper.lambda().eq(BaseEntity::getDeleteFlag,false);
        Long count = templateService.count(wrapper);
        if(count.intValue() >=  grant.getTemplateCeiling()){
//            return Result.OK(false);
            result.put("flag",false);
        }else{
            result.put("flag",true);
        }
        result.put("count",grant.getTemplateCeiling());
        return Result.OK(result) ;
    }


    // @ApiOperation("业务线授权校验")
    @GetMapping("/businessLine")
    @ResponseBody
    public Result<?> businessLine() {

        if(licenseBean == null || licenseBean.getGrant() == null){
            return Result.error("没有授权",null);
        }
        Map<String,Object> result = new HashMap<>(2);
        LoginUser currentUser = MySecurityUtils.getCurrentUser();
        Authorization grant = licenseBean.getGrant();
        //没有授权业务线
        if(!grant.isBusinessLineUseFlag()){
            result.put("flag",2);
            return Result.OK(result) ;
        }
        //失效
        if(new Date().getTime()>grant.getLicenseExpire().getTime()){
            result.put("flag",3);
            return Result.OK(result) ;
        }
        QueryWrapper<SignRe> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(SignRe::getSysTenantId,currentUser.getTenantId());
        wrapper.lambda().eq(BaseEntity::getDeleteFlag,false);
        Long count = reService.count(wrapper);
        if(count.intValue() >=  grant.getBusinessLineCeiling()){
//            return Result.OK(false);
            result.put("flag",0);
        }else{
            result.put("flag",1);
        }
        result.put("count",grant.getTemplateCeiling());

        return Result.OK(result) ;
    }


}