package com.choice.eagle.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.choice.eagle.entity.Cuisine;
import com.choice.eagle.entity.MenuNum;
import com.choice.eagle.service.OrderService;
import com.choice.eagle.service.RorderService;

@Controller
@RequestMapping("/order")
<<<<<<< HEAD
public class OrderController {
=======
public class OrderController {	
	
	@Autowired
	private RorderService rorderService;
	//根据订单号查询订单的每个菜品及数量
	@RequestMapping("/selectMenuByOrderId.do")
	public @ResponseBody List<MenuNum> selectMenuByOrderId(@Param("orderId")String orderId){
		
		 List<MenuNum> list = new ArrayList<MenuNum>();
		 
		 list = rorderService.selectMenuByOrderId(orderId) ;
		
		 return list;
		
	}
>>>>>>> 84afe1e5002d7bccd42a8ec9cf921613d0da4880
}
