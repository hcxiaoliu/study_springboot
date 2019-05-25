package com.xiaoliu.until;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则验证工具
 */
public class RegexUtil {
	/**
	 * 手机号正则
	 */
	private static final String REGEX_MOBILE = "^0?1[3456789]\\d{9}";  

	/**
	 * 账号正则，字母开头，只能包含字母、数字、下划线，长度6-18
	 */
	private static final String ACCOUNT = "^[a-zA-Z][0-9a-zA-Z_]{5,17}";
	
	/**
	 * 中文
	 */
	private static final String CHINESE = "[\u4e00-\u9fa5]";
	
	/**
	 * IP地址+port正则
	 */
	private static final String IP_PORT = "(2(5[0-5]{1}|[0-4]\\d{1})|[0-1]?\\d{1,2})"
			+ "(\\.(2(5[0-5]{1}|[0-4]\\d{1})|[0-1]?\\d{1,2})){3}"
			+ "\\:\\d{1,5}";
	
	/**
	 * 是否手机号
	 * @param phone
	 * @return
	 */
	public static boolean isMobile(String phone){
		if(null == phone){
			return false;
		}
		return Pattern.matches(REGEX_MOBILE, phone);
	}
	
	/**
	 * 是否账号
	 * @return
	 */
	public static boolean isAccount(String account){
		if(account == null){
			return false;
		}
		return Pattern.matches(ACCOUNT, account);
	}
	
	/**
	 * 是否包含中文
	 * @param str
	 * @return
	 */
	public static boolean isContainChinese(String str) {
		if(str == null){
			return false;
		}
		Pattern p = Pattern.compile(CHINESE);
		Matcher m = p.matcher(str);
		if (m.find()) {
			return true;
		}
		return false;
	}
	
	/**
	 * 是否是host
	 * @param host
	 * @return
	 */
	public static boolean isIP_PORT(String host){
		if(host == null){
			return false;
		}
		return Pattern.matches(IP_PORT, host);
	}
	
	public static void main(String[] args) {
		System.out.println(isMobile("15728197368"));
		System.out.println(isAccount("1a12412_"));
		System.out.println(isContainChinese("1a1号412_"));
		System.out.println(isIP_PORT("192.168.1.255:80000"));
		System.out.println(Pattern.matches("(0|1)", "1"));;
	}
}
