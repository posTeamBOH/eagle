package com.choice.eagle.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.choice.eagle.entity.Cuisine;
import com.choice.eagle.service.CuisineService;

@Controller
@RequestMapping("/cuisine")
public class CuisineController {
	@Autowired
	private CuisineService cuisineService;
	
	@RequestMapping("/selectAllCuisines.do")
	public @ResponseBody List<Cuisine> selectAllCuisines(HttpServletResponse response){
		 response.setHeader("Access-Control-Allow-Origin", "*");
		 List<Cuisine> list = new ArrayList<Cuisine>();
		 
		 list = cuisineService.selectAllCuisines() ;
		
		 return list;
		
	}
}
