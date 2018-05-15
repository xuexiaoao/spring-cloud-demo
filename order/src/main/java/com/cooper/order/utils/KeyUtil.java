package com.cooper.order.utils;

import java.util.Random;

/**
 * @author xueao
 * @create 2018-05-13 15:48
 * @desc ${DESCRIPTION}
 **/
public class KeyUtil {
	/**
	 * 生成唯一的主键
	 * 格式: 时间+随机数
	 */
	public static synchronized String genUniqueKey() {
		Random random = new Random();
		Integer number = random.nextInt(900000) + 100000;

		return System.currentTimeMillis() + String.valueOf(number);
	}
}
