package com.cooper.order.server.controller;

import com.cooper.order.server.dataobject.ProductInfo;
import com.cooper.product.client.ProductClient;
import com.cooper.product.common.ProductInfoOutput;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

/**
 * @author xueao
 * @create 2018-05-13 16:21
 * @desc ${DESCRIPTION}
 **/
@RestController
@Slf4j
public class ClientController {

	/*@Autowired
	private LoadBalancerClient loadBalancerClient;

	@Autowired
	private RestTemplate restTemplate;*/


	@Autowired
	private ProductClient productClient;

/*	@GetMapping("/getProductMsg")
	public String getProductMsg(){
		//RestTemplate restTemplate = new RestTemplate();
		//String response = restTemplate.getForObject("http://localhost:8080/msg",String.class);

		ServiceInstance serviceInstance = loadBalancerClient.choose("PRODUCT");
		String url = String.format("http://%s:%s",serviceInstance.getHost(),serviceInstance.getPort())+"/msg";

		String response = restTemplate.getForObject(url,String.class);
		String response = restTemplate.getForObject("http://PRODUCT/msg",String.class);

		String response = productClient.productMsg();

		log.info("response={}",response);
		return response;
	}*/


	@GetMapping("/getProductList")
	public String getProductList(){
		List<ProductInfoOutput> productInfos = productClient.listForOrder(Arrays.asList("164103465734242707"));
		log.info("response={}"+productInfos);
		return "ok";

	}

}
