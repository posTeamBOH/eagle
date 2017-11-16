package com.choice.eagle.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.choice.eagle.entity.MenuNum;
import com.choice.eagle.entity.Order;

public interface RorderService {

		//根据订单号查询订单的菜品及数量
		List<MenuNum> selectMenuByOrderId(String orderId); 
	    
		//点击上菜改变订单联系表中的菜品状态
		int updateMenuStatus(String orderId,String menuName);
		
		//查询定单的菜品数量
		HashMap<String, Object> getMenuNum(List<Order> orders);
		
		//提交订单
		String insertOrder(String tableId, String orderDate, String orderMoney, String orderNum, String orderRemark, HashMap<String, Integer> menuNums);
		//点击结账改变桌子，订单状态
		int updateAllStatus(String tableId,String orderId);
}
