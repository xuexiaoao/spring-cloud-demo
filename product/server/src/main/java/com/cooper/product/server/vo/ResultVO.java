package com.cooper.product.server.vo;

import lombok.Data;

/**
 * @author xueao
 * @create 2018-05-13 11:07
 * @desc ${DESCRIPTION}
 **/
@Data
public class ResultVO<T> {
	private Integer code;
	private String msg;
	private T data;
}
