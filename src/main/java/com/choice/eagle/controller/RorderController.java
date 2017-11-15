package com.choice.eagle.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.choice.eagle.entity.Order;
import com.choice.eagle.service.OrderService;

@RequestMapping("/roder")
public class RorderController {
	@Autowired
	OrderService orderService;
	
//	//后台人员根据条件查询订单，得到订单、订单中的菜品数量
//	@RequestMapping(value="/getOrders")
//	public void getOrderByRequest(@RequestParam("orderId") String orderId, 
//				@RequestParam("begin") String beginTime, 
//				@RequestParam("end") String endTime,
//				HttpServletRequest request) {
//		List<Order> orders = orderService.selectByRequire(orderId, beginTime, endTime);
//		request.setAttribute("orders", orders);
//		for (int i = 0; i < orders.size(); i++) {
//			
//		}
//		
//	}
//	//后台人员查看订单明细

}
