package com.ssd.tour.model;

public class Booking {

	private int booking_id;
	private String name;
	private String mail;
	private int package_id;
	private int bike_id;
	private int quantity;
	private int addCard;
	private int dayss;

	public Booking() {
		super();
	}

	public Booking(int booking_id, String name, String mail, int package_id, int bike_id, int quantity, int addCard,int dayss) {
		super();
		this.booking_id = booking_id;
		this.name = name;
		this.mail = mail;
		this.package_id = package_id;
		this.bike_id = bike_id;
		this.quantity = quantity;
		this.addCard = addCard;
		this.dayss=dayss;
	}

	public int getBooking_id() {
		return booking_id;
	}

	public void setBooking_id(int booking_id) {
		this.booking_id = booking_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public int getPackage_id() {
		return package_id;
	}

	public void setPackage_id(int package_id) {
		this.package_id = package_id;
	}

	public int getBike_id() {
		return bike_id;
	}

	public void setBike_id(int bike_id) {
		this.bike_id = bike_id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getAddCard() {
		return addCard;
	}

	public void setAddCard(int addCard) {
		this.addCard = addCard;
	}
	public int getDays() {
		return dayss;
	}

	public void setDays(int dayss) {
		this.dayss = dayss;
	}

}
