package com.choice.eagle.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.choice.eagle.entity.Menu;
import com.choice.eagle.service.MenuService;

@Controller
@RequestMapping("/menu")
public class MenuController {
	@Autowired
	private MenuService menuService;
	
//	//得到菜品
//	@RequestMapping(value="/getMenu.do")
//	public ModelAndView getMenus(@RequestParam("menuId") String menuId, @RequestParam("beginTime") String beginTime) {
//		Map<String, Object> data = null;
//		data.put("menus", menuService.selectByMenu());
//		return new ModelAndView("data", data);
//	}
	
	//得到菜品
	@RequestMapping(value="/getMenu", method=RequestMethod.POST)
	public void getMenus(@RequestParam("menuId") String menuId, @RequestParam("beginTime") String beginTime, @RequestParam("end") String endTime, HttpServletRequest request) {
		List<Menu> menus = null;
		menus = menuService.selectByRequire(menuId, beginTime, endTime);
		request.setAttribute("menus", menus);
		
	}
//	
//	//删除菜
//	@RequestMapping(value="/deleteMenu", method=RequestMethod.POST)
//	public boolean deleteMenu(Menu menu) {
//		return menuService.deleteByMenuId(menu.getMenuId());
//	}
	
	//编辑菜
	
	//增加菜
	

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
