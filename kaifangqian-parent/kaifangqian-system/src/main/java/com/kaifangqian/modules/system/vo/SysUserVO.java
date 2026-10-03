package com.kaifangqian.modules.system.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.kaifangqian.modules.system.entity.SysAppInfo;
import com.kaifangqian.modules.system.entity.TenantInfoExtend;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 用户VO
 * </p>
 *
 * @Author zhh
 */
@Data
public class SysUserVO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private String id;

    /**
     * 账号类型 phone，email
     */
    private String accountType;

    /**
     * 登录账号
     */
    private String username;

    /**
     * 真实姓名
     */
    private String realname;

    /**
     * 别称
     */
    private String nickName;

    /**
     * 密码
     */
    private String password;


    /**
     * 头像
     */
    private String avatar;

    /**
     * 生日
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    /**
     * 性别（1：男 2：女）
     */
    private Integer sex;

    /**
     * 电子邮件
     */
    private String email;

    private boolean emailEditFlag;

    /**
     * 手机
     */
    private String phone;

    private boolean phoneEditFlag;
    /**
     * 状态(1：正常  2：冻结 ）
     */
    private Integer status;

    /**
     * 工号，唯一键
     */
    private String workNo;
    /**
     * 职务
     */
    private String post;

    /**
     * 座机号
     */
    private String telephone;

    private String orgCodeTxt;
    /**
     * 所属部门
     */
    private List<String> departIds;
    /**
     * 管理部门
     */
    private List<String> manageDepartIds;

    private List<String> roleIds;

    private boolean passwordEditFlag;

    private Date createTime;

    private List<String> departNames;

    private List<String> roleNames;

    private String passwordLevel;

    private String jobAppId;

    private List<UserAuthGroupVO> authGroups;

    private String loginDepartId;

    private String loginDepartName;

    private String loginTenantId;

    private Integer loginTenantType;

    private String loginTenantName;

    private String personalTenantId;

    private String personalName;

    private Map<String, Object> personalTenant;

    private boolean initUserInfo;

    private boolean personalTenantFlag;

    private String tenantUserId;


    private String sysType;

    private SysAppInfo authInfo;
}
