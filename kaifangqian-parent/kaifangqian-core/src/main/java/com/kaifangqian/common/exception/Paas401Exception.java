/**
 * @description Paas401Exception
 */
package com.kaifangqian.common.exception;
/**
 * @author : zhenghuihan
 * create at:  2021/4/8
 */
public class Paas401Exception extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public Paas401Exception(String message){
		super(message);
	}

	public Paas401Exception(Throwable cause)
	{
		super(cause);
	}

	public Paas401Exception(String message, Throwable cause)
	{
		super(message,cause);
	}
}
