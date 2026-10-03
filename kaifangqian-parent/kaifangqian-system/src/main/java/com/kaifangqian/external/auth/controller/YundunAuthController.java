/**
 * @description 云盾实名认证，电子签服务开通
 */
package com.kaifangqian.external.auth.controller;

import com.kaifangqian.external.auth.request.AuthUrlRequest;
import com.kaifangqian.external.auth.service.IdentityAuthExternal;
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
// @Api(tags = "云盾实名认证")
@RestController
@RequestMapping("/yundun/auth")
@Slf4j
public class YundunAuthController {

    @Autowired
    private IdentityAuthExternal identityAuthExternal;

    /**
     * 个人实名认证
     * @return
     */
    // @ApiOperation(value = "个人实名认证", notes = "个人实名认证")
    @PostMapping(value = "/personal/add")
    public Result<?> personalAuth(@RequestBody AuthUrlRequest authUrlRequest) throws Exception {
        return Result.OK(identityAuthExternal.personalIdentityAuth(authUrlRequest.getCallbackPage()));
    }

    /**
     * 个人实名认证
     * @return
     */
    // @ApiOperation(value = "个人实名认证更新", notes = "个人实名认证更新")
    @PostMapping(value = "/personal/update")
    public Result<?> personalAuthUpdate(@RequestBody AuthUrlRequest authUrlRequest) throws Exception {
        return Result.OK(identityAuthExternal.personalIdentityAuthUpdate(authUrlRequest.getCallbackPage()));
    }

    /**
     * 企业实名认证
     * @return
     */
    // @ApiOperation(value = "企业实名认证", notes = "企业实名认证")
    @PostMapping(value = "/enterprise/add")
    public Result<?> enterpriseAuth(@RequestBody AuthUrlRequest authUrlRequest) throws Exception {
        return Result.OK(identityAuthExternal.companyIdentityAuth(authUrlRequest.getCallbackPage()));
    }

    /**
     * 企业实名认证
     * @return
     */
    // @ApiOperation(value = "企业实名认证更新", notes = "企业实名认证更新")
    @PostMapping(value = "/enterprise/update")
    public Result<?> enterpriseAuthUpdate(@RequestBody AuthUrlRequest authUrlRequest) throws Exception {
        return Result.OK(identityAuthExternal.companyIdentityAuthUpdate(authUrlRequest.getCallbackPage()));
    }

}
