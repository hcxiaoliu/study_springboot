package com.xiaoliu.until;

import java.util.Random;

/**
 * 生成器工具
 */
public class Generator {
	
	/**
	 * 生成短信验证码
	 * @param len 验证码长度
	 * @return
	 */
	public static String smsCode(int len) {
		String result = "";
		Random r = new Random();
		for(;len > 0;len--) {
			result += r.nextInt(10);
		}
		return result;
	}
}
