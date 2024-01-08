package com.ims.dao.impl;

import java.util.ArrayList;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import com.ims.pojo.*;
import com.ims.dao.InsuranceCategoryDAO;

import com.ims.pojo.InsuranceCategory;

public class InsuranceCategoryDAOImpl implements InsuranceCategoryDAO {
	Scanner sc = new Scanner(System.in);
	List<InsuranceCategory> catego = new ArrayList<>();

	@Override
	public void addCategory() {
		// TODO Auto-generated method stub

		int k = 1;
		while (k == 1) {
			System.out.println("Enter Category Id");
            int cid = sc.nextInt();
			System.out.println("Enter Category Name");
			String cname = sc.next();


			InsuranceCategory cat = new InsuranceCategory();

			catego.add(cat);

			System.out.println("Category Added SuccessFully");

			System.out.println("Do you want add one more category");
			k = sc.nextInt();

		} // end of while

	}

	@Override
	public List<InsuranceCategory> viewAllInsuranceCategory() {
		// TODO Auto-generated method stub
		return catego;
	}

	@Override
	public InsuranceCategory viewCategory(int cid) {
		// TODO Auto-generated method stub

		for (InsuranceCategory ca : catego) {
			if (ca.getCid() == cid) {
				return ca;

			}
		}

		return null;
	}
	@Override
	public void updateCategory() {
		// TODO Auto-generated method stub

		System.out.println("Enter the Category Id to update: ");
		int categoryToUpdate = sc.nextInt();

		for (InsuranceCategory c : catego) {
			if (c.getCid() == categoryToUpdate) {
				System.out.println("Enter the new Category Name: ");
				String newCategoryName = sc.next();

				c.setCname(newCategoryName);
				System.out.println("Category updated sucessfully");

			}

		}
	}
	@Override
	public boolean deleteCategory() {
		// TODO Auto-generated method stub
		System.out.println("Enter the Category to ID to Remove: ");
		int categoryToDelete = sc.nextInt();
		sc.nextLine();

        Iterator<InsuranceCategory> iterator = catego.iterator();

        while (iterator.hasNext()) {
        	InsuranceCategory category = iterator.next();

            if (category.getCid() == categoryToDelete) {
                iterator.remove(); // Use iterator to safely remove the category
                System.out.println("Category "+category.getCname()+ " deleted successfully");
                return true;
            }
        }

        System.out.println("Category not found");
        return false; // Return false if the category was not found and deleted
    }
	public void managePolicy() {
		List<User> user = new UserDAOImpl().viewAllUsers();
		for (User u : user) {
			List<InsurancePolicy> upolicy = u.getPolicy();

			for (InsurancePolicy p : upolicy) {
				System.out.println(p.getHolder() + "\t" + p.getPid() + "\t" + p.getPname() + "\t" + p.getPrice() + "\t"
						+ p.isStatus());
			}

		}
		System.out.println("Select username to manage policy");
		String uname = sc.next();
		System.out.println("Select policy ID to manage");
		int pid = sc.nextInt();
		for (User u : user) {
			if (uname == u.getUserName()) {
				List<InsurancePolicy> upolicy = u.getPolicy();

				for (InsurancePolicy p : upolicy) {
					if (pid == p.getPid()) {
						System.out.println("1. Activate  2. Dactivate");
						int option = sc.nextInt();
						switch (option) {
						case 1:
							p.setStatus(true);
							System.out.println("Policy Activated");
							break;
						case 2:
							p.setStatus(false);
							System.out.println("Policy Dactivated");
							break;
						default:
							System.out.println("Select 1 or 2");
						}
					}
				}
			}

		}

	}

}
	