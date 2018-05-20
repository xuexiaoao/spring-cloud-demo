package com.cooper.order.server.message;


import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * @author xueao
 * @create 2018-05-19 23:23
 * @desc ${DESCRIPTION}
 **/
public interface StreamClient {

	String name = "streamInput";
	String name2 = "streamInput2";
	String name3 = "streamOutput";
	String name4 = "streamOutput2";



	@Input(StreamClient.name)
	SubscribableChannel input();

	@Output(StreamClient.name3)
	MessageChannel output();

	@Input(StreamClient.name2)
	SubscribableChannel input2();

	@Output(StreamClient.name4)
	MessageChannel output2();
}
