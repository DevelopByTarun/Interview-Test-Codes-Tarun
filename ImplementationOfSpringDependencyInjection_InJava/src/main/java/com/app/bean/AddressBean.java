package com.app.bean;

import org.springframework.stereotype.Component;

@Component(value = "address")
public class AddressBean {
	
	private String city;
	private int pincode;
	
	public AddressBean(String city, int pincode) {
		this.city = city;
		this.pincode = pincode;
	}

	public String getCity() {
		return city;
	}

	public int getPincode() {
		return pincode;
	}

	@Override
	public String toString() {
		return "AddressBean [city=" + city + ", pincode=" + pincode + "]";
	}
}
