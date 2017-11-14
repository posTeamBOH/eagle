package com.choice.eagle.service.iml;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.choice.eagle.dao.MenuDao;
import com.choice.eagle.entity.Menu;
import com.choice.eagle.service.MenuService;

public class MenuServiceImpl implements MenuService{
	@Autowired
	private MenuDao menuDao;

	@Override
	public List<Menu> selectByMenu() {
		// TODO Auto-generated method stub
		return menuDao.selectByMenu();
	}

	@Override
	public List<Menu> selectByCuisine(String cuisineId) {
		// TODO Auto-generated method stub
		return menuDao.selectByCuisine(cuisineId);
	}

	@Override
	public List<Menu> selectByName(String name) {
		// TODO Auto-generated method stub
		return menuDao.selectByName(name);
	}

	@Override
	public int countMenuById(String menuId) {
		// TODO Auto-generated method stub
		return menuDao.countMenuById(menuId);
	}
}
