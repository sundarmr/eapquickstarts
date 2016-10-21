package com.fuse.eap.model;

public class SoapCustomer {
	private String customerName;
	private String customerAge;
	private String companyName;
	private SoapAddress address;
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerAge() {
		return customerAge;
	}
	public void setCustomerAge(String customerAge) {
		this.customerAge = customerAge;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public SoapAddress getAddress() {
		return address;
	}
	public void setAddress(SoapAddress address) {
		this.address = address;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getCustomerName()+" "+getCustomerAge()+" "+getCompanyName()+" "+getAddress().getAddressLine1()+
				" "+getAddress().getAddressLine2()+" "+getAddress().getCity()+" "+getAddress().getState()+" "
				+getAddress().getCountryName()+" "+getAddress().getZipCode();
	}
}
