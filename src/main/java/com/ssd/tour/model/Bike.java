package com.ssd.tour.model;

public class Bike {

	private int id;
	private String model;
	private String maximumHorse;
	private double amount;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getMaximumHorse() {
		return maximumHorse;
	}
	public void setMaximumHorse(String maximumHorse) {
		this.maximumHorse = maximumHorse;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public Bike(int id, String model, String maximumHorse, double amount) {
		super();
		this.id = id;
		this.model = model;
		this.maximumHorse = maximumHorse;
		this.amount = amount;
	}
	
	
}
