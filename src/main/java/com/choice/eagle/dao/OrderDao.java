package com.choice.eagle.dao;

import java.util.HashMap;
import java.util.List;

import com.choice.eagle.entity.Order;

public interface OrderDao {
	
	//根据桌子查询订单
	List<Order> selectByTable(String tableId);
	
	//根据条件查询订单
	List<Order> selectByRequire(String orderId, String beginTime, String endTime);
	
<<<<<<< HEAD
	
=======
	//根据条件统计订单时间和订单量
	HashMap<String, Integer> countByRequire(String orderId, String beginTime, String endTime);
>>>>>>> 07d158db11dbc2ab33c91d684d0cf1ac46a189ec
}