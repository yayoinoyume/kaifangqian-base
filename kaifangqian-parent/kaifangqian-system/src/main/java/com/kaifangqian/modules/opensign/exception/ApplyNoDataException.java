/**
 * @description 申请执行无数据异常
 */
package com.kaifangqian.modules.opensign.exception;

/**
 * @Description: ApplyNoDataException
 * @Package: com.kaifangqian.modules.opensign.exception
 * @ClassName: ApplyNoDataException
 * @author: FengLai_Gong
 */
public class ApplyNoDataException  extends RuntimeException{

    public ApplyNoDataException(String message) {
        super(message);
    }
}