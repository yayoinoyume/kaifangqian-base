/**
 * @description 电子印章-文件验签
 */
package com.kaifangqian.modules.opensign.controller;

import com.alibaba.fastjson.JSONObject;
import com.kaifangqian.annotation.ResrunLogModule;
import com.kaifangqian.common.vo.Result;
import com.kaifangqian.modules.opensign.enums.SignStatus;
import com.kaifangqian.modules.opensign.service.verify.SignVerifyService;
// import io.swagger.annotations.Api;
// import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.kaifangqian.config.limit.annotation.Limit;
import com.kaifangqian.config.limit.annotation.LimitHandleType;
import com.kaifangqian.config.limit.annotation.LimitType;
import com.kaifangqian.config.limit.annotation.OperateType;
/**
 * @Description: SignVerifyController
 * @Package: com.kaifangqian.modules.opensign.controller
 * @ClassName: SignVerifyController
 * @author: Fusion
 * CreateTime:  2023/8/20  9:53
 * @copyright 本平台运营方
 */
@Slf4j
@RestController
@RequestMapping("/sign/verify")
@ResrunLogModule(name = "文件验签")
// @Api(tags = "电子印章-文件验签")
public class SignVerifyController {

    @Autowired
    private SignVerifyService signVerifyService;

    //处理文件上传请求
    @PostMapping("/checkSign")
    // @ApiOperation(value = "文件验签", notes = "文件验签")
    @Limit(name = "文件验签", prefix = "limit",limitType= LimitType.IP, operateType = OperateType.ALL, count = 5,period=60,limitHandle = LimitHandleType.NONE)
    public Result<?> uploadFile(@RequestParam("file") MultipartFile file) {
        Result<JSONObject> result = new Result<>();
        try {
            result= signVerifyService.getImageFromPdf(file);
        } catch (Exception e) {
            log.error("文件验签失败", e.getMessage());
            return  Result.error(SignStatus.SIGN_STATUS_NOSIGNATURE.getMsg());
        }
        return  result;
    }




}
