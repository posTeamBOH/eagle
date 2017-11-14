package com.choice.eagle.service.iml;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.choice.eagle.dao.MenuDao;
import com.choice.eagle.entity.Menu;
import com.choice.eagle.entity.Order;
import com.choice.eagle.service.MenuService;

@Service
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

	@Override
	public void insertMenu(Menu menu) {
		// TODO Auto-generated method stub
		menuDao.insertMenu(menu);
	}

	@Override
	public void deleteByMenuId(String menuId) {
		// TODO Auto-generated method stub
		menuDao.deleteByMenuId(menuId);
	}

	@Override
	public void updateMenu(Menu menu) {
		// TODO Auto-generated method stub
		menuDao.updateMenu(menu);
	}

	@Override
	public List<Menu> selectByRequire(String menuName, String beginTime, String endTime) {
		// TODO Auto-generated method stub
		return menuDao.selectByRequire(menuName, beginTime, endTime);
	}

	@Override
	public int countKinds() {
		// TODO Auto-generated method stub
		return menuDao.countKinds();
	}

	@Override
	public int countEmpty() {
		// TODO Auto-generated method stub
		return menuDao.countEmpty();
	}

	@Override
	public int countLess(int menuNum) {
		// TODO Auto-generated method stub
		return menuDao.countLess(menuNum);
	}
}
