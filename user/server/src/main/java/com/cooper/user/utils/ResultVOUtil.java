package com.cooper.user.utils;

import com.cooper.user.enums.ResultEnum;
import com.cooper.user.vo.ResultVO;

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

	public static ResultVO error(ResultEnum loginFail) {
		ResultVO resultVO = new ResultVO();
		resultVO.setCode(loginFail.getCode());
		resultVO.setMsg(loginFail.getMessage());
		return resultVO;
	}

	public static ResultVO success() {
		ResultVO resultVO = new ResultVO();
		resultVO.setCode(0);
		resultVO.setMsg("成功");
		return resultVO;
	}
}
