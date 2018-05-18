package com.cooper.order.server.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xueao
 * @create 2018-05-17 0:05
 * @desc ${DESCRIPTION}
 **/
@RestController
@RequestMapping("/env")
//@RefreshScope
public class EnvController {
	@Value("${env}")
	private String env;

	@GetMapping("/print")
	public String print() {
		return env;
	}
}
