package com.ims.dao;

import java.util.List;

import com.ims.pojo.User;

public interface UserDAO {
	
	public void addUsers();

	String verifyUnameAndPass(String uname,String pass);
	
	String forgotPassword(String email);
	
	public List<User>viewAllUsers();
	boolean deleteUser(int uid);

}
