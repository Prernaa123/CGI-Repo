package com.cgi.bean;

public class Customer {
	
	private int customerID;
	private String customerName;
	private String CustomerAddress;
	
	
	
	public Customer(int customerID, String customerName, String customerAddress) {
		super();
		this.customerID = customerID;
		this.customerName = customerName;
		CustomerAddress = customerAddress;
	}
	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerAddress() {
		return CustomerAddress;
	}
	public void setCustomerAddress(String customerAddress) {
		CustomerAddress = customerAddress;
	}
	@Override
	public String toString() {
		return "Customer [customerID=" + customerID + ", customerName=" + customerName + ", CustomerAddress="
				+ CustomerAddress + "]";
	}
	
	
	

}
