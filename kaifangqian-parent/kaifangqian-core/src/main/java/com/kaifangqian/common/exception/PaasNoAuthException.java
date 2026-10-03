/**
 * @description PaasNoAuthException
 */
package com.kaifangqian.common.exception;

/**
 * @author : zhenghuihan
 * create at: 2022/6/6
 */
public class PaasNoAuthException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public PaasNoAuthException(String message){
		super(message);
	}

	public PaasNoAuthException(Throwable cause)
	{
		super(cause);
	}

	public PaasNoAuthException(String message, Throwable cause)
	{
		super(message,cause);
	}
}
