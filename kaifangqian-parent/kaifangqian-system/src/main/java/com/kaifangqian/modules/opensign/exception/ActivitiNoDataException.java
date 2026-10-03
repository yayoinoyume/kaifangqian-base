/**
 * @description 签署任务执行无数据异常
 */
package com.kaifangqian.modules.opensign.exception;

/**
 * @Description: ActivitiNoDataException
 * @Package: com.kaifangqian.modules.opensign.exception
 * @ClassName: ActivitiNoDataException
 * @author: FengLai_Gong
 */
public class ActivitiNoDataException extends RuntimeException{

    public ActivitiNoDataException(String message) {
        super(message);
    }
}