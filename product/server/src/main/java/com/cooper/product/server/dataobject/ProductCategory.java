package com.cooper.product.server.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author xueao
 * @create 2018-05-13 10:45
 * @desc ${DESCRIPTION}
 **/
@Data
@Entity
public class ProductCategory {

	@Id
	@GeneratedValue
	private Integer categoryId;

	/** 类目名字. */
	private String categoryName;

	/** 类目编号. */
	private Integer categoryType;

	private Date createTime;

	private Date updateTime;
}
