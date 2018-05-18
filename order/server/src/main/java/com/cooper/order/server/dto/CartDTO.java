package com.cooper.order.server.dto;

/**
 * @author xueao
 * @create 2018-05-13 15:46
 * @desc ${DESCRIPTION}
 **/
public class CartDTO {
	/**
	 * 商品id
	 */
	private String productId;

	/**
	 * 商品数量
	 */
	private Integer productQuantity;

	public CartDTO() {
	}

	public CartDTO(String productId, Integer productQuantity) {
		this.productId = productId;
		this.productQuantity = productQuantity;
	}
}
