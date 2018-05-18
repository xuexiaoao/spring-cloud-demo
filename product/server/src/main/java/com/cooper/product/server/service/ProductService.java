package com.cooper.product.server.service;

import com.cooper.product.common.DecreaseStockInput;
import com.cooper.product.common.ProductInfoOutput;
import com.cooper.product.server.dataobject.ProductInfo;

import java.util.List;

/**
 * @author xueao
 * @create 2018-05-13 10:52
 * @desc ${DESCRIPTION}
 **/
public interface ProductService {
	/**
	 * 查询所有在架商品列表
	 */
	List<ProductInfo> findUpAll();

	/**
	 * 查询商品列表
	 * @param productIdList
	 * @return
	 */
	List<ProductInfoOutput> findList(List<String> productIdList);

	/**
	 * 扣库存
	 * @param decreaseStockInputList
	 */
	void decreaseStock(List<DecreaseStockInput> decreaseStockInputList);}
