package com.cooper.order.server;

import org.junit.Test;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author xueao
 * @create 2018-05-19 23:11
 * @desc ${DESCRIPTION}
 **/
@Component
public class MqSenderTest extends OrderServerApplicationTests{


	@Autowired
	private AmqpTemplate amqpTemplate;

	@Test
	public void send(){
		amqpTemplate.convertAndSend("myQueue","now:"+new Date());
	}

}
