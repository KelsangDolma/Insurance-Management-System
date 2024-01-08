package com.ims.dao;

import java.util.List;

import com.ims.pojo.InsuranceCategory;


public interface InsuranceCategoryDAO {
	void addCategory();
	List<InsuranceCategory>viewAllInsuranceCategory();
	InsuranceCategory viewCategory(int cid);

	void updateCategory();
	public boolean deleteCategory();
	public void managePolicy();
	
}
