package org.productDomain;

import java.time.LocalDate;

public class Order {

	public int orderId;
	public String firstName;
	public String middleName;
	public String lastName;
	protected long moblie;
	private String address;
	public LocalDate orderDate = LocalDate.now();
	public LocalDate deliveryDate = orderDate.plusDays(2) ;
	public LocalDate returnDate = deliveryDate.plusDays(10);
	
		
//	public Order(int orderId, String firstName, String middleName, String lastName, long moblie) {
//		super();
//		this.orderId = orderId;
//		this.firstName = firstName;
//		this.middleName = middleName;
//		this.lastName = lastName;
//		this.moblie = moblie;
//	}
	
	public Order(int orderId, String firstName, String middleName, String lastName, long moblie,String address, LocalDate orderDate,
			LocalDate deliveryDate, LocalDate returnDate) {
		super();
		this.orderId = orderId;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.moblie = moblie;
		this.address = address;
		this.orderDate = orderDate;
		this.deliveryDate = deliveryDate;
		this.returnDate = returnDate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Order() {
		
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public LocalDate getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(LocalDate deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public LocalDate getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(LocalDate returnDate) {
		this.returnDate = returnDate;
	}

	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public long getMoblie() {
		return moblie;
	}
	public void setMoblie(long moblie) {
		this.moblie = moblie;
	}
	
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", firstName=" + firstName + ", middleName=" + middleName + ", lastName="
				+ lastName + ", moblie=" + moblie + ", orderDate=" + orderDate + ", deliveryDate=" + deliveryDate
				+ ", returnDate=" + returnDate + "]";
	}
	
	
	
}
