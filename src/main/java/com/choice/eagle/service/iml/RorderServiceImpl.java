package com.choice.eagle.service.iml;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	public int updateMenuStatus(String orderId,String menuName) {
		// TODO Auto-generated method stub
		return rorderDao.updateMenuStatus(orderId, menuName);
	}

	//根据订单号查询菜品数量
	@Override
	public HashMap<String, Object> getMenuNum(List<Order> orders) {
		HashMap<String, Object> menuNum = new HashMap<>();
		for (int i = 0; i < orders.size(); i++) {
			Order order = orders.get(i);
			int num = rorderDao.countAllMenuByOrderId(order.getOrderId());
			menuNum.put(order.getOrderId(), num);
		}
		return menuNum;
	}

	//点击结账改变桌子，订单，订单联系状态
	@Override
	@Transactional
	public int updateAllStatus(String tableId, String orderId) {
		int i=rorderDao.countNotUpdate(orderId);
		if(i==0) {
			rorderDao.updateTableStatus(tableId, "0");
			rorderDao.updateOrderStatus(orderId);
			return 1;
		}else {
			return 0;
		}
		
		
	}



}
