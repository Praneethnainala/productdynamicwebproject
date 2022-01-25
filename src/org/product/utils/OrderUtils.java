package org.product.utils;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.productDomain.Order;
import org.productDomain.ProductDetails;

public class OrderUtils {

	Connection connection;
	PreparedStatement stmt;
	ResultSet rs;

	public Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			try {
				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/productdetails", "root",
						"Praneeth@1");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}
		return connection;
	}

	public void insertOrder(Order order) {
		try {
			stmt = getConnection().prepareStatement("insert into orderInfo values (?,?,?,?,?,?,?,?,?)");
			stmt.setInt(1, order.getOrderId());
			stmt.setString(2, order.getFirstName());
			stmt.setString(3, order.getMiddleName());
			stmt.setString(4, order.lastName);
			stmt.setLong(5, order.getMoblie());
			stmt.setString(6, order.getAddress());
			stmt.setDate(7, Date.valueOf(order.orderDate));
			stmt.setDate(8, Date.valueOf(order.getDeliveryDate()));
			stmt.setDate(9, Date.valueOf(order.returnDate));
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void deleteOrder(int orderId) {
		try {
			stmt = getConnection().prepareStatement("delete from orderinfo where orderId=?");
			stmt.setInt(1, orderId);;
			stmt.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public Order getByorderId(int orderId) {
		Order order = new Order();
		try {
			stmt = getConnection().prepareStatement("select * from orderinfo where orderId =?");
			stmt.setInt(1, orderId);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
			 order =(new Order(rs.getInt("orderId"),rs.getString("firstName"),rs.getString("middlename"),rs.getString("lastname"),rs.getLong("moblie"),rs.getString("address"),rs.getDate("orderDate").toLocalDate(),
					 rs.getDate("deliveryDate").toLocalDate(),rs.getDate("returnDate").toLocalDate()));
			//return order;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return order;

	}

	public List<Order> getAllOrder() {
		List<Order> m = new ArrayList<>();
		try {
			stmt = getConnection().prepareStatement("select * from OrderInfo");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				m.add(new Order(rs.getInt("orderId"),rs.getString("firstName"), rs.getString("middleName"),rs.getString("lastname"),rs.getLong("moblie"),rs.getString("address"),rs.getDate("orderDate").toLocalDate(),
						 rs.getDate("deliveryDate").toLocalDate(),rs.getDate("returnDate").toLocalDate()));

	 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return m;

	}
	public List<String> getProductOrderDetails() {
		Order order ;
		ProductDetails s;
		List bag = new ArrayList <>();
		try {
			stmt = getConnection().prepareStatement(" select * from productinfo p join orderinfo o where p.orderId = o.orderId order by 1" );
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				s = new ProductDetails(rs.getInt("productID"), rs.getString("productName"),
						rs.getString("BrandName"), rs.getString("category"), rs.getInt("modelYear"),
						rs.getDouble("listPrice"),rs.getInt("orderId"));
				order =new Order(rs.getInt("orderId"),rs.getString("firstName"), rs.getString("middleName"),rs.getString("lastname"),rs.getLong("moblie"),rs.getString("address"),rs.getDate("orderDate").toLocalDate(),
						 rs.getDate("deliveryDate").toLocalDate(),rs.getDate("returnDate").toLocalDate());
				bag.add(s);
				bag.add(order);
				//return bag;
			}


			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bag;
		
	}
	public Order updatemoblie(int orderId,long moblie) {
		Order order = new Order();
		try {
			stmt = getConnection().prepareStatement("update productinfo set moblie=? where orderId=?");
			stmt.setLong(1, order.getMoblie());
			stmt.setInt(2, order.getOrderId());
			stmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
}
