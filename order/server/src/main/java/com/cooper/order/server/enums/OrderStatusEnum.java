package com.cooper.order.server.enums;

import lombok.Getter;

/**
 * @author xueao
 * @create 2018-05-13 15:39
 * @desc ${DESCRIPTION}
 **/
@Getter
public enum OrderStatusEnum {
	NEW(0, "新订单"),
	FINISHED(1, "完结"),
	CANCEL(2, "取消"),
	;
	private Integer code;

	private String message;

	OrderStatusEnum(Integer code, String message) {
		this.code = code;
		this.message = message;
	}
}
