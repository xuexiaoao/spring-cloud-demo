package com.cooper.product.controller;

import com.cooper.product.dataobject.ProductCategory;
import com.cooper.product.dataobject.ProductInfo;
import com.cooper.product.service.CategoryService;
import com.cooper.product.service.ProductService;
import com.cooper.product.utils.ResultVOUtil;
import com.cooper.product.vo.ProductInfoVO;
import com.cooper.product.vo.ProductVO;
import com.cooper.product.vo.ResultVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author xueao
 * @create 2018-05-13 11:17
 * @desc ${DESCRIPTION}
 **/
@RestController
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private ProductService productService;

	@Autowired
	private CategoryService categoryService;

	@GetMapping("/list")
	public ResultVO<ProductVO> list() {
		//1. 查询所有在架的商品
		List<ProductInfo> productInfoList = productService.findUpAll();

		//2. 获取类目type列表
		List<Integer> categoryTypeList = productInfoList.stream()
				.map(ProductInfo::getCategoryType)
				.collect(Collectors.toList());

		//3. 从数据库查询类目
		List<ProductCategory> categoryList = categoryService.findByCategoryTypeIn(categoryTypeList);

		//4. 构造数据
		List<ProductVO> productVOList = new ArrayList<>();
		for (ProductCategory productCategory: categoryList) {
			ProductVO productVO = new ProductVO();
			productVO.setCategoryName(productCategory.getCategoryName());
			productVO.setCategoryType(productCategory.getCategoryType());

			List<ProductInfoVO> productInfoVOList = new ArrayList<>();
			for (ProductInfo productInfo: productInfoList) {
				if (productInfo.getCategoryType().equals(productCategory.getCategoryType())) {
					ProductInfoVO productInfoVO = new ProductInfoVO();
					BeanUtils.copyProperties(productInfo, productInfoVO);
					productInfoVOList.add(productInfoVO);
				}
			}
			productVO.setProductInfoVOList(productInfoVOList);
			productVOList.add(productVO);
		}

		return ResultVOUtil.success(productVOList);
	}

/*	*//**
	 * 获取商品列表(给订单服务用的)
	 * @param productIdList
	 * @return
	 *//*
	@PostMapping("/listForOrder")
	public List<ProductInfoOutput> listForOrder(@RequestBody List<String> productIdList) {
		return productService.findList(productIdList);
	}

	@PostMapping("/decreaseStock")
	public void decreaseStock(@RequestBody List<DecreaseStockInput> decreaseStockInputList) {
		productService.decreaseStock(decreaseStockInputList);
	}*/
}
