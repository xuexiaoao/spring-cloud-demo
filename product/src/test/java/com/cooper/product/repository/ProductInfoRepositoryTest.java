package com.cooper.product.repository;

import com.cooper.product.dataobject.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author xueao
 * @create 2018-05-13 10:25
 * @desc ${DESCRIPTION}
 **/

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTest {

	@Autowired
	private ProductInfoRepository productInfoRepository;

	@Test
	public void findByProductStatus() {
		List<ProductInfo> list = productInfoRepository.findByProductStatus(0);
		Assert.assertTrue(list.size()>0);
	}
}