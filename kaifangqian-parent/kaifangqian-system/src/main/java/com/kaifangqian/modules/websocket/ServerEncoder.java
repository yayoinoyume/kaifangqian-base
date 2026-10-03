package com.kaifangqian.modules.websocket;

import com.alibaba.fastjson.JSON;
import com.kaifangqian.dto.SendMailInfoDto;

import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

/**
 * @author : zhenghuihan
 * create at:  2021/3/19  10:44 AM
 * @description: ServerEncoder
 */

public class ServerEncoder implements Encoder.Text<SendMailInfoDto> {

    @Override
    public void destroy() {
    }

    @Override
    public void init(EndpointConfig arg0) {
    }

    @Override
    public String encode(SendMailInfoDto sysNoticeVO) throws EncodeException {
        return JSON.toJSONString(sysNoticeVO);
    }

}