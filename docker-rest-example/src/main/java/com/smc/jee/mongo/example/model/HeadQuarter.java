package com.smc.jee.mongo.example.model;

import java.io.Serializable;

import org.mongodb.morphia.annotations.Property;

public class HeadQuarter implements Serializable {
	private static final long serialVersionUID = -6143566079382442200L;

	@Property("country")
	private String country;
	@Property("address")
	private String address;

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
