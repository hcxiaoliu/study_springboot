package com.xiaoliu.until;

import java.util.UUID;

/**
 * @author Administrator
 *
 */
public class IdTools {
	public static String returnFirmid() {
		return UUID.randomUUID().toString();
	}

}
