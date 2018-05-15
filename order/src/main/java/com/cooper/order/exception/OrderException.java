package com.cooper.order.exception;

import com.cooper.order.enums.ResultEnum;

/**
 * @author xueao
 * @create 2018-05-13 16:16
 * @desc ${DESCRIPTION}
 **/
public class OrderException extends RuntimeException{
	private Integer code;

	public OrderException(Integer code, String message) {
		super(message);
		this.code = code;
	}

	public OrderException(ResultEnum resultEnum) {
		super(resultEnum.getMessage());
		this.code = resultEnum.getCode();
	}
}
