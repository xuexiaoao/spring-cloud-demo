package com.cooper.order.server.message;

import com.cooper.order.server.utils.JsonUtil;
import com.cooper.product.common.ProductInfoOutput;
import com.fasterxml.jackson.core.type.TypeReference;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author xueao
 * @create 2018-05-20 14:31
 * @desc ${DESCRIPTION}
 **/
@Component
@Slf4j
public class ProductInfoReceiver {

	private static final String PRODUCT_STOCK_TEMPLATE = "product_stock_%s";

	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	@RabbitListener(queuesToDeclare = @Queue("productInfo"))
	public void process(String message){
		List<ProductInfoOutput> productInfoOutputList = (List<ProductInfoOutput>) JsonUtil.fromJson(message,
				new TypeReference<List<ProductInfoOutput>>() {
				});
		log.info("从队列【{}】接收到消息:{}","productInfo",productInfoOutputList);

		for(ProductInfoOutput productInfoOutput:productInfoOutputList){
			stringRedisTemplate.opsForValue().set(
					String.format(PRODUCT_STOCK_TEMPLATE,productInfoOutput.getProductId()),
					String.valueOf(productInfoOutput.getProductStock())
			);
		}

	}

}
