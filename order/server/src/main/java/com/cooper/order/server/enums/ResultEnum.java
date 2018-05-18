package com.cooper.order.server.enums;

import lombok.Getter;

/**
 * @author xueao
 * @create 2018-05-13 15:40
 * @desc ${DESCRIPTION}
 **/
@Getter
public enum ResultEnum {
	PARAM_ERROR(1, "参数错误"),
	CART_EMPTY(2, "购物车为空")

	;

	private Integer code;

	private String message;

	ResultEnum(Integer code, String message) {
		this.code = code;
		this.message = message;
	}
}
