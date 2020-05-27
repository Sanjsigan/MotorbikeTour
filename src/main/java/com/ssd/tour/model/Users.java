package com.ssd.tour.model;

import com.ssd.tour.dao.USER_ROLES;

public class Users {

	private int id;
	private String name;
	private String address;
	private int mobile;
	private String mail;
	private String password;
	private USER_ROLES role;

	public Users() {
		super();
	}

	public Users(int id, String name, String address, int mobile, String mail, String password, USER_ROLES role) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.mobile = mobile;
		this.mail = mail;
		this.password = password;
	}

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

	public int getMobile() {
		return mobile;
	}

	public void setMobile(int mobile) {
		this.mobile = mobile;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return mail;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public USER_ROLES getRole() {
		return role;
	}

	public void setRole(USER_ROLES role) {
		this.role = role;
	}

}
