package com.cooper.order.server.controller;

import com.cooper.order.server.message.StreamClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author xueao
 * @create 2018-05-19 23:27
 * @desc ${DESCRIPTION}
 **/
@RestController
public class SenderMessageController {


	@Autowired
	private StreamClient streamClient;

	@GetMapping("/sendMessage")
	public void process(){
		String message = "now:"+new Date();
		streamClient.output().send(MessageBuilder.withPayload("测试发送消息").build());
	}

}
