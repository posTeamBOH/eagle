package com.choice.eagle.util;

import java.util.Random;

/**
 * 生成主键位
 * 
 *
 */
public class UuidUtil {
	public static String getMenuId() {
		Random ran = new Random(System.currentTimeMillis());
		return "M" + ran.nextLong();
	}
	public static String getOrderId() {
		Random ran = new Random(System.currentTimeMillis());
		return "O" + ran.nextLong();
	}
	public static String getRorderId() {
		Random ran = new Random(System.currentTimeMillis());
		return "R" + ran.nextLong();
	}
	public static String getTableId() {
		Random ran = new Random(System.currentTimeMillis());
		return "T" + ran.nextLong();
	}
	
}
