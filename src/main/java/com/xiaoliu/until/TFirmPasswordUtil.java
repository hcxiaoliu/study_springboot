package com.xiaoliu.until;

/**
 * 会员加密工具
 * @author Administrator
 * 不能该
 */
public class TFirmPasswordUtil {
	
	/**
	 * 加密交易密码
	 * @param firmid
	 * @param tradepassword
	 * @return
	 */
	public static String encryptTradepassword(String firmid, String tradepassword) {
		return MD5Util.MD5(firmid.substring(5) + tradepassword);
	}
	
	/**
	 * 加密登录密码
	 * @param firmid
	 * @param password
	 * @return
	 */
	public static String encryptPassword(String firmid, String password) {
		return MD5Util.MD5(firmid.substring(6) + password);
	}
	
	public static void main(String[] args) {
		System.out.println(encryptTradepassword("c19f6b6a-5ea1-4030-ba7c-734350b6ca3f", "123456"));;
	}
}
