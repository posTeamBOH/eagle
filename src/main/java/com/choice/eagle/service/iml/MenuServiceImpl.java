package com.choice.eagle.service.iml;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.choice.eagle.cache.JedisUtil;
import com.choice.eagle.dao.MenuDao;
import com.choice.eagle.entity.Menu;
import com.choice.eagle.service.MenuService;
import com.choice.eagle.util.UuidUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class MenuServiceImpl implements MenuService{
	Logger logger = LoggerFactory.getLogger(MenuServiceImpl.class);
	@Autowired
	private MenuDao menuDao;
	@Autowired
	private JedisUtil.Keys jedisKeys;
	@Autowired
	private JedisUtil.Strings jedisStrings;

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
		menu.setMenuId(UuidUtil.getMenuId());
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
		logger.info("====start====");
		int num = menuDao.updateMenu(menu);
		//将修改的菜品信息加入redis
		if (num != 0) {
			ObjectMapper mapper = new ObjectMapper();
			List<Menu> list = menuDao.selectByRequire(menu.getMenuName(), null, null);
			Menu menu2 = list.get(0);
			String jsonString = null;
			try {
				jsonString = mapper.writeValueAsString(menu2);
			} catch (JsonProcessingException e) {
				logger.error("json转换出现错误", e);
				e.printStackTrace();
			}
			if(jsonString != null) jedisStrings.set(menu2.getMenuName(), jsonString);
		}
		logger.debug("参数为:{}", menu.toString());
		logger.info("====end====");
		return num;
	}

	//根据菜品编号、时间、页数查询菜品信息
	@Override
	public List<Menu> selectByRequire(String menuName, String beginTime, String endTime) {
		logger.info("====start====");
		List<Menu> list = null;
		ObjectMapper mapper = new ObjectMapper();
		if (menuName == null && beginTime == null && endTime == null) {
			try {
				list = menuDao.selectByRequire(menuName, beginTime, endTime);
			} catch (Exception e) {
				logger.error("根据菜品编号、时间、页数查询菜品信息错误", e);
				e.printStackTrace();
			}
			for (Menu menu : list) {
				String jsonString = null;
				try {
					jsonString = mapper.writeValueAsString(menu);
				} catch (JsonProcessingException e) {
					logger.error("json转换错误", e);
					e.printStackTrace();
				}
				jedisStrings.set(menu.getMenuName(), jsonString);
			}
		}else if (menuName != null && jedisKeys.exists(menuName)){
			String jsonString = jedisStrings.get(menuName);
			JavaType javaType = mapper.getTypeFactory().constructType(Menu.class);
			try {
				Menu menu = mapper.readValue(jsonString, javaType);
				list = new ArrayList<Menu>();
				list.add(menu);
			} catch (IOException e) {
				logger.error("json转换实体类错误");
				e.printStackTrace();
			}
		}else {
			list = menuDao.selectByRequire(menuName, beginTime, endTime);
		}
		logger.debug("参数为:{},{},{}", menuName, beginTime, endTime);
		logger.info("====end====");
		return list;
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
