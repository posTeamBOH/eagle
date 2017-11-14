package com.choice.eagle.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.choice.eagle.entity.Menu;
import com.choice.eagle.service.MenuService;

@Controller
@RequestMapping("menu")
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
	
	//删除菜
	@RequestMapping(value="/deleteMenu", method=RequestMethod.POST)
	public boolean deleteMenu(Menu menu) {
		return menuService.deleteByMenuId(menu.getMenuId());
	}
	
	//编辑菜
	
	//增加菜
	

}
