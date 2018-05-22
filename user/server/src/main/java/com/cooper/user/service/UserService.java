package com.cooper.user.service;

import com.cooper.user.dataobject.UserInfo;

/**
 * @author xueao
 * @create 2018-05-22 22:02
 * @desc ${DESCRIPTION}
 **/
public interface UserService {

	UserInfo findByOpenid(String openid);
}
