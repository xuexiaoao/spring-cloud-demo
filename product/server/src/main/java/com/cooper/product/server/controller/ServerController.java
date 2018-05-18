package com.cooper.product.server.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xueao
 * @create 2018-05-13 15:59
 * @desc ${DESCRIPTION}
 **/
@RestController
public class ServerController {

	@Value("${server.port}")
	private String port;

	@GetMapping("msg")
	public String msg(){
		return "this message from "+port;
	}
}
