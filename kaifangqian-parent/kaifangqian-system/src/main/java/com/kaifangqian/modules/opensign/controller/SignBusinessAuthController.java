/**
 * @description 资助审批电子签章系统业务权限
 */
package com.kaifangqian.modules.opensign.controller;

import com.kaifangqian.annotation.ResrunLogModule;
import com.kaifangqian.modules.opensign.service.auth.SignBusinessAuthPermissionService;
import com.kaifangqian.modules.opensign.service.auth.SignBusinessAuthService;
import com.kaifangqian.modules.opensign.service.business.AuthBusinessService;
import com.kaifangqian.modules.system.service.ISysUserRoleService;
// import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: 资助审批电子签章系统业务权限
 * @Package: com.kaifangqian.modules.opensign.controller
 * @ClassName: SignBusinessAuthController
 * @author: FengLai_Gong
 * @Date: 2021/8/27 14:05
 */
@Slf4j
@RestController
@RequestMapping("/sign/business/auth")
@ResrunLogModule(name = "资助审批电子签章系统业务权限")
// @Api(tags = "资助审批电子签章系统-业务权限")
public class SignBusinessAuthController {


    @Autowired
    private SignBusinessAuthService businessAuthService;
    @Autowired
    private SignBusinessAuthPermissionService businessAuthPermissionService ;
    @Autowired
    private ISysUserRoleService userRoleService;
    @Autowired
    private AuthBusinessService authBusinessService ;




//    // @ApiOperation("业务权限列表")
//    @GetMapping("/list")
//    @ResponseBody
//    public Result<List<BusinessAuthOperateVo>> list() {
//
//        List<BusinessAuthOperateVo> returnList = new ArrayList<>();
//        //获取签章业务权限
//        List<SignBusinessAuthPermission> sealAuthList = authBusinessService.getPermissionList(BusinessAuthType.SEAL);
//        if(sealAuthList != null && sealAuthList.size() > 0){
//            BusinessAuthOperateVo vo = new BusinessAuthOperateVo();
//            vo.setBusinessType(BusinessAuthType.SEAL.getCode());
//            List<String> operateList = new ArrayList<>();
//            for(SignBusinessAuthPermission permission : sealAuthList){
//                operateList.add(permission.getPermissionValue());
//            }
//            vo.setOperateList(operateList);
//            returnList.add(vo);
//        }
//        return Result.OK(returnList);
//    }
//
//    public BusinessAuthQueryVo build(String businessRelationId){
//        LoginUser currentUser = MySecurityUtils.getCurrentUser();
//
//        BusinessAuthQueryVo businessAuthQueryVo = new BusinessAuthQueryVo();
//        businessAuthQueryVo.setTenantUserId(currentUser.getTenantUserId());
//        businessAuthQueryVo.setDepartId(currentUser.getDepartId());
//        List<SysUserRole> userRoles = userRoleService.queryByUserIdAndTenantId(currentUser.getId(), currentUser.getTenantId());
//        if(userRoles != null && userRoles.size() > 0){
//            List<String> roleIdList = new ArrayList<>();
//            for(SysUserRole role : userRoles){
//                roleIdList.add(role.getRoleId());
//            }
//            businessAuthQueryVo.setRoleIds(roleIdList);
//        }
////        businessAuthQueryVo.setBusinessType(1);
//        if(businessRelationId != null){
//            businessAuthQueryVo.setBusinessRelationId(businessRelationId);
//        }
//
//        return businessAuthQueryVo ;
//    }
//
//


}