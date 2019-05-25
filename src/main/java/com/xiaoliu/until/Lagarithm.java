package com.xiaoliu.until;

/**
 * 数学计算
 */
public class Lagarithm {
	
	/**
	 * 对数换底公式
	 * @param x 底数
	 * @param y
	 * @return
	 */
	public static double logxy(double x, double y){
		if(x <= 0 || x == 1){
			throw new IllegalArgumentException("base number arg Illegal");
		}
		return Math.log(y) / Math.log(x);
	}
}
