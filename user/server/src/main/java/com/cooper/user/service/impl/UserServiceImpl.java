package com.cooper.user.service.impl;

import com.cooper.user.dataobject.UserInfo;
import com.cooper.user.repository.UserInfoRepostory;
import com.cooper.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author xueao
 * @create 2018-05-22 22:04
 * @desc ${DESCRIPTION}
 **/
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserInfoRepostory userInfoRepostory;

	@Override
	public UserInfo findByOpenid(String openid) {
		return userInfoRepostory.findByOpenid(openid);
	}
}
