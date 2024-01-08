package com.ims.dao.impl;

import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;

import com.ims.dao.InsurancePolicyDAO;
import com.ims.pojo.InsuranceCategory;
import com.ims.pojo.InsurancePolicy;
import com.ims.pojo.User;



public class InsurancePolicyDAOImpl implements InsurancePolicyDAO {
	Scanner sc = new Scanner(System.in);
	List<InsurancePolicy> addPolicy = new ArrayList<>();

	@Override
	public void addPolicy() {
		// TODO Auto-generated method stub

		int k = 1;
		while (k == 1) {
			System.out.println("Enter Policy Id");

			int pid = sc.nextInt();
			System.out.println("Enter Policy Name");
			String pname = sc.next();

			System.out.println("Enter Policy Quantity");
			int pqty = sc.nextInt();

			System.out.println("Enter Policy Price");
			int price = sc.nextInt();

			InsurancePolicy policy = new InsurancePolicy();

			addPolicy.add(policy);

			System.out.println("Policy Added SuccessFully");

			System.out.println("Do you want add one more policy");
			k = sc.nextInt();

		} // end of while

	}

	@Override
	public List<InsurancePolicy> viewAllPolicy() {
		// TODO Auto-generated method stub
		return addPolicy;
	}

	@Override
	public InsurancePolicy viewPolicy(int pid) {
		// TODO Auto-generated method stub

		for (InsurancePolicy pa : addPolicy) {
			if (pa.getPid() == pid) {
				return pa;

			}
		}

		return null;
	}
	@Override
	public boolean deletePolicy() {
		// TODO Auto-generated method stub
		System.out.println("Enter the Policy ID to delete");
		int policyToRemove = sc.nextInt();
		sc.nextLine();
		
		for(InsurancePolicy pa : addPolicy)
		{
			if(pa.getPid()==policyToRemove)
			{
				addPolicy.remove(pa);
				System.out.println("Policy deleted sucessfully");
				return true;
			}
		}
		
		return true;
	}
	public void updatePolicy()
	{
		System.out.println("Enter the Policy Id to update: ");
		int PolicyToUpdate =sc.nextInt();
		
		for(InsurancePolicy pa : addPolicy ) {
			if(pa.getPid() == PolicyToUpdate) {
				System.out.println("Enter the new Policy Name: ");
				String newPolicyName =sc.next();
				
			pa.setPname(newPolicyName);
			System.out.println("Category updated sucessfully");
			
			}
			
		}	
	}
	@Override
	public void buyPolicy(int pid, String username) {
		// TODO Auto-generated method stub
		
		int k=0;
		for(InsurancePolicy pa : addPolicy)
		{
			if(pa.getPid()==pid)
			{
				List<User> user = new UserDAOImpl().viewAllUsers();
				for(User u : user ) {
					if (u.getUserName().equals(username))
					{
						List<InsurancePolicy> upolicy = u.getPolicy();
						InsurancePolicy newpolicy = new InsurancePolicy(pid, pa.getPname(),pa.getPqty(), pa.getPrice() );
						newpolicy.setHolder(username);
						upolicy.add(newpolicy);
						u.setPolicy(upolicy);
					}
				}
				System.out.println("Thanks for buying this policy");
				++k;
			}
		}
		if(k==0)
			System.out.println("No policies in stock");

	}

}