package com.cooper.order.server.utils;

import com.cooper.order.server.VO.ResultVO;

/**
 * @author xueao
 * @create 2018-05-13 15:49
 * @desc ${DESCRIPTION}
 **/
public class ResultVOUtil {
	public static ResultVO success(Object object) {
		ResultVO resultVO = new ResultVO();
		resultVO.setCode(0);
		resultVO.setMsg("成功");
		resultVO.setData(object);
		return resultVO;
	}
}
