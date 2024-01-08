package com.ims.dao;

import java.util.List;
import com.ims.pojo.InsurancePolicy;


public interface InsurancePolicyDAO {
	public void addPolicy();
	public List<InsurancePolicy> viewAllPolicy();
	InsurancePolicy viewPolicy(int pid);
	public boolean deletePolicy();
	public void updatePolicy();
	public void buyPolicy(int pid, String username);
	

}
