/*
 * @description 资助审批电子签章系统
 */

import { defHttp } from '/@/utils/http/axios';

export function getWebsiteConfig() {
    return defHttp.get({ url: "/sys/websiteConfig",timeout: 1000 * 5});
}
