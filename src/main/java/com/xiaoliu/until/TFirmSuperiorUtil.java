package com.xiaoliu.until;

/**
 * 推荐码生成工具
 */
public class TFirmSuperiorUtil {
	
	private static final long SUB_NUMBER = 0x3d333333L;
	/**
	 * 转换手机号为推荐码
	 * @param phone 手机号 
	 * @return 推荐码
	 */
	public static String encryptPhone(String phone){
		if(!RegexUtil.isMobile(phone)){
			throw new IllegalArgumentException("手机号格式不正确！");
		}
		long n = Long.valueOf(phone);
		n = n - SUB_NUMBER;
		phone = String.valueOf(n).substring(1);
		return phone;
	}
	
	/**
	 * 转换推荐码为手机号
	 * @param recommendCode 推荐码
	 * @return 手机号
	 */
	public static String decryptPhone(String recommendCode){
		recommendCode = '1' + recommendCode;
		long phone = Long.valueOf(recommendCode);
		phone = phone + SUB_NUMBER;
		String ret = String.valueOf(phone);
		if(!RegexUtil.isMobile(ret)){
			throw new IllegalArgumentException("推荐码格式不正确！");
		}
		return ret;
	}
	
	/**
	 * 默認推薦碼
	 * @return
	 */
	public static String defaultRecommend(){
		return encryptPhone("19999999999");
	}
	
	public static void main(String[] args) {
		System.out.println(encryptPhone("13556059527"));
		System.out.println(decryptPhone("7408967157"));
		System.out.println(Long.toHexString(1026765619L));
	}
}
