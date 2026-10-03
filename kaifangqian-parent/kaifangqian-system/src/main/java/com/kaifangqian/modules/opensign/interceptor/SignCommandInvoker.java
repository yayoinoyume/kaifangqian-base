/**
 * @description 签署命令执行
 */
package com.kaifangqian.modules.opensign.interceptor;

import com.kaifangqian.modules.opensign.dto.SignTaskInfo;
import com.kaifangqian.modules.opensign.dto.SignTaskThreadlocalVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author : zhenghuihan
 * create at:  2022/2/23  3:43 PM
 * @description: 命令执行
 */
@Component
public class SignCommandInvoker extends SignAbstractCommandInterceptor {

    @Autowired
    private SignCommandContext signCommandContext;

    @Override
    public <T> T execute(final SignCommandConfig config, final SignCommand<T> command) {
        SignTaskThreadlocalVO threadlocalVO = SignTaskInfo.THREAD_LOCAL.get();
        signCommandContext.setSignRuId(threadlocalVO.getSignRuId());
        signCommandContext.setTaskId(threadlocalVO.getTaskId());
        signCommandContext.setTaskType(threadlocalVO.getTaskType());
        signCommandContext.setUserType(threadlocalVO.getUserType());
        signCommandContext.setUserTaskId(threadlocalVO.getUserTaskId());
        return command.execute(signCommandContext);
    }

    @Override
    public SignCommandInterceptor getNext() {
        return null;
    }

    @Override
    public void setNext(SignCommandInterceptor next) {
        throw new UnsupportedOperationException("CommandInvoker must be the last interceptor in the chain");
    }

}