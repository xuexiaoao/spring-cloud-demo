package com.cooper.order.server.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

/**
 * @author xueao
 * @create 2018-05-23 20:25
 * @desc ${DESCRIPTION}
 **/
@RestController
@DefaultProperties(defaultFallback = "defaultFallback")
public class HystrixController {



	//@HystrixCommand(fallbackMethod = "fallback")
	/*@HystrixCommand(commandProperties = {//超时配置
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
	})*/
	/*@HystrixCommand(commandProperties = {
			@HystrixProperty(name = "circuitBreaker.enabled",value ="true" ),
			@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value ="10" ),
			@HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value ="10000" ),
			@HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value ="60" ),
	})*/
	@HystrixCommand
	@GetMapping("/getProductInfoList")
	public String getProductInfoList(@RequestParam("number") Integer number){

		if(number % 2 ==0){
			return "success";
		}

		RestTemplate restTemplate = new RestTemplate();

		return restTemplate.postForObject("http://127.0.0.1:8092/product/listForOrder",
				Arrays.asList("157875196366160022"),
				String.class);
	}

	private String fallback(){
		return "太拥挤了，请稍候再试";
	}

	private String defaultFallback(){
		return "默认提示：太拥挤了，请稍候再试";
	}

}
