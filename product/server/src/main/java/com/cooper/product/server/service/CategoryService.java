package com.cooper.product.server.service;

import com.cooper.product.server.dataobject.ProductCategory;

import java.util.List;

/**
 * @author xueao
 * @create 2018-05-13 11:05
 * @desc ${DESCRIPTION}
 **/
public interface CategoryService {
	List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
