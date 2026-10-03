/**
 * @description 云盾同步回调页面跳转业务逻辑
 */
package com.kaifangqian.external.auth.controller;

import com.kaifangqian.external.auth.response.CallbakcPageResponse;
import com.kaifangqian.common.redis.util.RedisUtil;
import com.kaifangqian.common.vo.Result;
// import io.swagger.annotations.Api;
// import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author : yxb
 * create at: 2025/6/6
 */
// @Api(tags = "云盾同步回调业务逻辑")
@RestController
@RequestMapping("/yundun/callback")
@Slf4j
public class YundunCallbackPageController {

    @Autowired
    private RedisUtil redisUtil;

    /**
     * 云盾回调逻辑处理
     * @return
     */
    // @ApiOperation(value = "云盾同步回到跳转页面逻辑", notes = "云盾同步回到跳转页面逻辑")
    @GetMapping(value = "/page")
    public Result<?> callbackPage(String token) throws Exception {
        String callbackPage = (String) redisUtil.get(token);
        CallbakcPageResponse callbackPageResponse = new CallbakcPageResponse();
        callbackPageResponse.setToken(callbackPage);
        return Result.OK(callbackPageResponse);
    }

}
