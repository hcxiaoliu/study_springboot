package com.xiaoliu.exception;


import com.xiaoliu.constant.Enums;

/**
 * Created by 路人甲 on 2019/5/25 11:32
 */
public class AppException extends RuntimeException {
	

	private static final long serialVersionUID = 1L;
	private int code = -1;
	
	public AppException(int code, String message) {
		super(message);
		this.code = code;
	}
	
	public AppException(String message) {
		super(message);
	}
	
	public AppException(Enums.RestState state) {
		super(state.getMsg());
		this.code = state.getCode();
	}
	
	public final int getCode() {
		return code;
	}

}
