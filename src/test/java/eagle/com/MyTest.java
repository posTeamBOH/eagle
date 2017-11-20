package eagle.com;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.choice.eagle.dao.MenuDao;
import com.choice.eagle.dao.OrderDao;
import com.choice.eagle.dao.RorderDao;
import com.choice.eagle.dao.TableDao;
import com.choice.eagle.entity.Menu;
import com.choice.eagle.entity.Order;
import com.choice.eagle.entity.Rorder;
import com.choice.eagle.util.UuidUtil;

public class MyTest extends BaseTest{

	
	@Autowired
	TableDao tableDao;
	//测试改变桌子状态
	@Test
	public void testUpdateTableStatus() {
		int a = tableDao.updateTableStatus("T1001", "1");
		//int size = tableDao.selectStatus().size();
		assertEquals(1, a);
	}
	
	
	@Autowired
	OrderDao orderDao;
	@Test
	public void testInsert() {
		String tableId = "T1001";
		String orderDate = "2010-01-01 11:1";
		double orderMoney = 100;
		double orderNum = 10;
		String orderRemark = "";
		Order order = new Order();
		order.setOrderId(UuidUtil.getId());
		order.setTablesId(tableId);
		order.setOrderDate(orderDate);
		order.setOrderMoney(orderMoney);
		order.setOrderMoney(orderMoney);
		order.setOrderNum(orderNum);
		order.setOrderType("0");
		order.setOrderRemark(orderRemark);
		orderDao.insertOrder(order);
		assertEquals(1, orderDao.insertOrder(order));
	}
	//测试添加订单明细
	@Autowired
	RorderDao rorderDao;
	@Test
	public void testIn() {
		String orderId = "O1001";
		String menuId = "M1001";
		String rorderId = UuidUtil.getId();
		Rorder rorder = new Rorder();
		rorder.setOrderId(orderId);
		rorder.setMenuId(menuId);
		rorder.setRorderId(rorderId);
		rorder.setRorderType("0");
		assertEquals(0, rorderDao.insertRorder(rorder));
	}
	
	//根据菜的名字查询菜的id
	 @Autowired
	 MenuDao menuDao;
	 
	 @Test 
	 public void selectMenuIdByNameTest() {
		 assertEquals("M1001", menuDao.selectByRequire("anan", null, null).get(0).getMenuId());
	 }
	

	 //删除菜单明细
	 @Test
	 public void deleteRorderTest() {
		 assertEquals(2, rorderDao.deleteRorder("O1001", "M1001"));
	 }
	 
	 
	 @Test
	 public void testA() {
		 List<Menu> menus = menuDao.selectByRequire("anan", null, null);
		 assertEquals("M1001", menus.get(0).getMenuId());
	 }
	 
	 @Test
	 public void testUp() {
		 Menu menu = new Menu();
		 menu.setMenuId("M1001");
		 menu.setCuisineId("C1001");
		 menu.setMenuName("anan");
		 menu.setMenuMoney("100");
		 menu.setMenuDate("2005-01-07");
		 menu.setMenuNum("11");
		 
		 assertEquals(1, menuDao.updateMenu(menu));
	 }
}