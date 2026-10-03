/**
 * @description 结束流程命令
 */
package com.kaifangqian.modules.opensign.service.cmd;

import com.kaifangqian.modules.opensign.interceptor.SignCommand;
import com.kaifangqian.modules.opensign.interceptor.SignCommandContext;
import com.kaifangqian.modules.opensign.service.flow.IFlowService;
import com.kaifangqian.dto.MailDto;
import com.kaifangqian.eunms.MesAuthType;
import com.kaifangqian.eunms.SendType;
import com.kaifangqian.modules.opensign.dto.TaskCmdInfo;
import com.kaifangqian.modules.opensign.entity.SignRu;
import com.kaifangqian.modules.opensign.enums.SignRuStatusEnum;
import com.kaifangqian.modules.opensign.service.ru.SignRuService;
import com.kaifangqian.utils.SysMessageUtil;

import java.util.*;

/**
 * @author : zhenghuihan
 * create at:  2023/11/8  15:55
 * @description: 结束流程命令
 */
public class FinishFlowCmd implements SignCommand<TaskCmdInfo> {

    @Override
    public TaskCmdInfo execute(SignCommandContext signCommandContext) {
        SignRuService signRuService = signCommandContext.getSignRuService();
        SysMessageUtil sysMessageUtil = signCommandContext.getSysMessageUtil();
        SignRu signRu = signRuService.getById(signCommandContext.getSignRuId());
        signRu.setStatus(SignRuStatusEnum.DONE.getCode());
        signRu.setFinishTime(new Date());
        signRuService.updateById(signRu);

        MailDto mailDto = new MailDto();
        mailDto.setSendType(SendType.IMMEDIATELY);

        Map<MesAuthType, List<String>> userMap = new HashMap<>();
        List<String> userIds = Arrays.asList(signRu.getSysUserId());
        userMap.put(MesAuthType.USER, userIds);
        mailDto.setReceivers(userMap);

        mailDto.setTemplateCode("sign_done");

        Map<String, String> titleParaMap = new HashMap<>();
        titleParaMap.put("contract", signRu.getSubject());
        mailDto.setTitleParaMap(titleParaMap);

        Map<String, String> contentParaMap = new HashMap<>();
        contentParaMap.put("contract", signRu.getSubject());
        mailDto.setContentParaMap(contentParaMap);

        Map<String, Map<String, String>> buttonParaMap = new HashMap<>();
        Map<String, String> para = new HashMap<>();
        para.put("__full__", "");
        para.put("from", "list");
        para.put("signRuId", signRu.getId());
        buttonParaMap.put("sign_complete", para);
        mailDto.setButtonParaMap(buttonParaMap);

        //发送通知
        sysMessageUtil.asyncSendMail(mailDto);

        //生成报告
        IFlowService flowService = signCommandContext.getFlowService();
        //flowService.signReportAndSave(signCommandContext.getSignRuId());

        return null;
    }
}