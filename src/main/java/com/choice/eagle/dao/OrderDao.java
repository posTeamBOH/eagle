package com.choice.eagle.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.choice.eagle.entity.Order;

public interface OrderDao {
	
	//根据桌子查询订单
	List<Order> selectByTable(String tableId);
	
	//根据条件查询订单
	List<Order> selectByRequire(@Param("orderId")String orderId, @Param("beginTime")String beginTime, @Param("endTime") String endTime, @Param("pageNo") int pageNo);
	
	//添加订单
	int insertOrder(Order order);
	
}