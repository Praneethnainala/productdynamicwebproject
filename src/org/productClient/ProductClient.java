package org.productClient;

import java.sql.SQLException;
import java.time.LocalDate;

import org.productDomain.Order;
import org.productDomain.ProductDetails;
import org.productService.OrderService;
import org.productService.OrderServiceImpl;
import org.productService.OrderServiceJdbcImpl;
import org.productService.ProductJDBCImpl;
import org.productService.ProductServices;
import org.productService.ProductServicesImpl;

public class ProductClient {

	public static void main(String[] args) throws SQLException {
		ProductDetails Order1 = new ProductDetails(1, "Nike tshrit", "nike", "clothes", 2021, 2999.9, 1);

		ProductDetails Order2 = new ProductDetails(2, "canvas", "redtape", "shoes", 2021, 599.9, 2);
		ProductDetails Order3 = new ProductDetails(3, "11 pro", "iphone", "moblie", 2021, 49999.9, 3);
		ProductDetails Order4 = new ProductDetails(4, "apple", "shimla", "food", 2021, 499.9, 4);
		ProductDetails Order7 = new ProductDetails(7, "13 pro", "iphone", "moblie", 2021, 49999.9, 5);
		ProductDetails Order8 = new ProductDetails(10, "14 pro", "myphone", "moblie", 2021, 49999.9, 10);
		ProductServices cart = new ProductServicesImpl();
//		cart.addproduct(Order1);
//		cart.addproduct(Order2);
//		cart.addproduct(Order3);
//		cart.addproduct(Order4);
//		cart.addproduct(Order7);
		//first

//		System.out.println(cart.getProductsByProductId(5));
//		System.out.println(cart.getAllproduct());
//		System.out.println(cart.deleteProduct(7));
//		System.out.println(cart.updatePrice(2, 100.0));
//		System.out.println(cart.getByCategory("shoes"));
//		System.out.println(cart.getByCategory("shoes"));
//		System.out.println(cart.getTopNproduct(3));
//		System.out.println(cart.sortByPrice());

//	

		ProductJDBCImpl obj = new ProductJDBCImpl();

//		obj.addproduct(Order1);
//		obj.addproduct(Order2);
//		obj.addproduct(Order3);
//		obj.addproduct(Order4);
////		obj.addproduct(Order5);
////		obj.addproduct(Order6);
//		obj.addproduct(Order7);
		System.out.println(obj.addproduct(Order8));

//		System.out.println(obj.getProductsByProductId(7));
//		System.out.println(obj.getAllproduct());
//		System.out.println(obj.getByCategory("shoes"));
//		System.out.println(obj.getTopNproduct(3));
//		System.out.println(obj.updatePrice(2, 100.0));
//		System.out.println(obj.sortByPrice());
//		System.out.println(obj.deleteProduct(7));

		Order obj1 = new Order();
		OrderService obj2 = new OrderServiceImpl();
		OrderService customerDetails = new OrderServiceJdbcImpl();
		Order customer1 = new Order(1, "praneeth", "ram", "nainala", 9032249499L, "sanjeev nagar", LocalDate.now(),
				obj1.deliveryDate, obj1.returnDate);
		Order customer2 = new Order(2, "pradhu", "saradi", "developer", 945645645L, "kacharapalem", LocalDate.now(),
				obj1.deliveryDate, obj1.returnDate);
		Order customer3 = new Order(3, "teja", null, "kota", 945645645L, "veojipalem", LocalDate.now(),
				obj1.deliveryDate, obj1.returnDate);
		Order customer4 = new Order(4, "nishita", "kiran", " Gotiyada", 945645645L, "dodapathi", LocalDate.now(),
				obj1.deliveryDate, obj1.returnDate);
		Order customer5 = new Order(5, "monika", "kumari", "tangula", 945645645L, "pendurthi", LocalDate.now(),
				obj1.deliveryDate, obj1.returnDate);
		Order customer6 = new Order(6, "satish", null, "patnala", 945645645L, "rajamundary", LocalDate.now(),
				obj1.deliveryDate, obj1.returnDate);
		Order customer7 = new Order(7, "nagendra", "rao", "b", 945645645L, "gopalapatnam", LocalDate.now(),
				obj1.deliveryDate, obj1.returnDate);
//		obj2.addOrder(customer7);
//		customerDetails.addOrder(customer1);
//		customerDetails.addOrder(customer2);
//		customerDetails.addOrder(customer3);
//		customerDetails.addOrder(customer4);
//		customerDetails.addOrder(customer5);
//		customerDetails.addOrder(customer6);
//		customerDetails.addOrder(customer7);
////		customerDetails.addOrder(customer4);
//customerDetails.getProductOrder();
//		customerDetails.deleteOrder(1);
//		customerDetails.deleteOrder(2);
//		customerDetails.deleteOrder(3);
//		customerDetails.deleteOrder(4);
//		customerDetails.deleteOrder(5);
//		customerDetails.deleteOrder(6);
//		customerDetails.deleteOrder(7);
//		System.out.println(customerDetails.getAllOrder());
//		System.out.println(customerDetails.getOrderId(2));
//		System.out.println(customerDetails.getProductOrder());
//		System.out.println(customerDetails.);
//		System.out.println(obj2.updatemoblie(7, 1000000L));
	}

}
