package com.choice.eagle.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.choice.eagle.entity.MenuNum;
import com.choice.eagle.entity.Order;

public interface RorderService {

		//根据订单号查询订单的菜品及数量
		List<MenuNum> selectMenuByOrderId(String orderId); 
	    
		//改变订单联系表中的菜品状态
		void updateMenuStatus(String orderId);
		
		//查询定单的菜品数量
		HashMap<String, Object> getMenuNum(List<Order> orders);
		
		//提交订单
		String insertOrder(String tableId, String orderDate, String orderMoney, String orderNum, String orderRemark, HashMap<String, Integer> menuNums);
}
