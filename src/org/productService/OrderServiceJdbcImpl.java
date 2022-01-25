package org.productService;

import java.util.List;

import org.product.utils.OrderUtils;
import org.productDomain.Order;

public class OrderServiceJdbcImpl implements OrderService {
	OrderUtils o = new OrderUtils();

	@Override
	public List<Order> getAllOrder() {
		return o.getAllOrder();
	}

	@Override
	public List<Order> addOrder(Order order) {
		o.insertOrder(order);
		return null;
	}

	@Override
	public Order deleteOrder(int orderId) {
		// TODO Auto-generated method stub
		o.deleteOrder(orderId);
		return null;
	}

	@Override
	public Order getOrderId(int orderId) {
		// TODO Auto-generated method stub
	
		return 	o.getByorderId(orderId);
	}

	@Override
	public List<String> getProductOrder() {

		return o.getProductOrderDetails();
	}

	@Override
	public Order updatemoblie(int orderId, long moblie) {
		o.updatemoblie(orderId, moblie);
		return null;
	}

}
