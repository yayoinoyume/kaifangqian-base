/**
 * @description 本地签名证书口令配置绑定验证
 *
 * Copyright (C) [2025] [版权所有者（北京资源律动科技有限公司）]. All rights reserved.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 *
 * 注意：本代码基于 AGPLv3 协议发布。若通过网络提供服务（如 Web 应用），
 * 必须公开修改后的完整源代码（包括衍生作品），详见协议全文。
 */
package com.kaifangqian.modules.opensign.sign;

import org.junit.jupiter.api.Test;
import org.springframework.boot.env.YamlPropertySourceLoader;
import org.springframework.core.env.PropertySource;
import org.springframework.core.env.StandardEnvironment;
import org.springframework.core.env.SystemEnvironmentPropertySource;
import org.springframework.core.io.ClassPathResource;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 验证 application-prod.yml 中 kfq.local-ca.password 显式绑定部署环境变量 KFQ_LOCAL_CA_PASSWORD。
 *
 * <p>背景：PdfSignService 读取的属性名是 kfq.local-ca.password（连字符），
 * 为消除“松散绑定只认 kfq.local.ca.password（点号）”的歧义，prod profile 显式写出映射关系。
 * 本测试锁定该显式映射，防止后续被误删。</p>
 *
 * <p>本测试只使用占位符测试值，不涉及任何真实口令。</p>
 */
class LocalCaPasswordBindingTest {

    private static final String PROPERTY = "kfq.local-ca.password";
    private static final String ENV_VAR = "KFQ_LOCAL_CA_PASSWORD";

    @Test
    void prodProfileExplicitlyMapsLocalCaPasswordToEnvVar() throws Exception {
        PropertySource<?> prod = loadProdPropertySource();

        String raw = (String) prod.getProperty(PROPERTY);
        assertEquals("${" + ENV_VAR + ":}", raw,
                "application-prod.yml 必须显式将 kfq.local-ca.password 映射到 " + ENV_VAR);

        StandardEnvironment environment = new StandardEnvironment();
        environment.getPropertySources().addFirst(new SystemEnvironmentPropertySource(
                "test-env", Collections.singletonMap(ENV_VAR, "unit-test-password")));
        environment.getPropertySources().addLast(prod);

        assertEquals("unit-test-password", environment.resolveRequiredPlaceholders(raw),
                "占位符必须解析为环境变量 " + ENV_VAR + " 的值");
    }

    private PropertySource<?> loadProdPropertySource() throws Exception {
        List<PropertySource<?>> sources = new YamlPropertySourceLoader()
                .load("application-prod", new ClassPathResource("application-prod.yml"));
        return sources.get(0);
    }
}
