package com.xiaoliu.until;

import java.util.HashMap;
import java.util.Map;


import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

/**
 * 阿里云短信接口
 */
public class AliSmsUtil {
	private static String host = "https://fesms.market.alicloudapi.com";
	private static String path = "/sms/";
	private static String method = "GET";
	private static String appcode = "c2df5d37c8804ab1876df51400f7bb74";
	private static Map<String, String> headers = null;
	
	static{
		headers = new HashMap<>();
		headers.put("Authorization", "APPCODE " + appcode);
	}

	public static JSONObject sendCode(Map<String, String> querys){
		try {
			HttpResponse response = HttpUtils.doGet(host, path, method, headers, querys);
			int statusCode = response.getStatusLine().getStatusCode();
			if(statusCode == 200){
				return JSONObject.parseObject(EntityUtils.toString(response.getEntity()));
			} else {
				JSONObject error = new JSONObject();
				error.put("Code", statusCode);
				return error;
			}
		} catch (Exception e) {
//			e.printStackTrace();
		}
		return null;
	}
	public static void main(String[] args) {
		Map<String, String> querys = new HashMap<>();
		querys.put("code", "12345678");
	    querys.put("phone", "13229574249");
	    querys.put("skin", "900434");
	    querys.put("sign", "500274");
	    System.out.println(sendCode(querys));
	}
}
