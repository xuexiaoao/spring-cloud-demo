package com.cooper.product.service.impl;

import com.cooper.product.dataobject.ProductCategory;
import com.cooper.product.repository.ProductCategoryRepository;
import com.cooper.product.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xueao
 * @create 2018-05-13 11:06
 * @desc ${DESCRIPTION}
 **/
@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private ProductCategoryRepository productCategoryRepository;

	@Override
	public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
		return productCategoryRepository.findByCategoryTypeIn(categoryTypeList);
	}
}
