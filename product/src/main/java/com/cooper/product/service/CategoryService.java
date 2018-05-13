package com.cooper.product.service;

import com.cooper.product.dataobject.ProductCategory;

import java.util.List;

/**
 * @author xueao
 * @create 2018-05-13 11:05
 * @desc ${DESCRIPTION}
 **/
public interface CategoryService {
	List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
