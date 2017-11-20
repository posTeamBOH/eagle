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

	//菜品数量为0的菜品信息
	@Override
	public List<Menu> selectByMenu() {
		// TODO Auto-generated method stub
		return menuDao.selectByMenu();
	}

	//根据菜品类别查询菜品信息
	@Override
	public List<Menu> selectByCuisine(String cuisineId) {
		// TODO Auto-generated method stub
		return menuDao.selectByCuisine(cuisineId);
	}

	//根据菜品汉拼首字母查询菜品信息
	@Override
	public List<Menu> selectByName(String name) {
		// TODO Auto-generated method stub
		return menuDao.selectByName(name);
	}

	//根据菜品编号查询相应菜品数量
	@Override
	public int countMenuById(String menuId) {
		// TODO Auto-generated method stub
		return menuDao.countMenuById(menuId);
	}

	//插入新菜品
	@Override
	public int  insertMenu(Menu menu) {
		// TODO Auto-generated method stub
		menu.setMenuId(UuidUtil.getId());
		return menuDao.insertMenu(menu);
	}

	//删除菜品
	@Override
	public int deleteByMenuId(String menuId) {
		// TODO Auto-generated method stub
		return menuDao.deleteByMenuId(menuId);
	}

	//修改菜品信息
	@Override
	public int  updateMenu(Menu menu) {
		// TODO Auto-generated method stub
		return menuDao.updateMenu(menu);
	}

	//根据菜品编号、时间、页数查询菜品信息
	@Override
	public List<Menu> selectByRequire(String menuName, String beginTime, String endTime) {
		
		return menuDao.selectByRequire(menuName, beginTime, endTime);
	}

	//统计菜种类合计
	@Override
	public int countKinds() {
		// TODO Auto-generated method stub
		return menuDao.countKinds();
	}

	//统计数量为0的菜品合计数量
	@Override
	public int countEmpty() {
		// TODO Auto-generated method stub
		return menuDao.countEmpty();
	}

	//根据条件查询余量不足的菜
	@Override
	public int countLess(int menuNum) {
		// TODO Auto-generated method stub
		return menuDao.countLess(menuNum);
	}
}
