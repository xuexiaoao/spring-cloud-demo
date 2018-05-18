package com.cooper.order.server.enums;

import lombok.Getter;

/**
 * @author xueao
 * @create 2018-05-13 15:39
 * @desc ${DESCRIPTION}
 **/
@Getter
public enum PayStatusEnum {
	WAIT(0, "等待支付"),
	SUCCESS(1, "支付成功"),
	;
	private Integer code;

	private String message;

	PayStatusEnum(Integer code, String message) {
		this.code = code;
		this.message = message;
	}
}
