package com.cooper.product.utils;

import com.cooper.product.vo.ResultVO;

/**
 * @author xueao
 * @create 2018-05-13 11:26
 * @desc ${DESCRIPTION}
 **/
public class ResultVOUtil {

	public static ResultVO success(Object object) {
		ResultVO resultVO = new ResultVO();
		resultVO.setData(object);
		resultVO.setCode(0);
		resultVO.setMsg("成功");
		return resultVO;
	}
}
