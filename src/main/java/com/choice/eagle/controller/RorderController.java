package com.choice.eagle.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.choice.eagle.entity.MenuNum;
import com.choice.eagle.entity.Order;
import com.choice.eagle.entity.Rorder;
import com.choice.eagle.service.OrderService;
import com.choice.eagle.service.RorderService;
import com.fasterxml.jackson.databind.util.JSONPObject;

@RestController
@RequestMapping("/roder")
public class RorderController {
	@Autowired
	OrderService orderService;
	@Autowired
	RorderService rorderService;
	

	@RequestMapping(value="/getOrders", method = RequestMethod.POST)
	@ResponseBody
	public List<Order> getOrderByRequest(@RequestParam("orderId") String orderId, 
				@RequestParam("begin") String begin, 
				@RequestParam("end") String end) {
		List<Order> orders = orderService.selectByRequire(orderId, begin, end);
		HashMap<String, Object> menuNum = rorderService.getMenuNum(orders);
		for (Order order : orders) {
			int count = (int) menuNum.get(order.getOrderId());
			order.setOrderRemark("" + count);
		}
		return orders;
	}

	@RequestMapping("/selectMenuByOrderId")
	@ResponseBody
	public List<MenuNum> selectMenuByOrderId(@RequestParam("orderId") String orderId){
		List<MenuNum> list = rorderService.selectMenuByOrderId(orderId);
		return list;
	}
	
	@RequestMapping("/empty")
	@ResponseBody
	public List<Order> emptygetOrderByRequest(){

		List<Order> orders = orderService.selectByRequire(null, null, null);
		HashMap<String, Object> menuNum = rorderService.getMenuNum(orders);
		for (Order order : orders) {
			int count = (int) menuNum.get(order.getOrderId());
			order.setOrderRemark("" + count);
		}
		menuNum.put("orders", orders);
		return orders;
	}
	
	//提交订单
	@RequestMapping("/commitOrder")
	@ResponseBody
	public String commitOrder(String tableId, String orderDate, String orderMoney, String orderNum,
			String orderRemark, HashMap<String, Integer> menuNum) {
		rorderService.insertOrder(tableId, orderDate, orderMoney, orderNum, orderRemark, menuNum);
		return "";
	}
}
