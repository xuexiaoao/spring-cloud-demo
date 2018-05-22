package com.cooper.user.repository;

import com.cooper.user.dataobject.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author xueao
 * @create 2018-05-22 22:01
 * @desc ${DESCRIPTION}
 **/
public interface UserInfoRepostory extends JpaRepository<UserInfo,String> {

	UserInfo findByOpenid(String openId);
}
