package com.ims.dao;

import java.util.List;

import com.ims.pojo.InsuranceSubcategory;

public interface InsuranceSubcategoryDAO {
	public void addSubcategory();
	List<InsuranceSubcategory>viewAllInsuranceSubcategory();
	InsuranceSubcategory viewSubcategory(int sid);
	void updateSubCategory();
	public boolean deleteSubCategory();
}
