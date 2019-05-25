package com.xiaoliu.constant;

/**
 * 共享的枚举类的外部类
 * 注意：一定要是多个项目之间共享的枚举类而且是不常改动的才放这里
 */
public interface Enums {

	/**
	 * Created by 路人甲 on 2019/5/25 11:32
	 * 请求状态码
	 */
	public static enum RestState {
		
		OK(200, "操作成功!"), FORBIDDEN(403,"请登录！"), NONEXISTENT(404, "不存在!")
		,SECURITY(400,"安全检查!"), ERROR(500,"系统繁忙!"), UNKOWN(0,"未知异常!");
		
		private int code;
		
		private String msg;
		
		RestState(int code, String msg){
			this.code = code;
			this.msg = msg;
		}

		public final int getCode() {
			return code;
		}
	
		public final void setCode(int code) {
			this.code = code;
		}

		public final String getMsg() {
			return msg;
		}

		public final void setMsg(String msg) {
			this.msg = msg;
		}
		
	}
	
	/**
	 * 会员状态

	 */
	public static enum TFirmStatus {
		
		未实名(0), 已实名(1), 被封号(2);
		
		private int code;
		
		TFirmStatus(int code){
			this.code = code;
		}

		public final int getCode() {
			return code;
		}

		public final void setCode(int code) {
			this.code = code;
		}
		
		public final boolean eq(int code){
			return this.code == code;
		}
		
		/**
		 * 根据code获取实例
		 * @param code
		 * @return
		 */
		public static final TFirmStatus getByCode(int code){
			for (TFirmStatus status : TFirmStatus.values()) {
				if(status.getCode() == code){
					return status;
				}
			}
			throw new IllegalArgumentException("invalid enum code");
		}
	}
	
	/**
	 * 委托单类型

	 */
	public static enum OrderSign {
		收单(1), 出单(2), 换工具(3);
		private int code;
		
		OrderSign(int code){
			this.code = code;
		}

		public final int getCode() {
			return code;
		}

		public final void setCode(int code) {
			this.code = code;
		}
		
		public final boolean eq(int code){
			return this.code == code;
		}
	}
	
	/**
	 * 委托单的状态

	 * 1收方挂单求购状态，2出方出售等待收方付款，3收方已付款'等待'出方确认收款
	 * ，4出方确认收款订单成交，5出方挂出售单，6向平台购收工具成功
	 */
	public static enum OrderStatus {
		后台撤销(-1), 用户撤销(0), 收方挂单求购(1),等待收方付款(2),等待出方确认收款(3),订单成交(4),出方挂出售单(5),购收工具成功(6)
		;
		
		private int code;
		
		OrderStatus(int code){
			this.code = code;
		}

		public final int getCode() {
			return code;
		}

		public final void setCode(int code) {
			this.code = code;
		}
		
		public final boolean eq(int code){
			return this.code == code;
		}
		
		/**
		 * 根据code获取实例
		 * @param code
		 * @return
		 */
		public static final OrderStatus getByCode(int code){
			for (OrderStatus status : OrderStatus.values()) {
				if(status.getCode() == code){
					return status;
				}
			}
			throw new IllegalArgumentException("invalid enum code");
		}
	}
	
	/**
	 * 订单图片类型`r_order_picture`.`type`

	 */
	public static enum OrderPictureType{
		付款图片(1), 未收到款申诉(2);
		
		private int code;
		
		OrderPictureType(int code){
			this.code = code;
		}

		public final int getCode() {
			return code;
		}

		public final void setCode(int code) {
			this.code = code;
		}
		
		public final boolean eq(int code){
			return this.code == code;
		}
	}
	
	/**
	 * 文件类型

	 */
	public static enum FileType{	
		会员头像("5"),
		信息反馈类型("4"),
		前端app交易收方付1款凭证图片上传类型("41"),
		前端app交易出方交易凭证图片上传类型("42"),
		后台上传图片("3"),
		手持身份证照片("13"),
		聊天图片("2"),
		身份证反面照片("12"),
		身份证正面照片("11");
		private String code;
		
		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
		}

		private FileType(String code) {
			this.code = code;
		}
		
	}
	
	/**
	 * 流水业务代码

	 */
	public static enum Oprcode {
		抽奖所得米粒("100"),
		签到增值("101"),
		收米粒("201"),
		出米粒("202"),
		平台赠送("203"),
		交易手续费扣除("301"),
		下级活跃值奖励("401"),
		兑换工具("501"),
		激活鼓励金("555"),
		商城实物兑换("601"),
		获得打赏("666"),
		打赏出去("668"),
		地区合伙人分红("703"),
		米粒兑换抽奖("880"),
		分享流水("999"),
		兑换合伙人("700");
		
		private String code;
		
		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
		}

		private Oprcode(String code) {
			this.code = code;
		}

	}
	
	/**
	 * 订单过期原因
	 */
	public static enum TimeoutReason {
		等待确认付款过期(1), 等待确认收款过期(2);
		
		private int code;
		
		TimeoutReason(int code){
			this.code = code;
		}

		public final int getCode() {
			return code;
		}

		public final void setCode(int code) {
			this.code = code;
		}
		
		public final boolean eq(int code){
			return this.code == code;
		}
	}
	
	/**
	 * 合伙人申请记录的状态

	 * 1-未处理，2-申请通过，-3申请不通过
	 */
	public static enum PartnerApplyStatus {
		未处理(1), 申请通过(2), 申请不通过(3);
		
		private int code;
		
		PartnerApplyStatus(int code){
			this.code = code;
		}

		public final int getCode() {
			return code;
		}

		public final void setCode(int code) {
			this.code = code;
		}
		
		public final boolean eq(int code){
			return this.code == code;
		}
	}
	
	/**
	 * 货币或者游戏币

	 */
	public static enum Currency{
		人民币(2), 美元(3), 日元(4), 米粒(5), 抽奖次数(6);
		
		private int code;
		
		Currency(int code){
			this.code = code;
		}

		public final int getCode() {
			return code;
		}

		public final void setCode(int code) {
			this.code = code;
		}
		
		public final boolean eq(int code){
			return this.code == code;
		}
	}
	
	/**
	 * 兑换方式

	 */
	public static enum ExchangeMode {
		自动兑换(0), 用户手动(1), 后台兑换(2);
		
		private int code;
		
		ExchangeMode(int code){
			this.code = code;
		}

		public final int getCode() {
			return code;
		}

		public final void setCode(int code) {
			this.code = code;
		}
		
		public final boolean eq(int code){
			return this.code == code;
		}
	}
	
	/**
	 * 会员抽奖记录状态，0：未中奖，1：中奖未兑奖。2：中奖已兑

	 */
	public static enum FirmPrizeStatus {
		未中奖(0), 中奖未兑奖(1), 中奖已兑(2);
		
		private int code;
		
		FirmPrizeStatus(int code){
			this.code = code;
		}

		public final int getCode() {
			return code;
		}

		public final void setCode(int code) {
			this.code = code;
		}
		
		public final boolean eq(int code){
			return this.code == code;
		}
	}
}

