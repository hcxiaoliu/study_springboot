package com.xiaoliu.until;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 命令行工具
 */
public class RunCommand {
	private static Log log = LogFactory.getLog(RunCommand.class);
	
	public static String execute(String command){
		StringBuilder sb = new StringBuilder();
		Runtime run = Runtime.getRuntime();
		Process p = null;
		InputStream in = null;
		try {
			p = run.exec(command);
			in = p.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));
			String line = null;
			while((line = reader.readLine()) != null){
				sb.append(line);
			}
		} catch (Exception e) {
			log.debug("please install curl", e);
		} finally {
			try {
				if(in != null){
					in.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		String result = RunCommand.execute("curl httpbin.org/ip");
		System.out.println(result);
	}
}
