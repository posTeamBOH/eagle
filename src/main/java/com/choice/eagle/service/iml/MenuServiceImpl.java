package com.choice.eagle.service.iml;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.choice.eagle.dao.MenuDao;
import com.choice.eagle.entity.Menu;
import com.choice.eagle.service.MenuService;
import com.choice.eagle.util.UuidUtil;

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
	public int  insertMenu(Menu menu) {
		// TODO Auto-generated method stub
		menu.setMenuId(UuidUtil.getId());
		return menuDao.insertMenu(menu);
	}

	@Override
	public int deleteByMenuId(String menuId) {
		// TODO Auto-generated method stub
		return menuDao.deleteByMenuId(menuId);
	}

	@Override
	public int  updateMenu(Menu menu) {
		// TODO Auto-generated method stub
		return menuDao.updateMenu(menu);
	}

	@Override
	public List<Menu> selectByRequire(String menuName, String beginTime, String endTime) {
		ObjectMap map = new ObjectMap();
		map.setMenuName(menuName);
		map.setBeginTime(beginTime);
		map.setEndTime(endTime);
		return menuDao.selectByRequire(map);
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
