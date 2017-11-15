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
	
	//得到菜品
	/**
	 * 后台人员根据条件查询菜
	 */
	@RequestMapping(value="/getMenu.do", method=RequestMethod.POST)
	public void getMenus(@RequestParam("menuId") String menuId, @RequestParam("beginTime") String beginTime, @RequestParam("end") String endTime, HttpServletRequest request) {
		List<Menu> menus = null;
		menus = menuService.selectByRequire(menuId, beginTime, endTime);
		request.setAttribute("menus", menus);	
	}
	
	//删除菜
	//后台人员点击删除
	@RequestMapping(value="/deleteMenu.do", method=RequestMethod.POST)
	public int deleteMenu(Menu menu) {
		return menuService.deleteByMenuId(menu.getMenuId());
	}
	
	//编辑菜
	//后台人员确定修改菜品
	@RequestMapping(value="/update.do", method=RequestMethod.POST)
	public int updateMenu(Menu menu) {
		return menuService.updateMenu(menu);
	}
	
	//增加菜
	//后台人员添加菜品
	@RequestMapping(value="/addMenu.do", method=RequestMethod.POST)
	public int add(Menu menu) {
		return menuService.insertMenu(menu);
	}
	

}
