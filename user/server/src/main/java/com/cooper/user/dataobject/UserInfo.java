package com.cooper.user.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author xueao
 * @create 2018-05-22 21:56
 * @desc ${DESCRIPTION}
 **/
@Data
@Entity
public class UserInfo {

	@Id
	private String id;

	private String username;

	private String password;

	private String openid;

	private Integer role;
}
