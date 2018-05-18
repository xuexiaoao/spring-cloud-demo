package com.cooper.order.server.repository;

import com.cooper.order.server.dataobject.OrderMaster;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author xueao
 * @create 2018-05-13 15:35
 * @desc ${DESCRIPTION}
 **/
public interface OrderMasterRepository extends JpaRepository<OrderMaster, String> {
}
