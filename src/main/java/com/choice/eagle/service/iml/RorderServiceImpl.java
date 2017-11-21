package com.choice.eagle.service.iml;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.choice.eagle.dao.MenuDao;
import com.choice.eagle.dao.RorderDao;
import com.choice.eagle.dao.TableDao;
import com.choice.eagle.entity.Menu;
import com.choice.eagle.entity.MenuNum;
import com.choice.eagle.entity.Order;
import com.choice.eagle.entity.Rorder;
import com.choice.eagle.service.RorderService;
import com.choice.eagle.util.UuidUtil;

@Service
public class RorderServiceImpl implements RorderService{
	Logger logger = LoggerFactory.getLogger(RorderServiceImpl.class);
	@Autowired
	private RorderDao rorderDao;
	@Autowired
	private TableDao tableDao;
	@Autowired
	private MenuDao menuDao;
	@Override
	public List<MenuNum> selectMenuByOrderId(String orderId) {
		return rorderDao.selectMenuByOrderId(orderId);
	}

	//上菜改变状态
	@Override
	public int updateMenuStatus(String orderId,String menuName) {
		int num = rorderDao.updateMenuStatus(orderId, menuName);
		return num;
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
		 * 3.增加订单明细 + 减少菜品数量
		 */

	@Override
	@Transactional
	public String insertOrder(String tableId, Order order, HashMap<String, Integer> menuNum) {
		String orderId = UuidUtil.getOrderId();
		
	
		//改变桌子状态
		tableDao.updateTableStatus(tableId, "1");
		//添加订单
		order.setOrderId(orderId);
		order.setTablesId(tableId);
		order.setOrderType("未结算");
		//添加订单明细
		for (String key : menuNum.keySet()) {
			Menu menu = menuDao.selectByRequire(key, null, null).get(0);
			String menuId = menu.getMenuId();
			for (int i = 0; i < (int) menuNum.get(key); i++) {
				String rorderId = UuidUtil.getRorderId();
				Rorder rorder = new Rorder();
				rorder.setOrderId(orderId);
				rorder.setMenuId(menuId);
				rorder.setRorderId(rorderId);
				rorder.setRorderType("0");
				rorderDao.insertRorder(rorder);
			}
			//减少菜品数量
			String munum = menu.getMenuNum();
			menu.setMenuNum((Integer.parseInt(munum) - menuNum.get(key)) + "");
			menuDao.updateMenu(menu);
		}
		return "true";
		
	}
	
	//点击结账改变桌子，订单，订单联系状态
	@Override
	@Transactional
	public int updateAllStatus(String tableId, String orderId) {
		logger.info("====start====");
		//查询订单中没上的菜的个数
		int i=rorderDao.countNotUpdate(orderId);
		if(i==0) {
			try {
				rorderDao.updateTableStatus(tableId, "已付款");
				rorderDao.updateOrderStatus(orderId);
			} catch (Exception e) {
				logger.error("桌位状态改变出错");
				throw new RuntimeException("updateAllStatus");
			}
			logger.debug("参数:{},{}", tableId, orderId);
			logger.info("====end====");
			return 1;
		}else {
			logger.info("====end====");
			return 0;
		}
	}


	//删除菜单明细
	@Override
	public int deleteRorder(String orderId, String menuName) {
		String menuId = menuDao.selectMenuIdByName(menuName);
		return rorderDao.deleteRorder(orderId, menuId);
	}


}
