package com.cooper.user.controller;

import com.cooper.user.constant.CookieConstant;
import com.cooper.user.constant.RedisConstant;
import com.cooper.user.dataobject.UserInfo;
import com.cooper.user.enums.ResultEnum;
import com.cooper.user.enums.RoleEnum;
import com.cooper.user.service.UserService;
import com.cooper.user.utils.CookieUtil;
import com.cooper.user.utils.ResultVOUtil;
import com.cooper.user.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author xueao
 * @create 2018-05-22 22:05
 * @desc ${DESCRIPTION}
 **/
@RestController
@RequestMapping("/login")
public class LoginController {


	@Autowired
	private UserService userService;


	@Autowired
	private StringRedisTemplate stringRedisTemplate;


	@RequestMapping("/buyer")
	public ResultVO buyer(@RequestParam("openid") String openid,
						  HttpServletResponse response){
		UserInfo userInfo = userService.findByOpenid(openid);
		if(userInfo==null){
			return ResultVOUtil.error(ResultEnum.LOGIN_FAIL);
		}

		if(RoleEnum.BUYER.getCode()!=userInfo.getRole()){
			return ResultVOUtil.error(ResultEnum.ROLE_FAIL);
		}

		CookieUtil.set(response,CookieConstant.OPENID,openid,CookieConstant.expire);

		return ResultVOUtil.success();
	}

	@RequestMapping("/seller")
	public ResultVO seller(@RequestParam("openid") String openid,
						  HttpServletRequest request,
						  HttpServletResponse response){

		Cookie cookie = CookieUtil.get(request,CookieConstant.TOKEN);

		if(cookie!=null &&
				!StringUtils.isEmpty(stringRedisTemplate.opsForValue()
				.get(String.format(RedisConstant.TOKEN_TEMPLATE,cookie.getValue())))){
			return ResultVOUtil.success();
		}


		UserInfo userInfo = userService.findByOpenid(openid);
		if(userInfo==null){
			return ResultVOUtil.error(ResultEnum.LOGIN_FAIL);
		}

		if(RoleEnum.SELLER.getCode()!=userInfo.getRole()){
			return ResultVOUtil.error(ResultEnum.ROLE_FAIL);
		}

		String token = UUID.randomUUID().toString();

		Integer expire = CookieConstant.expire;

		stringRedisTemplate.opsForValue().set(String.format(RedisConstant.TOKEN_TEMPLATE,token),
				openid,expire,TimeUnit.SECONDS);

		CookieUtil.set(response,CookieConstant.TOKEN,token,CookieConstant.expire);

		return ResultVOUtil.success();
	}
}
