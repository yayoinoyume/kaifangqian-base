/**
 * @description 数据权限查询规则容器工具类
 */
package com.kaifangqian.common.system.util;

import com.kaifangqian.common.system.vo.SysPermissionDataRuleModel;
import com.kaifangqian.common.util.SpringContextUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author : zhenghuihan
 * create at: 2023/12/18
 */
public class PaasDataAutorUtils {

    public static final String MENU_DATA_AUTHOR_RULES = "MENU_DATA_AUTHOR_RULES";

    /**
     * 往链接请求里面，传入数据查询条件
     *
     * @param request
     * @param dataRules
     */
    public static synchronized void installDataSearchConditon(HttpServletRequest request, List<List<List<List<SysPermissionDataRuleModel>>>> dataRules) {
        request.setAttribute(MENU_DATA_AUTHOR_RULES, dataRules);
    }

    /**
     * 获取请求对应的数据权限规则
     *
     * @returnMENU_DATA_AUTHOR_RULES
     */
    @SuppressWarnings("unchecked")
    public static synchronized List<List<List<List<SysPermissionDataRuleModel>>>> loadDataSearchConditon() {
        return (List<List<List<List<SysPermissionDataRuleModel>>>>) SpringContextUtils.getHttpServletRequest().getAttribute(MENU_DATA_AUTHOR_RULES);
    }
}
