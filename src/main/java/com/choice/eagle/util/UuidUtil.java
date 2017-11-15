package com.choice.eagle.util;

import java.util.UUID;

/**
 * 生成主键32位
 * @author S_eve
 *
 */
public class UuidUtil {
	public static String getId() {
		String id = UUID.randomUUID().toString();
		id = id.replaceAll("-", "");
		return id;
	}
}
