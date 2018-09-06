package net.eimarketing.eim20180410.dao;

import java.util.List;

import net.eimarketing.eim20180410.entity.Order;

public interface OrderDao {

	public List<Order> findOrder();	//查询所有电影票订单
	public List<Order> findOrderByDoor(Order order);	//通过影厅查找电影票订单
	public int getMaxdoor();	//获取最大影厅数
	public int addOrder(Order order);	//添加电影票订单
	public int getNum();	//获取有多少人订票
}
