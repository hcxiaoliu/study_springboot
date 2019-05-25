package com.xiaoliu.constant;

/**
 * 一些key的前缀或hash的属性名
 * @author LIU QIAN
 * 2019年3月26日 下午3:23:32
 */
public interface RedisConstant {

	/**
	 * token的一些常量
	 */
	public static interface Token {
		public final static String SESSION_PREFIX = "token:session:"; // 登录用户的会话信息前缀
		
		public final static String TOKEN_PREFIX = "token:token:"; // 登录用户的会话信息前缀
		
		public final static String USER_PREFIX = "token:user:"; // 登录用户的详细信息
		
		public final static String SESSION_USERID_FIELD = "userid"; // 会话中的用户ID属性名
		
		public final static String SESSION_LAST_ACCESS_TIME_FIELD = "lastAccessTime"; // 会话中的最后访问时间属性名
		
		public final static String SESSION_LOGIN_TIME_FIELD = "loginTime"; // 会话中的登录时间属性名
		
	}
	
	// 短信验证码前缀，后面加手机号
	public final static String VALIDATE_CODE = "validateCode:"; 
	
	/**
	 * 大米价格限制
	 * @author LIU QIAN
	 * 2019年4月10日 下午3:28:56
	 */
	public static interface LimitPrice {
		public final static String PREFIX = "LimitPrice:";
		
		public final static String RICE = "rice";
	}
	
	/**
	 * 定时送大米时间
	 */
	public static final String GIVE_RICE_HOURS = "giveRiceHours";
	
	/**
	 * websocket-redis
	 * @author LIU QIAN
	 * 2019年4月29日 下午3:45:24
	 */
	public static interface WebSocket {
		/**
		 * 前缀
		 */
		public static final String PREFIX = "WebSocket:";
		
		/**
		 * 客户端连接记录：WebSocket:clients:${host}=${userid}
		 * 数据结构：set
		 */
		public static final String CLIENTS = PREFIX + "clients:";
		
		/**
		 * 启动服务器的host, ip:port
		 * 数据结构：set
		 */
		public static final String SERVER_HOST = PREFIX + "HOSTS";
		
		/**
		 * 未发送消息：WebSocket:unsent_msg:{userid}={messages}
		 * 数据结构：list
		 */
		public static final String UNSENT_MSG = PREFIX + "unsent_msg:";
	}
	
	/**
	 * 微信access_token
	 */
	public static final String ACCESS_TOKEN = "wx:access_token";
	
	public static final String TICKET = "wx:ticket";
}
