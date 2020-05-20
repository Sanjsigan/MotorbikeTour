package com.ssd.tour.model;

public class Hotel {
	private int ID;
	private String Name;
	private String Address;
	private double Amount;
	
	public Hotel(int iD, String name, String address, double amount) {
		super();
		ID = iD;
		Name = name;
		Address = address;
		Amount = amount;
	}
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public double getAmount() {
		return Amount;
	}
	public void setAmount(double amount) {
		Amount = amount;
	}
	
}
