package com.xiaoliu.until;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestUtil {
	public static void main(String[] args) throws ParseException {
		System.out.println(new SimpleDateFormat("yyyy").parse("2100").getTime());
		System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(new Date(4102416000000L)));
		System.out.println(TFirmPasswordUtil.encryptTradepassword("ac237a01-4ee4-47b9-8339-dbde9c5c0e55", "123456"));;
	}
}
