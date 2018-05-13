package com.cooper.product.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * @author xueao
 * @create 2018-05-13 11:09
 * @desc ${DESCRIPTION}
 **/
@Data
public class ProductVO {
	@JsonProperty("name")
	private String categoryName;
	@JsonProperty("type")
	private Integer categoryType;
	@JsonProperty("foods")
	private List<ProductInfoVO> productInfoVOList;
}
