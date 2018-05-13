package com.cooper.product.service;

import com.cooper.product.dataobject.ProductInfo;

import java.util.List;

/**
 * @author xueao
 * @create 2018-05-13 10:52
 * @desc ${DESCRIPTION}
 **/
public interface ProductService {
	List<ProductInfo> findUpAll();
}
