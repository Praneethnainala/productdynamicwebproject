package org.productService;

import java.sql.ResultSet;
import java.util.List;

import org.productDomain.Order;

public interface OrderService {
	public List<Order> getAllOrder();

	public List<Order> addOrder(Order order);

	public Order deleteOrder(int orderId);

	public Order getOrderId(int orderId);
	
	public List<String> getProductOrder();
	
	public Order updatemoblie(int orderId,long moblie);
	
	 
}
