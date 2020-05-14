package com.ssd.tour.dao;

public class UserDao {
	
	private static UserDao newInstance = new UserDao();
	
	public static UserDao getInstance() {
		return newInstance;
	}

}
