/**
 * @description 用户意愿校验接口类，短信验证码、密码、人脸识别等验证
 */
package com.kaifangqian.modules.opensign.service.confirm;

import com.kaifangqian.modules.opensign.service.business.vo.SignReportSignSubVO;
import com.kaifangqian.common.vo.Result;
import com.kaifangqian.modules.opensign.vo.base.UserConfirmByCodeVO;
import com.kaifangqian.modules.opensign.vo.base.UserConfirmByPasswordVO;

import java.util.Map;

/**
 * @author : zhenghuihan
 * create at:  2024/4/2  15:14
 * @description:
 */
public interface IUserConfirmService {

    String sendMessage(String orderNo);

    String sendEmail(String orderNo);

    Result<?> confirmByPhoneEmail(UserConfirmByCodeVO vo);

    Result<?> confirmByPassword(UserConfirmByPasswordVO vo);

    String getFaceUrl(String orderNo, String redirectUrl);

    Boolean checkSign(String orderNo, String taskId, String operateType);

    String queryAndRecord(String httpType, String url, Map<String, String> headers, Map<String, String> params, String requestBody);

    void getQCloudToken();

    boolean updateFaceResult(String orderNo);

    void bindFaceFile();

    String getMyConfirmType();

    SignReportSignSubVO getConfirmInfoByTaskId(String taskId);

    String getFaceResult(String orderNo, String getFile);
}