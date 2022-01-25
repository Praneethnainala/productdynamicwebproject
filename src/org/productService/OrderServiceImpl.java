package org.productService;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.productDomain.Order;

public class OrderServiceImpl implements OrderService {
	List<Order> orderList = new ArrayList<>();

	@Override
	public List<Order> getAllOrder() {
		return orderList;
	}

	@Override
	public List<Order> addOrder(Order order) {
		orderList.add(order);
		return orderList;
	}

	@Override
	public Order deleteOrder(int orderId) {
		// TODO Auto-generated method stub
		return orderList.remove(orderId);
	}

	@Override
	public Order getOrderId(int orderId) {
		for (Order p : orderList) {
			if (p.getOrderId() == orderId) {
				return p;
			}
		}
		return null;
	}

	@Override
	public List<String> getProductOrder() {
		return null;
	}

	@Override
	public Order updatemoblie(int orderId, long moblie) {
		for (Order order : orderList) {
			if (order.getOrderId() == orderId) {
				order.setMoblie(moblie);
				return order;
			}
		}
		return null;
	}

}
