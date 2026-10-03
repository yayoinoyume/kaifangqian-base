package com.kaifangqian.modules.websocket;

import com.alibaba.fastjson.JSON;
import com.kaifangqian.dto.SendMailInfoDto;

import javax.websocket.DecodeException;
import javax.websocket.EndpointConfig;

/**
 * @author : zhenghuihan
 * create at:  2021/3/19  10:48 AM
 * @description: ServerDecoder
 */

public class ServerDecoder implements javax.websocket.Decoder.Text<SendMailInfoDto> {

    @Override
    public void destroy() {
    }

    @Override
    public void init(EndpointConfig arg0) {
    }

    @Override
    public SendMailInfoDto decode(String sysNoticeVO) throws DecodeException {
        return JSON.parseObject(sysNoticeVO, SendMailInfoDto.class);
    }

    @Override
    public boolean willDecode(String arg0) {
        return true;
    }

}