package com.ssd.tour.model;

public class Hotel {
	
	private int id;
	private String name;
	private String address;
	private double amount;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Hotel(int id, String name, String address, double amount) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.amount = amount;
	}
	
}
