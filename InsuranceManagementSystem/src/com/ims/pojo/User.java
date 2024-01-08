package com.ims.pojo;

import java.util.ArrayList;
import java.util.List;

public class User {
	private int uid;
	private String firstName;
	private String lastName;
	private String email;
	private String userName;
	private String password;
	private String roleName;//admin/customer
	public List<InsurancePolicy> getPolicy() {
		return policy;
	}

	public void setPolicy(List<InsurancePolicy> policy) {
		this.policy = policy;
	}

	private List<InsurancePolicy> policy =new ArrayList<>();

	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public User(int uid, String firstName, String lastName, String email, String userName, String password, String roleName) {
		super();
		this.uid = uid;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.userName = userName;
		this.password = password;
		this.roleName = roleName;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

 
}
