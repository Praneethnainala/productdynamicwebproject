package org.product.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.productDomain.ProductDetails;

public class ProductUtils {
	Connection connection;
	PreparedStatement stmt;
	ResultSet rs = null;
	ProductDetails details = new ProductDetails();

	public Connection getConnection() throws SQLException {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/productdetails", "root",
					"Praneeth@1");
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}
		return connection;

	}

	public ProductDetails insertProductDetails(ProductDetails product) {
		try {
			getConnection();
			String query1 = "insert into productinfo values(?,?,?,?,?,?,?)";
			stmt = connection.prepareStatement(query1);

			stmt.setInt(1, product.getProductId());
			stmt.setString(2, product.getProductName());
			stmt.setString(3, product.getBrandName());
			stmt.setString(4, product.getCategory());
			stmt.setInt(5, product.getModelYear());
			stmt.setDouble(6, product.getListPrice());
			stmt.setInt(7, product.getOrderId());

			stmt.execute();

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return product;

	}

	public List<ProductDetails> getAllDetails() {
		List<ProductDetails> productList = new ArrayList<ProductDetails>();

		try {

			String query1 = "select * from productinfo";
			PreparedStatement stmt = getConnection().prepareStatement(query1);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
//				details.setProductID(rs.getInt("productID"));
//				details.setProductName(rs.getString("productName"));
//				details.setBrandName(rs.getString("BrandName"));
//				details.setCategory(rs.getString("category"));
//				details.setModelYear(rs.getInt("modelYear"));
//				details.setListPrice(rs.getDouble("listPrice"));
				productList.add(new ProductDetails(rs.getInt("productId"), rs.getString("productName"),
						rs.getString("brandName"), rs.getString("category"), rs.getInt("modelYear"),
						rs.getDouble("listPrice"),rs.getInt("orderId")));
				// productList.add(details);

			}
			return productList;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return productList;

	}

	public void deleteProduct(int productId) {
		try {
			String query2 = "DELETE FROM productinfo WHERE productId=?";
			stmt = getConnection().prepareStatement(query2);

			stmt.setInt(1, productId);
			stmt.execute();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public ProductDetails getproduct(int productId) {
		ProductDetails product = new ProductDetails();
		try {

			// String query ="select * from productinfo where productId =?" ;
			stmt = getConnection().prepareStatement("select * from productinfo where productId =?");
			stmt.setInt(1, productId);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				product = (new ProductDetails(rs.getInt("productID"), rs.getString("productName"),
						rs.getString("BrandName"), rs.getString("category"), rs.getInt("modelYear"),
						rs.getDouble("listPrice"),rs.getInt("orderId")));
			}

			return product;
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return product;

	}

	public ProductDetails getProductByCategory(String category) {
		ProductDetails product = new ProductDetails();
		try {

			stmt = getConnection().prepareStatement("select * from productinfo where category =?");
			stmt.setString(1, category);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				product = (new ProductDetails(rs.getInt("productID"), rs.getString("productName"),
						rs.getString("BrandName"), rs.getString("category"), rs.getInt("modelYear"),
						rs.getDouble("listPrice"),rs.getInt("orderId")));
				return product;
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return product;

	}

	public List<ProductDetails> getTopNProducts(int n) {
		List<ProductDetails> productTop = new ArrayList<>();

		try {

			stmt = getConnection().prepareStatement("Select * from productinfo LIMIT 0,?");
			stmt.setInt(1, n);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {

				productTop.add((new ProductDetails(rs.getInt("productID"), rs.getString("productName"),
						rs.getString("BrandName"), rs.getString("category"), rs.getInt("modelYear"),
						rs.getDouble("listPrice"),rs.getInt("orderId"))));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return productTop;

	}

	public ProductDetails updateprice(int productId, double newPrice) {
		ProductDetails product = new ProductDetails();

		try {
			stmt = getConnection().prepareStatement("update productinfo set ListPrice=? where productID=?");
			stmt.setDouble(1, newPrice);
			stmt.setInt(2, productId);
			stmt.executeUpdate();

			// after update
			stmt = getConnection().prepareStatement("select * from productinfo where productId =?");
			stmt.setInt(1, productId);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				product = (new ProductDetails(rs.getInt("productID"), rs.getString("productName"),
						rs.getString("BrandName"), rs.getString("category"), rs.getInt("modelYear"),
						rs.getDouble("listPrice"),rs.getInt("orderId")));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return product;

	}

	public List<ProductDetails> sortByPrice() {
		List<ProductDetails> productSortByPrice = new ArrayList<>();
		try {
			stmt = getConnection().prepareStatement("select * from productinfo ORDER BY listPrice Desc ");
			rs = stmt.executeQuery();
			while (rs.next()) {
				productSortByPrice.add((new ProductDetails(rs.getInt("productID"), rs.getString("productName"),
						rs.getString("BrandName"), rs.getString("category"), rs.getInt("modelYear"),
						rs.getDouble("listPrice"),rs.getInt("orderId"))));
				
			}
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return productSortByPrice;
		
			
		}

public Map<Integer, ProductDetails> addInMaps(ProductDetails product){
	 Map<Integer, ProductDetails> mapProduct = new HashMap();
	try {
		stmt = getConnection().prepareStatement("select * from productinfo");
		stmt.setInt(1, product.getProductId());
		stmt.setString(2, product.getProductName());
		stmt.setString(3, product.getBrandName());
		stmt.setString(4, product.getCategory());
		stmt.setInt(5, product.getModelYear());
		stmt.setDouble(6, product.getListPrice());
		stmt.setInt(7, product.getOrderId());
    ResultSet rs =stmt.executeQuery();
    while (rs.next()) {
    	mapProduct.put(rs.getInt("productID"), (new ProductDetails(rs.getInt("productID"), rs.getString("productName"),
				rs.getString("BrandName"), rs.getString("category"), rs.getInt("modelYear"),
				rs.getDouble("listPrice"),rs.getInt("orderId"))));
		
    }
     
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return mapProduct;
	
}
	

}
