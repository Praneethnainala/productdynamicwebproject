package org.productDomain;

import java.util.Date;

public class ProductDetails {
	private int productId;
	private String productName;
	private String brandName;
	private String category;
	private int modelYear;
	private double listPrice;
	public int orderId;

	public ProductDetails(int productID, String productName, String brandName, String category, int modelYear,
			double listPrice, int orderId) {
		super();
		this.productId = productID;
		this.productName = productName;
		this.brandName = brandName;
		this.category = category;
		this.modelYear = modelYear;
		this.listPrice = listPrice;
		this.orderId = orderId;
	}

	


	public ProductDetails() {
		// TODO Auto-generated constructor stub
	}




	public int getProductId() {
		return productId;
	}




	public void setProductId(int productId) {
		this.productId = productId;
	}




	public String getProductName() {
		return productName;
	}




	public void setProductName(String productName) {
		this.productName = productName;
	}




	public String getBrandName() {
		return brandName;
	}




	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}




	public String getCategory() {
		return category;
	}




	public void setCategory(String category) {
		this.category = category;
	}




	public int getModelYear() {
		return modelYear;
	}




	public void setModelYear(int modelYear) {
		this.modelYear = modelYear;
	}




	public double getListPrice() {
		return listPrice;
	}




	public void setListPrice(double listPrice) {
		this.listPrice = listPrice;
	}




	public int getOrderId() {
		return orderId;
	}




	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}




	@Override
	public String toString() {
		return "ProductDetails [productId=" + productId + ", productName=" + productName + ", brandName=" + brandName
				+ ", category=" + category + ", modelYear=" + modelYear + ", listPrice=" + listPrice + ",orderId="+orderId+"]";
	}

	

}
