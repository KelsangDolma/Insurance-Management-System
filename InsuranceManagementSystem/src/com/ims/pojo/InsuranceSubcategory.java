package com.ims.pojo;

public class InsuranceSubcategory {
	private int sid;
	private String sname;
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public InsuranceSubcategory(int sid, String sname) {
		super();
		this.sid = sid;
		this.sname = sname;
	}
	public InsuranceSubcategory() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
