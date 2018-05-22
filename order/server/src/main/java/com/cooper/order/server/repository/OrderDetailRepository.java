package com.cooper.order.server.repository;

import com.cooper.order.server.dataobject.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author xueao
 * @create 2018-05-13 15:34
 * @desc ${DESCRIPTION}
 **/
public interface OrderDetailRepository extends JpaRepository<OrderDetail,String> {
	List<OrderDetail> findByOrderId(String orderId);
}
