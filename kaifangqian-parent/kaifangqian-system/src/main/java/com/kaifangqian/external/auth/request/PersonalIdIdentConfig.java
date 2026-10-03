/**
 * @description 电子签服务开通，创建个人用户请求参数
 */
package com.kaifangqian.external.auth.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

/**
 * @author : yxb
 * create at: 2025/6/6
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonalIdIdentConfig {
    private List<String> personVerifyMethods;
    private List<String> unmodifiableParams;
}
