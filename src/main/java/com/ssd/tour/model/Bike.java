package com.ssd.tour.model;

public class Bike {

	private int id;
	private String model;
	private String MaximumHorse;
	private double Amount;
	
	public Bike() {
		super();
	}
	
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
		return MaximumHorse;
	}
	public void setMaximumHorse(String maximumHorse) {
		MaximumHorse = maximumHorse;
	}
	public double getAmount() {
		return Amount;
	}
	public void setAmount(double amount) {
		Amount = amount;
	}
}
