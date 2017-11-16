package com.choice.eagle.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.choice.eagle.entity.Order;
import com.choice.eagle.service.OrderService;
import com.choice.eagle.service.RorderService;
import com.fasterxml.jackson.databind.util.JSONPObject;

@RestController
@RequestMapping("/roder")
public class RorderController {
	@Autowired
	OrderService orderService;
	@Autowired
	RorderService roserService;
	
	//后台人员根据条件查询订单，得到订单、订单中的菜品数量
	@RequestMapping(value="/getOrders")
	@ResponseBody
	public void getOrderByRequest(@RequestParam("orderId") String orderId, 
				@RequestParam("begin") String beginTime, 
				@RequestParam("end") String endTime,
				HttpServletRequest request) {
		List<Order> orders = orderService.selectByRequire(orderId, beginTime, endTime);
		HashMap<String, Integer> menuNum = roserService.getMenuNum(orders);
		
	}
	

}
