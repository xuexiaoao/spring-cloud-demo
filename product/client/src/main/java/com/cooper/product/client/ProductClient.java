package com.cooper.product.client;

import com.cooper.product.common.DecreaseStockInput;
import com.cooper.product.common.ProductInfoOutput;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @author xueao
 * @create 2018-05-16 22:50
 * @desc ${DESCRIPTION}
 **/
@FeignClient(name = "product",fallback =ProductClient.ProductClientFallBack.class )
public interface ProductClient {
	@PostMapping("/product/listForOrder")
	List<ProductInfoOutput> listForOrder(@RequestBody List<String> productIdList);

	@PostMapping("/product/decreaseStock")
	void decreaseStock(@RequestBody List<DecreaseStockInput> decreaseStockInputList);

	@Component
	static class ProductClientFallBack implements ProductClient{

		@Override
		public List<ProductInfoOutput> listForOrder(List<String> productIdList) {
			return null;
		}

		@Override
		public void decreaseStock(List<DecreaseStockInput> decreaseStockInputList) {

		}
	}

}
