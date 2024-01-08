package com.ims.pojo;
import java.util.Iterator;

public class InsuranceCategory {
	private int cid;
	private String cname;
	//private List<InsuranceSubcategory> subcat = new ArrayList;
	
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public InsuranceCategory(int cid, String cname) {
		super();
		this.cid = cid;
		this.cname = cname;
	}
	public InsuranceCategory() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public static Iterator<InsuranceCategory> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
}
