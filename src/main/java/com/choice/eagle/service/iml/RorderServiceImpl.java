package com.choice.eagle.service.iml;

import java.util.HashMap;
import java.util.List;

import javax.print.attribute.standard.RequestingUserName;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.choice.eagle.dao.MenuDao;
import com.choice.eagle.dao.OrderDao;
import com.choice.eagle.dao.RorderDao;
import com.choice.eagle.dao.TableDao;
import com.choice.eagle.entity.MenuNum;
import com.choice.eagle.entity.Order;
import com.choice.eagle.entity.Rorder;
import com.choice.eagle.service.RorderService;
import com.choice.eagle.util.UuidUtil;
import com.fasterxml.jackson.databind.node.DoubleNode;

@Service
public class RorderServiceImpl implements RorderService{
	@Autowired
	private RorderDao rorderDao;
	@Autowired
	private TableDao tableDao;
	@Autowired
	private OrderDao orderDao;
	@Autowired
	MenuDao menuDao;
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

	//提交订单
		/**
		 * 1.改变桌子的状态0-1
		 * 2.增加订单
		 * 3.增加订单明细
		 */

	@Override
	@Transactional
	public String insertOrder(String tableId, String orderDate, String orderMoney, String orderNum,
			String orderRemark, HashMap<String, Integer> menuNum) {
		String orderId = UuidUtil.getId();
		//改变桌子状态
		tableDao.updateTableStatus(tableId, "1");
		//添加订单
		Order order = new Order();
		order.setOrderId(orderId);
		order.setTablesId(tableId);
		order.setOrderDate(orderDate);
		order.setOrderMoney(Double.parseDouble(orderMoney));
		order.setOrderNum(Double.parseDouble(orderNum));
		order.setOrderType("0");
		order.setOrderRemark(orderRemark);
		int aws = orderDao.insertOrder(order);
		//添加订单明细
		for (String key : menuNum.keySet()) {
			String menuId = menuDao.selectMenuIdByName(key);
			for (int i = 0; i < menuNum.get(key); i++) {
				String rorderId = UuidUtil.getId();
				Rorder rorder = new Rorder();
				rorder.setOrderId(orderId);
				rorder.setMenuId(menuId);
				rorder.setRorderId(rorderId);
				rorder.setRorderType("0");
			}
		}
		
		return "true";
		
	}
	//点击结账改变桌子，订单，订单联系状态
	@Override
	@Transactional
	public int updateAllStatus(String tableId, String orderId) {
		int i=rorderDao.countNotUpdate(orderId);
		if(i==0) {
			try {
				rorderDao.updateTableStatus(tableId, "0");
				rorderDao.updateOrderStatus(orderId);
			} catch (Exception e) {
				throw new RuntimeException("updateAllStatus");
			}
			
			return 1;
		}else {
			return 0;
		}
		
		
	}


	//删除菜单明细
	@Override
	public int deleteRorder(String orderId, String menuName) {
		// TODO Auto-generated method stub
		String menuId = menuDao.selectMenuIdByName(menuName);
		return rorderDao.deleteRorder(orderId, menuId);
	}


}
