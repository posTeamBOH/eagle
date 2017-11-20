package com.choice.eagle.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.choice.eagle.cache.JedisUtil;
import com.choice.eagle.entity.Menu;
import com.choice.eagle.service.CuisineService;
import com.choice.eagle.service.MenuService;
import com.fasterxml.jackson.databind.util.JSONPObject;

@Controller
@RequestMapping("/menu")
public class MenuController {
	
	//日志记录
	Logger logger = LoggerFactory.getLogger(MenuController.class);
	
	@Autowired
	private MenuService menuService;
	
	@Autowired
	private CuisineService cuisineService;
	
	//得到菜品
	/**
	 * 此处的menuId为菜品名称
	 * 后台人员根据条件查询菜
	 */
	@RequestMapping(value="/getMenu", method=RequestMethod.POST)
	@ResponseBody
	public List<Menu> getMenus(@RequestParam("foodName") String menuId, @RequestParam("beginTime") String beginTime, @RequestParam("endTime") String endTime) {
		logger.info("====start====");
		if (menuId == "") menuId = null;
		if (beginTime == "") beginTime = null;
		if (endTime == "") endTime = null;
		List<Menu> menus = menuService.selectByRequire(menuId, beginTime, endTime);
		logger.error("MenuController,getMenus方法");
		logger.debug("参数为:{},{},{},{}", menuId, beginTime, endTime);
		logger.info("====end====");
		return menus;
	}
	//删除菜
	//后台人员点击删除
	@RequestMapping(value="/deleteMenu.do", method=RequestMethod.POST)
	@ResponseBody
	public String deleteMenu(Menu menu) {
		return menuService.deleteByMenuId(menu.getMenuId()) == 0  ? "false" : "true";
	}
//	
//	//删除菜
//	@RequestMapping(value="/deleteMenu", method=RequestMethod.POST)
//	public boolean deleteMenu(Menu menu) {
//		return menuService.deleteByMenuId(menu.getMenuId());
//	}
	
	//编辑菜
	//后台人员确定修改菜品
	@RequestMapping(value="/update.do", method=RequestMethod.POST)
	@ResponseBody
	public String updateMenu(Menu menu) {
		return menuService.updateMenu(menu) == 0 ? "false" : "true";
	}
	
	//增加菜
	//后台人员添加菜品
	@RequestMapping(value="/addMenu.do", method=RequestMethod.POST)
	@ResponseBody
	public String add(HttpServletRequest request) {
		logger.info("====start====");
		Menu menu = new Menu();
		menu.setMenuName(request.getParameter("AfoodName"));
		menu.setMenuMoney(request.getParameter("AFoodPrice"));
		menu.setMenuFir(request.getParameter("AfoodWord"));
		menu.setMenuNum(request.getParameter("AddFoodSize"));
		menu.setMenuMate(request.getParameter("AddFoodCL"));
		menu.setMenuRem(request.getParameter("AddFoodMark"));
		String cuisineName = request.getParameter("AddfoodClass");
		String cuisineId = cuisineService.selectCuisineId(cuisineName);
		menu.setCuisineId(cuisineId);
		logger.debug("参数:{},{},{},{},{},{},{}",request.getParameter("AfoodName"),
				request.getParameter("AFoodPrice"),
				request.getParameter("AfoodWord"),
				request.getParameter("AddFoodSize"),
				request.getParameter("AddFoodCL"),
				request.getParameter("AddFoodMark"),
				cuisineName);
		logger.error("MenuController类  add方法");
		logger.info("====end====");
		return menuService.insertMenu(menu) == 0 ? "false" : "true";
	}
	


	//获得余量不足菜品
	@RequestMapping("/selectByMenu")
	@ResponseBody
	public List<Menu> selectByMenu(){
		return menuService.selectByMenu();
	}
	
	//根据菜名模糊查询
	@RequestMapping("/selectByName")
	@ResponseBody
	public List<Menu> selectByName(@Param("name") String name, HttpServletRequest request){
		List<Menu> list = menuService.selectByName(name);
		return list;
	}
	
	//根据菜目查询菜品
	@RequestMapping("/selectByCuisine")
	@ResponseBody
	public List<Menu> selectByCuisine(@Param("CuisineId") String CuisineId){
		List<Menu> list = menuService.selectByCuisine(CuisineId);
		return list;
	}
}
