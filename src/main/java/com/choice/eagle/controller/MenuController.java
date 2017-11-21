package com.choice.eagle.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.fastjson.JSON;
import com.choice.eagle.entity.Cuisine;
import com.choice.eagle.entity.Menu;
import com.choice.eagle.service.CuisineService;
import com.choice.eagle.service.MenuService;

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
	public List<Menu> getMenus(HttpServletRequest request, HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin", "*");
		String menuId = request.getParameter("foodName");
		String beginTime = request.getParameter("beginTime");
		String endTime = request.getParameter("endTime");
		logger.info("====start====");
		if (menuId == "") menuId = null;
		List<Cuisine> list = cuisineService.selectAllCuisines();
		List<Menu> menus = menuService.selectByRequire(menuId, beginTime, endTime);
		if (menus != null && menus.size() > 0) {
			for (Menu menu : menus) {
				String cuiId = menu.getCuisineId();
				for (int i = 0; i < list.size(); i++) {
					if (list.get(i).getCuisineId().equals(cuiId)) {
						menu.setCuisineId(list.get(i).getCuisineName());
						break;
					}
				}
			}
		}
		logger.error("MenuController,getMenus方法");
		logger.debug("参数为:{},{},{},{}", menuId, beginTime, endTime);
		logger.info("====end====");
		return menus;
	}
	
	//返回所有的菜目信息和对应的菜品信息
	@RequestMapping(value ="/selectCuisineMenu", produces = { "application/json;charset=UTF-8" }  )
	@ResponseBody
	public String selectCuisineMenu(HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin", "*");
		Map<String, Object> map = null;
		List<Cuisine> list = cuisineService.selectAllCuisines();
		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
		for (Cuisine cuisine : list) {
			map = new HashMap<String, Object>();
			map.put("key", cuisine.getCuisineId());
			map.put("foodClass", cuisine.getCuisineName());
			List<Menu> menus = menuService.selectByCuisine(cuisine.getCuisineId());
			map.put("food", menus);
			mapList.add(map);
		}
		return JSON.toJSONString(mapList);
	}
	
	//删除菜
	//后台人员点击删除
	@RequestMapping(value="/deleteMenu.do", method=RequestMethod.POST)
	@ResponseBody
	public List<Menu> deleteMenu(String menuName, HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		Menu menu = menuService.selectByRequire(menuName, null, null).get(0);
		menu.setMenuRem("已下架");
		menuService.updateMenu(menu);
		return  menuService.selectByRequire(null, null, null);
	}
	
	//编辑菜
	//后台人员确定修改菜品
	@RequestMapping(value="/update.do", method=RequestMethod.POST)
	@ResponseBody
	public String updateMenu(Menu menu, HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		return menuService.updateMenu(menu) == 0 ? "false" : "true";
	}
	
	//增加菜
	//后台人员添加菜品
	@RequestMapping(value="/addMenu.do", method=RequestMethod.POST)
	@ResponseBody
	public List<Menu> add(HttpServletRequest request, HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		logger.info("====start====");
		Menu menu = new Menu();
		menu.setMenuName(request.getParameter("AfoodName"));
		menu.setMenuMoney(request.getParameter("AFoodPrice"));
		menu.setMenuFir(request.getParameter("AfoodWord"));
		menu.setMenuNum(request.getParameter("AddFoodSize"));
		menu.setMenuMate(request.getParameter("AddFoodCL"));
		menu.setMenuRem(request.getParameter("AddFoodMark"));
		menu.setMenuDate(request.getParameter("NowData"));
		String cuisineName = request.getParameter("AddfoodClass");
		String cuisineId = cuisineService.selectCuisineId(cuisineName);
		menu.setCuisineId(cuisineId);
		menuService.insertMenu(menu);
		logger.debug("参数:{},{},{},{},{},{},{}",request.getParameter("AfoodName"),
				request.getParameter("AFoodPrice"),
				request.getParameter("AfoodWord"),
				request.getParameter("AddFoodSize"),
				request.getParameter("AddFoodCL"),
				request.getParameter("AddFoodMark"),
				cuisineName);
		logger.error("MenuController类  add方法");
		logger.info("====end====");
		return menuService.selectByRequire(null, null, null);
	}

	//获得余量不足菜品
	@RequestMapping("/selectByMenu")
	@ResponseBody
	public List<Menu> selectByMenu(HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin", "*");
		return menuService.selectByMenu();
	}
	
	//根据菜名模糊查询
	@RequestMapping("/selectByName")
	@ResponseBody
	public List<Menu> selectByName(@Param("name") String name, HttpServletRequest request
			, HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin", "*");
		List<Menu> list = menuService.selectByName(name);
		return list;
	}
	
	//根据菜目查询菜品
	@RequestMapping("/selectByCuisine")
	@ResponseBody
	public List<Menu> selectByCuisine(@Param("CuisineId") String CuisineId, HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin", "*");
		List<Menu> list = menuService.selectByCuisine(CuisineId);
		return list;
	}
}
