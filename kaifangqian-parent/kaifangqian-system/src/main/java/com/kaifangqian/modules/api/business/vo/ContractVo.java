/**
 * @description 个人用户签署代理服务
 */
package com.kaifangqian.modules.api.business.vo;

import com.kaifangqian.modules.opensign.entity.*;
import com.kaifangqian.modules.system.entity.SysTenantInfo;
import com.kaifangqian.modules.system.entity.SysTenantUser;
import com.kaifangqian.modules.system.entity.SysUser;
import com.kaifangqian.modules.api.vo.base.ContractSigner;
import com.kaifangqian.modules.opensign.entity.*;
import com.kaifangqian.modules.storage.entity.AnnexStorage;
import lombok.Data;

import java.io.Serializable;
import java.util.*;

/**
 * @Description: 合同操作业务传递数据对象
 * @Package: com.kaifangqian.modules.api.business.vo
 * @ClassName: ContractVo
 * @author: FengLai_Gong
 * @Date: 2024/5/23 10:09
 */
@Data
public class ContractVo implements Serializable {

    private static final long serialVersionUID = -8721589770061493626L;

    //账户数据
    private SysUser sysUser ;
    //租户数据
    private SysTenantInfo tenantInfo ;
    //租户下用户数据
    private SysTenantUser tenantUser ;
    //业务线主数据
    private SignRe signRe ;
    //业务线发起人
    private SignReSigner reSignerSender ;
    //业务线发起人id
    private String reSignerSenderId ;
    //业务线个人接收方列表
    private List<SignReSigner> reSingerReceiverPersonalList ;
    //业务线企业接收方列表
    private List<SignReSigner> reSingerReceiverEntList ;
    //业务线签约文件列表
    private List<SignReDoc> signReDocList ;
    //业务线填写控件参数配置
    private List<SignReDocParam> reParamList ;


    //请求参数中合同签署人map，key为签署人顺序，value为签署人对象数据
    private Map<String, ContractSigner> contractOrderMap ;
    //到期时间
    private Date expireDate ;

    //业务线实例
    private SignRu signRu ;



    private List<String> templateIdList = new ArrayList<>();

    //业务线实例-新追加的签约文件列表
    private List<AnnexStorage> mainFileList = new ArrayList<>();
    //业务线实例-追加的附件列表
    private List<String> otherFileList = new ArrayList<>();

}