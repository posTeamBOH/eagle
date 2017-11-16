package com.choice.eagle.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.choice.eagle.entity.MenuNum;
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
	RorderService rorderService;

	//后台人员根据条件查询订单，得到订单、订单中的菜品数量
	@RequestMapping(value="/getOrders", method = RequestMethod.POST)
	@ResponseBody
	public List<Order> getOrderByRequest(HttpServletRequest request) {
		String orderId = request.getParameter("orderId");
		String begin = request.getParameter("begin");
		String end = request.getParameter("end");
		if (orderId == "") orderId = null;
		List<Order> orders = orderService.selectByRequire(orderId, begin, end);
		HashMap<String, Object> menuNum = rorderService.getMenuNum(orders);
		for (Order order : orders) {
			int count = (int) menuNum.get(order.getOrderId());
			order.setOrderRemark("" + count);
		}
		return orders;
	}

	//通过订单编号得到订单中菜品种类和数量
	@RequestMapping("/selectMenuByOrderId")
	@ResponseBody
	public List<MenuNum> selectMenuByOrderId(@RequestParam("orderId") String orderId){
		List<MenuNum> list = rorderService.selectMenuByOrderId(orderId);
		return list;
	}
	
	//首次加载页面时给的数据
	@RequestMapping("/empty")
	@ResponseBody
	public List<Order> emptygetOrderByRequest(){
		List<Order> orders = orderService.selectByRequire(null, null, null);
		HashMap<String, Object> menuNum = rorderService.getMenuNum(orders);
		for (Order order : orders) {
			int count = (int) menuNum.get(order.getOrderId());
			order.setOrderRemark("" + count);
		}
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
	//点击上菜改变订单联系表中的菜品状态
	@RequestMapping("/updateMenuStatus")
	@ResponseBody
	public String updateMenuStatus(@RequestParam("orderId") String orderId,@RequestParam("menuName") String menuName) {
		int i=rorderService.updateMenuStatus(orderId, menuName);
		return (i == 0) ? "false" : "true";
		
	}
	//点击结账改变桌子，订单的状态
	@RequestMapping("/updateAllStatus")
	@ResponseBody
	public String updateAllStatus(@RequestParam("orderId") String orderId,@RequestParam("tableId") String tableId) {
		int i=rorderService.updateAllStatus(tableId, orderId);
		return (i == 0) ? "false" : "true";
	}
	
	//删除菜单明细
	@RequestMapping("/deleteRorder")
	@ResponseBody
	public String deleteRorder(String orderId, String menuName) {
		return rorderService.deleteRorder(orderId, menuName) > 0 ? "true" : "false";
	}
  
}
