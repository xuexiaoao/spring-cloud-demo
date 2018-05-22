package com.cooper.user.enums;

import lombok.Getter;

/**
 * @author xueao
 * @create 2018-05-22 22:41
 * @desc ${DESCRIPTION}
 **/
@Getter
public enum  RoleEnum {
	BUYER(1,"买家"),
	SELLER(2,"卖家"),
	;

	private Integer code;
	private String message;

	RoleEnum(Integer code, String message) {
		this.code = code;
		this.message = message;
	}
}
