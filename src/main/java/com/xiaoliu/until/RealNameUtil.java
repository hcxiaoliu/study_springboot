package com.xiaoliu.until;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class RealNameUtil {
    public static void main(String[] args) throws  Exception{
    	String host = "https://naidcard.market.alicloudapi.com";
	    String path = "/nidCard";
        String appcode = "799b1734f6c349c1b6a11da59d61ab86";
        String idCard = "*****";
        String name = "****"; 
        String urlSend = host + path + "?idCard=" + idCard + "&name=" + name;
		
        URL url = new URL(urlSend);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestProperty("Authorization", "APPCODE " + appcode);//格式Authorization:APPCODE (中间是英文空格)
        int httpCode = httpURLConnection.getResponseCode();
        String json = read(httpURLConnection.getInputStream());
        System.out.println("/* 获取服务器响应状态码 200 正常；400 权限错误 ； 403 次数用完； */ ");
        System.out.println(httpCode);
        System.out.println("/* 获取返回的json */ ");
        System.out.print(json);
    }
    /**
     * 实名认证的调用方法
     * @param name  会员姓名
     * @param idCard 会员身份号码
     * @return 返回实名验证的结果："status":"01","msg":"实名认证通过！" 
     * @throws Exception
     */
    public static String realName(String name,String idCard) throws Exception {
		/*
		 * String host = "https://naidcard.market.alicloudapi.com"; String path =
		 * "/nidCard";
		 */
	    
	    String host = "https://idcardcert.market.alicloudapi.com"; 
	    String path = "/idCardCert";
        String appcode = "799b1734f6c349c1b6a11da59d61ab86";
        String urlSend = host + path + "?idCard=" + idCard + "&name=" + name;
        URL url = new URL(urlSend);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestProperty("Authorization", "APPCODE " + appcode);//格式Authorization:APPCODE (中间是英文空格)
        int httpCode = httpURLConnection.getResponseCode();
        String json = read(httpURLConnection.getInputStream());
        System.out.println("/* 获取服务器响应状态码 200 正常；400 权限错误 ； 403 次数用完； */ ");
        System.out.println(httpCode);
        System.out.println("/* 获取返回的json   */ ");
        System.out.print(json);
        return json;
    }
    /*
        读取返回结果
     */
    private static String read(InputStream is) throws IOException {
        StringBuffer sb = new StringBuffer();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String line = null;
        while ((line = br.readLine()) != null) {
            line = new String(line.getBytes(), "utf-8");
            sb.append(line);
        }
        br.close();
       return sb.toString();
    }
}