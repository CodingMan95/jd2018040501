package net.eimarketing.eim20180410.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;

import net.eimarketing.eim20180410.entity.Order;
import net.eimarketing.eim20180410.service.OrderService;
import net.eimarketing.eim20180410.service.impl.OrderServiceImpl;

@Controller
public class OrderController {

	private final static Logger LOGGER = LoggerFactory.getLogger(OrderController.class);

	@Autowired
	private OrderServiceImpl orderServiceImpl;
	@Autowired
	private OrderService orderService;

	@ResponseBody
	@RequestMapping("findOrder.do")
	public JSONObject findOrder(HttpServletRequest req, HttpServletResponse response) throws IOException {

		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
		response.setHeader("Access-Control-Max-Age", "3600");
		response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
		
		int maxdoor = 0;
		Order order = new Order();
		JSONObject rs = new JSONObject();
		
		List<Order> resultOrder = orderServiceImpl.findOrder();
		maxdoor = orderService.getMaxdoor();	//最大影厅数
		//int num = orderService.getNum();	//已订票人数
		
		if (resultOrder.size() == 48) {
			rs.put("door", maxdoor + 1);
			resultOrder.clear();
		} else {
			order.setDoor(maxdoor);
			rs.put("door", maxdoor);
			resultOrder = orderService.findOrderByDoor(order);
		}
		//rs.put("num", num);
		rs.put("order", resultOrder);
		System.out.println(JSONObject.toJSONString(rs));
		return rs;
	}

	@ResponseBody
	@RequestMapping("addOrder.do")
	public int addOrder(Order or, HttpServletResponse response) throws Exception {

		int msg = orderServiceImpl.addOrder(or);

		System.out.println(JSONObject.toJSONString(or));
		return msg;
	}

}
