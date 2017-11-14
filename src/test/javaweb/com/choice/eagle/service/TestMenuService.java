package com.choice.eagle.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.choice.eagle.BaseTest;
import com.choice.eagle.entity.Menu;

public class TestMenuService extends BaseTest{

	@Autowired
	private MenuService menuService;
	
	@Test
	public void testAll() {
		List<Menu> ByMenuList = menuService.selectByMenu();
		List<Menu> ByCuisineList = menuService.selectByCuisine("C1001");
		List<Menu> ByNameList = menuService.selectByName("SC");
		assertEquals("M1002", ByMenuList.get(0).getMenuId());
		assertEquals(2, ByCuisineList.size());
		assertEquals(2, ByNameList.size());
	}
}
