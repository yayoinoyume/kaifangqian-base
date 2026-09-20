package com.kaifangqian.external.sms.service.impl;

import com.kaifangqian.external.base.CommonResult;
import com.kaifangqian.external.sms.request.MsgRequest;
import com.kaifangqian.external.sms.service.SmsSendService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 本地短信通道。
 *
 * 验证码由调用方生成并写入 Redis，本实现只负责记录验证码，不再调用任何外部短信服务。
 */
@Service
@Slf4j
public class SmsSendServiceImpl implements SmsSendService {

    @Override
    public CommonResult<?> sendMsg(MsgRequest msgRequest) {
        String phone = msgRequest == null ? null : msgRequest.getPhoneNumbers();
        String templateName = msgRequest == null ? null : msgRequest.getTemplateName();
        String code = msgRequest == null || msgRequest.getParams() == null
                ? null : msgRequest.getParams().get("code");
        log.info("[本地短信] phone={}, template={}, code={}（未发送真实短信）", phone, templateName, code);

        CommonResult<Object> result = new CommonResult<>();
        result.setCode(200);
        result.setMessage("本地短信通道：验证码已生成，未发送真实短信");
        result.setTimestamp(System.currentTimeMillis());
        return result;
    }
}
