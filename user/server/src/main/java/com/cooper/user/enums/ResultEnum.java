package com.cooper.user.enums;

import lombok.Getter;

/**
 * @author xueao
 * @create 2018-05-13 15:40
 * @desc ${DESCRIPTION}
 **/
@Getter
public enum ResultEnum {
	LOGIN_FAIL(1,"登录失败"),
	ROLE_FAIL(2,"角色权限有误"),
	;

	private Integer code;

	private String message;

	ResultEnum(Integer code, String message) {
		this.code = code;
		this.message = message;
	}
}
