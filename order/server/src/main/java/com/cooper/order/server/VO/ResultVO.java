package com.cooper.order.server.VO;

import lombok.Data;

/**
 * @author xueao
 * @create 2018-05-13 15:50
 * @desc ${DESCRIPTION}
 **/
@Data
public class ResultVO<T> {
	private Integer code;

	private String msg;

	private T data;
}
