package com.cooper.product.server.repository;

import com.cooper.product.server.dataobject.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author xueao
 * @create 2018-05-13 10:23
 * @desc ${DESCRIPTION}
 **/
public interface ProductInfoRepository extends JpaRepository<ProductInfo,String> {
	List<ProductInfo> findByProductStatus(Integer productStatus);
	List<ProductInfo> findByProductIdIn(List<String> productIdList);
}
