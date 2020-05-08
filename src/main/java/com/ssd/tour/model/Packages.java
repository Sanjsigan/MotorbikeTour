package com.ssd.tour.model;

public class Packages {
	
	private int id;
	private String PacName;
	private String type;
	private int amount;
	private String desc;
	public Packages() {
		super();
	}

	public Packages(int id, String PacName, String type, int amount, String desc) {
		super();
		this.id=id;
		this.PacName=PacName;
		this.type=type;
		this.amount=amount;
		this.desc=desc;
		
	}
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getPacName() {
		return PacName;
	}


	public void setPacName(String pacName) {
		PacName = pacName;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public int getAmount() {
		return amount;
	}


	public void setAmount(int amount) {
		this.amount = amount;
	}


	public String getDesc() {
		return desc;
	}


	public void setDesc(String desc) {
		this.desc = desc;
	}



	
	
	
	
	

}
