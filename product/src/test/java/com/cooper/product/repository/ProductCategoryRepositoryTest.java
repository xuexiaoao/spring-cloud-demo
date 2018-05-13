package com.cooper.product.repository;

import com.cooper.product.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author xueao
 * @create 2018-05-13 10:49
 * @desc ${DESCRIPTION}
 **/

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {

	@Autowired
	private ProductCategoryRepository productCategoryRepository;

	@Test
	public void findByCategoryTypeIn() {
		List<ProductCategory> list = productCategoryRepository.findByCategoryTypeIn(Arrays.asList(11,22));
		Assert.assertTrue(list.size()>0);
	}
}