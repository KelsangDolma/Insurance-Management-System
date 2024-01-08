package com.ims.dao.impl;

import java.util.ArrayList;

import java.util.Iterator;


import java.util.List;
import java.util.Scanner;

import com.ims.dao.InsuranceSubcategoryDAO;
import com.ims.pojo.InsuranceCategory;
import com.ims.pojo.InsuranceSubcategory;

public class InsuranceSubcategoryDAOImpl implements InsuranceSubcategoryDAO {
	Scanner sc = new Scanner(System.in);
	List<InsuranceSubcategory> subcategories = new ArrayList<>();

	@Override
	public void addSubcategory() {
		// TODO Auto-generated method stub

		int k = 1;
		while (k == 1) {
			System.out.println("Enter SubCategory Id");

			int sid = sc.nextInt();
			System.out.println("Enter SubCategory Name");
			String sname = sc.next();


			InsuranceSubcategory scat = new InsuranceSubcategory();

			subcategories.add(scat);

			System.out.println("Category Added SuccessFully");

			System.out.println("Do you want add one more category");
			k = sc.nextInt();

		} // end of while

	}

	@Override
	public List<InsuranceSubcategory> viewAllInsuranceSubcategory() {
		// TODO Auto-generated method stub
		return subcategories;
	}

	@Override
	public InsuranceSubcategory viewSubcategory(int sid) {
		// TODO Auto-generated method stub

		for (InsuranceSubcategory sa : subcategories) {
			if (sa.getSid() == sid) {
				return sa;

			}
		}

		return null;
	}

	@Override
	public void updateSubCategory() {
		// TODO Auto-generated method stub
		System.out.println("Enter the Sub-Category Id to update: ");
		int SubcategoryToUpdate =sc.nextInt();
		
		for(InsuranceSubcategory sub: subcategories ) {
			if(sub.getSid() == SubcategoryToUpdate) {
				System.out.println("Enter the new Sub-Category Name: ");
				String newSubCategoryName =sc.next();
				
			sub.setSname(newSubCategoryName);
			System.out.println("Sub-Category updated sucessfully");
			return;
			}
			
		}
	}

	@Override
	public boolean deleteSubCategory() {
		// TODO Auto-generated method stub
		System.out.println("Enter the Sub-Category to ID to Remove: ");
		int SubcategoryToDelete =sc.nextInt();
		sc.nextLine();

        Iterator<InsuranceSubcategory> iterator = subcategories.iterator();

        while (iterator.hasNext()) {
        	InsuranceSubcategory subcategory = iterator.next();
            if (subcategory.getSid() == SubcategoryToDelete) {
                iterator.remove(); // Use iterator to safely remove the category
                System.out.println("Sub-Category deleted successfully");
                return true;
            }
        }

        System.out.println("Sub-Category not found");
        return false; // Return false if the category was not found and deleted
	}
}

