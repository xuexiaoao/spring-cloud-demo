package com.cooper.order.server.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author xueao
 * @create 2018-05-19 23:08
 * @desc 接受mq消息
 **/
@Slf4j
@Component
public class MqReciver {

	//@RabbitListener(queues = "myQueue")
	//@RabbitListener(queuesToDeclare = @Queue("myQueue")) 自动创建队列
	@RabbitListener(bindings = @QueueBinding(
			value = @Queue("myQueue"),
			exchange = @Exchange("myExchange")
	))
	public void process(String message){
		log.info("MqReciver:{}",message);
	}
}
