/**
 * @description 签字二维码
 */
package com.kaifangqian.modules.opensign.dto;

import lombok.Data;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.NotEmpty;

/**
 * @author : zhenghuihan
 * create at:  2024/1/16  18:20
 * @description:
 */
@Data
public class SignaturePicVO {
    @NotEmpty String key;
    @NotEmpty String signature;
}