package com.cooper.order.server.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

/**
 * @author xueao
 * @create 2018-05-19 23:25
 * @desc ${DESCRIPTION}
 **/
@Component
@EnableBinding(StreamClient.class)
@Slf4j
public class StreamReciver {

	@StreamListener(value = StreamClient.name3)
	@SendTo(StreamClient.name2)
	public String  process(String message){
		log.info("StreamReceiver:{}",message);
		return "recive";
	}


	@StreamListener(value = StreamClient.name2)
	public void   processMessage2(Object message){
		log.info("StreamReceiver2:{}",message);
	}
}
