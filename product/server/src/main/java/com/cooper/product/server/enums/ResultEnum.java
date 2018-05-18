package com.cooper.product.server.enums;

import lombok.Getter;

/**
 * @author xueao
 * @create 2018-05-16 22:22
 * @desc ${DESCRIPTION}
 **/
@Getter
public enum ResultEnum {
	PRODUCT_NOT_EXIST(1, "商品不存在"),
	PRODUCT_STOCK_ERROR(2, "库存有误"),
	;

	private Integer code;

	private String message;

	ResultEnum(Integer code, String message) {
		this.code = code;
		this.message = message;
	}
}
