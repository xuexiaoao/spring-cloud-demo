package com.cooper.order.service.impl;

import com.cooper.order.dataobject.OrderDetail;
import com.cooper.order.dataobject.OrderMaster;
import com.cooper.order.dto.OrderDTO;
import com.cooper.order.enums.OrderStatusEnum;
import com.cooper.order.enums.PayStatusEnum;
import com.cooper.order.repository.OrderDetailRepository;
import com.cooper.order.repository.OrderMasterRepository;
import com.cooper.order.service.OrderService;
import com.cooper.order.utils.KeyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author xueao
 * @create 2018-05-13 15:45
 * @desc ${DESCRIPTION}
 **/
@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderDetailRepository orderDetailRepository;

	@Autowired
	private OrderMasterRepository orderMasterRepository;

	/*@Autowired
	private ProductClient productClient;*/

	@Override
	public OrderDTO create(OrderDTO orderDTO) {
		/*String orderId = KeyUtil.genUniqueKey();

		//查询商品信息(调用商品服务)
		List<String> productIdList = orderDTO.getOrderDetailList().stream()
				.map(OrderDetail::getProductId)
				.collect(Collectors.toList());
		List<ProductInfoOutput> productInfoList = productClient.listForOrder(productIdList);

		//计算总价
		BigDecimal orderAmout = new BigDecimal(BigInteger.ZERO);
		for (OrderDetail orderDetail: orderDTO.getOrderDetailList()) {
			for (ProductInfoOutput productInfo: productInfoList) {
				if (productInfo.getProductId().equals(orderDetail.getProductId())) {
					//单价*数量
					orderAmout = productInfo.getProductPrice()
							.multiply(new BigDecimal(orderDetail.getProductQuantity()))
							.add(orderAmout);
					BeanUtils.copyProperties(productInfo, orderDetail);
					orderDetail.setOrderId(orderId);
					orderDetail.setDetailId(KeyUtil.genUniqueKey());
					//订单详情入库
					orderDetailRepository.save(orderDetail);
				}
			}
		}

		//扣库存(调用商品服务)
		List<DecreaseStockInput> decreaseStockInputList = orderDTO.getOrderDetailList().stream()
				.map(e -> new DecreaseStockInput(e.getProductId(), e.getProductQuantity()))
				.collect(Collectors.toList());
		productClient.decreaseStock(decreaseStockInputList);

		//订单入库
		OrderMaster orderMaster = new OrderMaster();
		orderDTO.setOrderId(orderId);
		BeanUtils.copyProperties(orderDTO, orderMaster);
		orderMaster.setOrderAmount(orderAmout);
		orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
		orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
		orderMasterRepository.save(orderMaster);
		return orderDTO;*/
		return null;
	}
}
