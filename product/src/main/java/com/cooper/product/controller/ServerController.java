package com.cooper.product.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xueao
 * @create 2018-05-13 15:59
 * @desc ${DESCRIPTION}
 **/
@RestController
public class ServerController {

	@GetMapping("msg")
	public String msg(){
		return "this is a msg 2";
	}
}
