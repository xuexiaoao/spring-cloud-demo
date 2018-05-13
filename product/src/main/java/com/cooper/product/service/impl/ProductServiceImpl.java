package com.cooper.product.service.impl;

import com.cooper.product.dataobject.ProductInfo;
import com.cooper.product.enums.ProductStatusEnum;
import com.cooper.product.repository.ProductInfoRepository;
import com.cooper.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xueao
 * @create 2018-05-13 10:53
 * @desc ${DESCRIPTION}
 **/
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductInfoRepository productInfoRepository;

	@Override
	public List<ProductInfo> findUpAll() {
		return productInfoRepository.findByProductStatus(ProductStatusEnum.UP.getCode());
	}
}
