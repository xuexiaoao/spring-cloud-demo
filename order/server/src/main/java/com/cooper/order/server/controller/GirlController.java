package com.cooper.order.server.controller;

import com.cooper.order.server.config.GirlConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xueao
 * @create 2018-05-17 0:05
 * @desc ${DESCRIPTION}
 **/
@RestController
@RefreshScope
public class GirlController {
	@Autowired
	private GirlConfig girlConfig;

	@GetMapping("/girl/print")
	public String print() {
		return "name:" + girlConfig.getName() + " age:" + girlConfig.getAge();
	}
}
