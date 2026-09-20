/**
 * [类功能描述：授权服务]
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
package com.kaifangqian.common.aspect;

import com.alibaba.fastjson.JSONObject;
import com.kaifangqian.common.system.vo.Authorization;
import com.kaifangqian.common.util.RsaUtils;
import com.kaifangqian.utils.MyStringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: zhh
 */
@Component
@Slf4j
public class LicenseBean implements ApplicationRunner {
    public static Authorization grant;
    @Value("${service.token}")
    private String license;
    String privateKey = "MIICeAIBADANBgkqhkiG9w0BAQEFAASCAmIwggJeAgEAAoGBALYW9GOLSx0FXuC5WtR+U9X/N9O/yhqtwoCJM0DOeRK5Tgl+pSAt3mZ7EAi342gXl2dOdlXwXW1ZfL3Zd2al84ACAfGbLIYUzxACn7Y7wv+8DvAnJTBeRfLrZ16aT8O4H7DKWwqbBA04BK1HRLCyxs2F7k/K7vrGTU3yTz9omdkVAgMBAAECgYEAr9uPf6wBiS+sqCCbZmnzEdQA2NJ7oDR8iqL3Cvnd2IV6ppTXaTKjfhoQLDtctyVBphYTF4Ci2n74iGpEdLCFb1FFe1/IorEcLSJ5ahiQidr0Ufc6XzF76yVyIkU5rjgIY8LMg0UUbdTssq0i56mXgUMzJp7pBwrihkc8aG8igcECQQD0VfoPKRyjfyjKx8ldzBCF2woX4dK1brSkIz5LWk6PjHc5JsDy7KFkn4riVPbtwrymQ1r86ZafdqJgZBMoUbS5AkEAvshEwvrJbjXe/R8Zogl3FJ+kv7yMiYftABVxwvNXLEDUKfGuQYeAfxIbqipxMvXEzsq/aFEIqa8FKMOPq22RPQJAJJ9KZsFTwJHLrHE7lmqCw31sSt4XNgiM3NlHegXkJpH4QMG1Q/QB0NI0/+2aQVLh8c3Aso3UfLxMZEQ7ttxgSQJBAIPMYMx+aoerybf+Mzwg49Yoj60x+bjNYWpsZiHy8CcPRkMPxn1YuemPPfNpzLgS13qw0FilmqF22s6Vg3w/flUCQQCTt1zHJDj0WbEDtaVxv0XwlYjXo0JGPRtSq6RUAsznWpHacmNEO1+pI7BBMJv+fX6SaGJVEQ3Q6qrm4jaHxK+M";

    public Authorization getGrant() {
        if (MyStringUtils.isBlank(license)) {
            log.info("未配置软件使用授权码，使用本地默认授权");
            return localDefaultGrant();
        }
        try {
            String rs = RsaUtils.decrypt(license, privateKey);
            Authorization grant = JSONObject.parseObject(rs, Authorization.class);
            if (grant != null) {
                return grant;
            }
            log.warn("软件授权码内容为空，使用本地默认授权");
        } catch (Exception e) {
            log.warn("软件授权码校验失败，使用本地默认授权：{}", e.getMessage());
        }
        return localDefaultGrant();
    }

    /**
     * 本地私有化部署的默认授权对象。
     *
     * 私有化场景不再依赖官方 RSA 签发的 service.token：当授权码缺失或校验失败时，
     * 回退到功能全开的本地授权，避免旧逻辑中的 System.exit(0) 导致服务无法启动。
     * 若配置了合法的 service.token，仍优先使用官方授权内容（保留原校验路径）。
     */
    private Authorization localDefaultGrant() {
        Authorization grant = new Authorization();
        grant.setVersion("本地私有化版");
        grant.setEnvironment("prod");
        grant.setLicenseStart(parseDate("2025-01-01"));
        grant.setLicenseExpire(parseDate("2099-12-31"));
        grant.setTemplateUseFlag(true);
        grant.setTemplateCeiling(1000);
        grant.setTemplateScope("");
        grant.setBusinessLineUseFlag(true);
        grant.setBusinessLineCeiling(1000);
        grant.setApiAuthorizationUseFlag(true);
        grant.setApiAuthorizationCeiling(999);
        grant.setCoreFirmUseFlag(true);
        grant.setCoreFirmCeiling(999);
        grant.setFaceRecognitionUseFlag(true);
        grant.setDocumentsCeiling(5);
        grant.setPagingSealUseFlag(true);
        grant.setWebsiteCustomizateUseFlag(true);
        return grant;
    }

    private Date parseDate(String text) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(text);
        } catch (Exception e) {
            return new Date();
        }
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        this.grant = getGrant();
    }
}
