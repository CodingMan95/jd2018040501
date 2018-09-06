package net.eimarketing.eim20180410.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.eimarketing.eim20180410.dao.OrderDao;
import net.eimarketing.eim20180410.entity.Order;
import net.eimarketing.eim20180410.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDao orderdao;
	Order order;

	@Override
	public int addOrder(Order order) {

		int maxdoor = orderdao.getMaxdoor();

		order.setDoor(maxdoor);

		List<Order> list = orderdao.findOrderByDoor(order);

		if (list.size() >= 48) {
			order.setDoor(maxdoor + 1);
		} else {
			order.setDoor(maxdoor);
		}

		orderdao.addOrder(order);
		System.out.println("order:" + order);
		return 200;
	}

	@Override
	public List<Order> findOrder() {
		
		Integer maxdoor = orderdao.getMaxdoor();
		System.out.println("orderdao.getMaxdoor():" + orderdao.getMaxdoor());
		System.out.println("maxdoor:" + maxdoor);
		Order or = new Order();
		or.setDoor(maxdoor);
		List<Order> list = orderdao.findOrderByDoor(or);

		return list;
	}

	@Override
	public int getMaxdoor() {
		return orderdao.getMaxdoor();
	}

	@Override
	public List<Order> findOrderByDoor(Order order) {
		return orderdao.findOrderByDoor(order);
	}

	@Override
	public int getNum() {
		return orderdao.getNum();
	}

}
