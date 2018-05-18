package com.cooper.product.server.exception;

import com.cooper.product.server.enums.ResultEnum;

/**
 * @author xueao
 * @create 2018-05-16 22:21
 * @desc ${DESCRIPTION}
 **/
public class ProductException extends RuntimeException {

	private Integer code;

	public ProductException(Integer code, String message) {
		super(message);
		this.code = code;
	}

	public ProductException(ResultEnum resultEnum) {
		super(resultEnum.getMessage());
		this.code = resultEnum.getCode();
	}
}
