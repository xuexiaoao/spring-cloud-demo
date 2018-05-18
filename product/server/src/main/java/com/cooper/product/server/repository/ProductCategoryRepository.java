package com.cooper.product.server.repository;

import com.cooper.product.server.dataobject.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author xueao
 * @create 2018-05-13 10:47
 * @desc ${DESCRIPTION}
 **/
public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Integer> {
	List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
