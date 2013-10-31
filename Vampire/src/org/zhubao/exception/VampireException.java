/**
 * 
 */
package org.zhubao.exception;

import org.zhubao.util.ExceptionMapping;

/**
 * @author Jason.Zhu
 * @date   2013-10-15
 * @email jasonzhu@augmentum.com.cn
 */
public class VampireException extends RuntimeException{


	private static final long serialVersionUID = 1L;
	private Integer errorCode;
	
	public VampireException() {
		super();
		
		this.errorCode = 0;
	}
	
	public VampireException(Integer errorCode) {
	    
		super(ExceptionMapping.lookUpErrorMessage(errorCode));
		
		this.errorCode = errorCode;
	}

	public VampireException(String msg, Integer errorCode) {
		super(msg);
		
		this.errorCode = errorCode;
	}

	public VampireException(String msg, Throwable cause, Integer errorCode) {
		super(msg, cause);
		
		this.errorCode = errorCode;
	}

	public VampireException(Throwable cause, Integer errorCode) {
		super(cause);
		
		this.errorCode = errorCode;
	}

	public Integer getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}
	
	
}
