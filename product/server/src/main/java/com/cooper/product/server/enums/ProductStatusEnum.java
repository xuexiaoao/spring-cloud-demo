package com.cooper.product.server.enums;

import lombok.Getter;

/**
 * @author xueao
 * @create 2018-05-13 10:59
 * @desc ${DESCRIPTION}
 **/
@Getter
public enum ProductStatusEnum {
	UP(0,"在架"),
	DOWN(1,"下架"),
	;

	private Integer code;
	private String message;

	ProductStatusEnum(Integer code, String message) {
		this.code = code;
		this.message = message;
	}
}
