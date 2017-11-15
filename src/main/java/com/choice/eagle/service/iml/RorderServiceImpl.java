package com.choice.eagle.service.iml;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.choice.eagle.dao.RorderDao;
import com.choice.eagle.entity.MenuNum;
import com.choice.eagle.entity.Order;
import com.choice.eagle.service.RorderService;

@Service
public class RorderServiceImpl implements RorderService{
	@Autowired
	private RorderDao rorderDao;
	@Override
	public List<MenuNum> selectMenuByOrderId(String orderId) {
		// TODO Auto-generated method stub
		return rorderDao.selectMenuByOrderId(orderId);
	}


	@Override
	public void updateMenuStatus(String orderId) {
		// TODO Auto-generated method stub
		rorderDao.updateMenuStatus(orderId);
	}

	//根据订单号查询菜品数量
	@Override
	public HashMap<String, Integer> getMenuNum(List<Order> orders) {
		HashMap<String, Integer> menuNum = new HashMap<>();
		for (int i = 0; i < orders.size(); i++) {
			Order order = orders.get(i);
			int num = rorderDao.countAllMenuByOrderId(order.getOrderId());
			menuNum.put(order.getOrderId(), num);
		}
		return menuNum;
	}



}
