package com.cooper.product.common;

import lombok.Data;

/**
 * @author xueao
 * @create 2018-05-16 22:48
 * @desc ${DESCRIPTION}
 **/
@Data
public class DecreaseStockInput {
	private String productId;

	private Integer productQuantity;

	public DecreaseStockInput() {
	}

	public DecreaseStockInput(String productId, Integer productQuantity) {
		this.productId = productId;
		this.productQuantity = productQuantity;
	}
}
