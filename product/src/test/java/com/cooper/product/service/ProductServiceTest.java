package com.cooper.product.service;

import com.cooper.product.ProductApplicationTests;
import com.cooper.product.dataobject.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author xueao
 * @create 2018-05-13 11:02
 * @desc ${DESCRIPTION}
 **/
@Component
public class ProductServiceTest extends ProductApplicationTests {

	@Autowired
	private ProductService productService;

	@Test
	public void findUpAll() {
		List<ProductInfo> list = productService.findUpAll();
		Assert.assertTrue(list.size()>0);
	}
}