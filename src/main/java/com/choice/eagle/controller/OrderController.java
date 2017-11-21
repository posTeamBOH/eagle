package com.choice.eagle.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.choice.eagle.entity.MenuNum;
import com.choice.eagle.entity.Order;
import com.choice.eagle.service.OrderService;
import com.choice.eagle.service.RorderService;

@Controller
@RequestMapping("/order")
public class OrderController {	
	
	@Autowired
	private RorderService rorderService;
	@Autowired
	private OrderService orderService;
	//根据订单号查询订单的每个菜品及数量
	@RequestMapping("/selectMenuByOrderId.do")
	public @ResponseBody List<MenuNum> selectMenuByOrderId(@Param("orderId")String orderId, HttpServletResponse response){
		 response.setHeader("Access-Control-Allow-Origin", "*");
		 List<MenuNum> list = new ArrayList<MenuNum>();
		 
		 list = rorderService.selectMenuByOrderId(orderId) ;
		
		 return list;
		
	}
	
	//根据桌号查询订单
	@RequestMapping("/getOrderByTable")
	@ResponseBody
	public List<Order> getOrderByTable(String tableId, HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		List<Order> orders  = orderService.selectByTable(tableId);
		return orders;
	}
	
}
