package com.choice.eagle.controller;

/**
 * 提交订单消息的发送方
 */

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.jms.Destination;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.choice.eagle.cache.JedisUtil;
import com.choice.eagle.entity.MenuNum;
import com.choice.eagle.entity.Order;
import com.choice.eagle.service.OrderService;
import com.choice.eagle.service.ProducerService;
import com.choice.eagle.service.RorderService;
import com.choice.eagle.service.iml.ProducerServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/roder")
public class RorderController {
	
	Logger logger = LoggerFactory.getLogger(RorderController.class);
	@Autowired
	OrderService orderService;
	@Autowired
	RorderService rorderService;
	@Autowired
	private JedisUtil.Keys jedisKeys;
	@Autowired
	private JedisUtil.Strings jedisString;

	//发送消息需要的
	@Autowired
	private ProducerService producerService;
	
	@Autowired
	@Qualifier("queueDestination")
	private Destination destination;
	
	//后台人员根据条件查询订单，得到订单、订单中的菜品数量
	@RequestMapping(value="/getOrders", method = RequestMethod.POST)
	@ResponseBody
	public List<Order> getOrderByRequest(HttpServletRequest request, HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		logger.info("====start====");
		String orderId = request.getParameter("orderId");
		String begin = request.getParameter("begin");
		String end = request.getParameter("end");
		if (orderId == "") orderId = null;
		List<Order> orders = null;
		ObjectMapper mapper = new ObjectMapper();
		if (orderId != null && jedisKeys.exists(orderId)) {
			orders = new ArrayList<Order>();
			String jsonString = jedisString.get(orderId);
			JavaType javaType = mapper.getTypeFactory().constructType(Order.class);
			Order order = null;
			try {
				order = mapper.readValue(jsonString, javaType);
			} catch (IOException e) {
				logger.error("jsonString转换为Order出错" + e);
				e.printStackTrace();
			}
			orders.add(order);
		}
		else {
			orders = orderService.selectByRequire(orderId, begin, end);
			HashMap<String, Object> menuNum = rorderService.getMenuNum(orders);
			for (Order order : orders) {
				int count = (int) menuNum.get(order.getOrderId());
				order.setOrderRemark("" + count);
			}
		}
		logger.error("RorderController类   getOrderByRequest方法");
		logger.debug("参数为:{},{},{},{}", orderId, begin, end);
		logger.info("====end====");
		return orders;
	}

	//通过订单编号得到订单中菜品种类和数量
	@RequestMapping("/selectMenuByOrderId")
	@ResponseBody
	public List<MenuNum> selectMenuByOrderId(@RequestParam("orderId") String orderId, HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin", "*");
		logger.info("====start====");
		List<MenuNum> list = rorderService.selectMenuByOrderId(orderId);
		logger.error("RorderController类  selectMenuByOrderId方法");
		logger.debug("参数为:{}" , orderId);
		logger.info("====end====");
		return list;
	}
	
	//首次加载页面时给的数据
	@RequestMapping("/empty")
	@ResponseBody
	public List<Order> emptygetOrderByRequest(HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin", "*");
		logger.info("====start====");
		long startTime = System.currentTimeMillis();
		List<Order> orders = orderService.selectByRequire(null, null, null);
		HashMap<String, Object> menuNum = rorderService.getMenuNum(orders);
		for (Order order : orders) {
			int count = (int) menuNum.get(order.getOrderId());
			order.setOrderRemark("" + count);
		}
		ObjectMapper mapper = new ObjectMapper();
		for (Order order : orders) {
			String orderid = order.getOrderId();
			String jsonString = null;
			try {
				jsonString = mapper.writeValueAsString(order);
			} catch (JsonProcessingException e) {
				logger.error("json转换出错" + e);
				e.printStackTrace();
			}
			if (jsonString != null) jedisString.set(orderid, jsonString);
		}
		logger.error("RorderController empty方法其中使用参数为 null null null 1");
		long endTime = System.currentTimeMillis();
		logger.debug("costTime:[{}ms]", endTime - startTime);
		logger.info("====end====");
		return orders;
	}
	
	
	//提交订单
	@RequestMapping("/commitOrder")
	@ResponseBody
	public void commitOrder(String tableId, String orderDate, String orderMoney, String orderNum,
			 String menuNum, HttpServletResponse response) {
		System.out.println(menuNum);
		String orderRemark = "";
		response.setHeader("Access-Control-Allow-Origin", "*");
		Order order = new Order();
		order.setOrderDate(orderDate);
		order.setOrderMoney(Double.parseDouble(orderMoney));
		order.setOrderNum(Double.parseDouble(orderNum));
		order.setOrderRemark(orderRemark);
		HashMap<String, Object> jsonString =  new HashMap<>();
		jsonString.put("tableId", tableId);
		jsonString.put("o", order);
		jsonString.put("menu", menuNum);
		producerService.sendMessage(destination, 
				JSON.toJSONString(jsonString));
	}
	//点击上菜改变订单联系表中的菜品状态
	@RequestMapping("/updateMenuStatus")
	@ResponseBody
	public String updateMenuStatus(@RequestParam("orderId") String orderId,@RequestParam("menuName") String menuName, HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		int i=rorderService.updateMenuStatus(orderId, menuName);
		return (i == 0) ? "false" : "true";
		
	}
	//点击结账改变桌子，订单的状态
	@RequestMapping("/updateAllStatus")
	@ResponseBody
	public String updateAllStatus(@RequestParam("orderId") String orderId,@RequestParam("tableId") String tableId, HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		int i=rorderService.updateAllStatus(tableId, orderId);
		return (i == 0) ? "false" : "true";
	}
	//删除菜单明细
	@RequestMapping("/deleteRorder")
	@ResponseBody
	public String deleteRorder(String orderId, String menuName, HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		return rorderService.deleteRorder(orderId, menuName) > 0 ? "true" : "false";
	}
	
	
  
}
