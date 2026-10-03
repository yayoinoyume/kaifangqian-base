/**
 * @description 签署业务权限对象类
 */
package com.kaifangqian.modules.opensign.service.auth.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @Description: BusinessAuthQueryVo
 * @Package: com.kaifangqian.modules.opensign.service.auth.vo
 * @ClassName: BusinessAuthQueryVo
 * @author: FengLai_Gong
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BusinessAuthQueryVo implements Serializable {

    private static final long serialVersionUID = 2243719949765310751L;


    //租户下用户id
    private String tenantUserId ;
    //组织架构id
    private String departId ;
    //角色id列表
    private List<String> roleIds ;
    //业务关联id
    private String businessRelationId ;
    //业务类型，1为签章，2为模板，3为文档，4为业务线
    private Integer businessType ;

    //业务类型角色，具体数值参照枚举类,1印章管理员,2印章审计者,3印章使用者
    private List<Integer> businessTypeRoleList ;



}