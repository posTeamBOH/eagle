package com.choice.eagle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.choice.eagle.service.OrderService;

@Controller
@RequestMapping("/order")
public class OrderController {	
	
	@Autowired
	private OrderService orderService;
	
}
