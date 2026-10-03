package com.kaifangqian.api.impl;

import com.kaifangqian.api.PushMessageAPI;
import com.kaifangqian.dto.SendMailInfoDto;
import com.kaifangqian.modules.websocket.WebSocket;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
/**
 * @description 推送消息
 */

/**
 * @author : zhh
 * create at: 2022/9/16
 */
@Slf4j
@Component
@Primary
public class PushMessageAPIImpl implements PushMessageAPI {

    @Autowired
    private WebSocket webSocket;

    @Override
    public boolean pushMessage(String userId, SendMailInfoDto sendMailDto) {
        return webSocket.pushMessage(userId, sendMailDto);
    }

    @Override
    public boolean checkExit(String userId) {
        return webSocket.checkExit(userId);
    }
}