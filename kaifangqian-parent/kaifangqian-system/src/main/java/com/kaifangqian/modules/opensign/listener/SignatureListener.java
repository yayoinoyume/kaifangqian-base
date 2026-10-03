/**
 * @description 二维码手写签名监听器
 */
package com.kaifangqian.modules.opensign.listener;

import com.kaifangqian.modules.websocket.WebSocket;
import com.kaifangqian.common.redis.base.BaseMap;
import com.kaifangqian.common.redis.listener.RedisListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author : zhenghuihan
 * create at:  2022/9/16  11:01
 * @description: 二维码手写签名监听器
 */
@Component
public class SignatureListener implements RedisListener {
    @Autowired
    private WebSocket webSocket;

    @Override
    public void onMessage(BaseMap message) {
        String userId = message.get("userId");
        String signature = message.get("signature");

        webSocket.pushSignature(userId, signature);
    }
}