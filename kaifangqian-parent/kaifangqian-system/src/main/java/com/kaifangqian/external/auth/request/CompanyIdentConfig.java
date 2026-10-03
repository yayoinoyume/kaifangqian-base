/**
 * @description 电子签服务开通，创建企业用户请求参数
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
public class CompanyIdentConfig {
    private List<String> companyVerifyMethods;
    private List<String> unmodifiableParams;
}
