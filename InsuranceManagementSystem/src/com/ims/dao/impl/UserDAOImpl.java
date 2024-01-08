package com.ims.dao.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.ims.dao.UserDAO;
import com.ims.pojo.User;

public class UserDAOImpl implements UserDAO {
	static List<User> addUsers = new ArrayList<>();
	Scanner sc = new Scanner(System.in);

	void loadAdminInfo() {
		User users = new User();
		users.setUid(1);
		users.setEmail("admin@gmail.com");
		users.setPassword("admin");
		users.setRoleName("admin");
		users.setUserName("admin");
		addUsers.add(users);
	}

	@Override
	public void addUsers() {
		// TODO Auto-generated method stub
		int k = 1;
		loadAdminInfo();
		while (k == 1) {
			System.out.println("Enter User ID");
			int id = sc.nextInt();
			System.out.println("Enter First Name");
			String fname = sc.next();
			System.out.println("Enter Last Name");
			String lname = sc.next();
			System.out.println("Enter Email address");
			String email = sc.next();
			System.out.println("Enter User Name");
			String uname = sc.next();
			System.out.println("Enter Password");
			String password = sc.next();

			User user = new User(id, fname, lname, email, uname, password, password);
			user.setRoleName("customer");

			addUsers.add(user);
			System.out.println("Registration Sucessfull");
			System.out.println("Do you want to add more" + "\n" + "1.Yes" + "\n" + "2.No");
			k = sc.nextInt();
		} // end of while loop

	}
	@Override
	public boolean deleteUser(int uid) {
		Iterator<User> iterator = addUsers.iterator();
		while (iterator.hasNext()) {
			User u = iterator.next();
			if (u.getUid() == uid) {
				iterator.remove();
				System.out.println("User with ID: " + uid + " deleted");
				return true;
			}
		}
		System.out.println("User with ID: " + uid + " not found");
		return false;
	}

	@Override
	public String verifyUnameAndPass(String uname, String password) {
		loadAdminInfo();
		// TODO Auto-generated method stub
		String msg = "";
		for (User user : addUsers) {
			
			if (user.getUserName().equals(uname) && user.getPassword().equals(password)) {

				if (user.getRoleName() == "admin") {

					msg = user.getRoleName();
				} else {
					msg = user.getRoleName();
				} // end of If

				break;
			} // end of outer if
			else {
				msg = null;
			}
		} // end of for loop

		return msg;
	}

	@Override
	public String forgotPassword(String email) {
		// TODO Auto-generated method stub
		for (User user : addUsers) {
			if (user.getEmail().equals(email)) {
				return user.getPassword();

			}
		}

		return null;
	}

	@Override
	public List<User> viewAllUsers() {
		// TODO Auto-generated method stub
		return addUsers;
	}
}

	
