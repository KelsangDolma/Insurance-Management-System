package com.ims.client;

import java.util.List;
import java.util.Scanner;
import com.ims.dao.InsuranceCategoryDAO;
import com.ims.dao.InsuranceSubcategoryDAO;

import com.ims.dao.impl.InsuranceCategoryDAOImpl;
import com.ims.dao.impl.InsuranceSubcategoryDAOImpl;
import com.ims.dao.InsurancePolicyDAO;
import com.ims.dao.impl.InsurancePolicyDAOImpl;

import com.ims.pojo.InsuranceCategory;
import com.ims.pojo.InsurancePolicy;
import com.ims.pojo.InsuranceSubcategory;
import com.ims.pojo.User;
import com.ims.dao.impl.UserDAOImpl;
import com.ims.dao.UserDAO;

public class ClientDashboard {
	InsuranceCategoryDAO catDao = new InsuranceCategoryDAOImpl();
	InsuranceSubcategoryDAO scatDao = new InsuranceSubcategoryDAOImpl();
	InsurancePolicyDAO pcatDAO = new InsurancePolicyDAOImpl();
	UserDAO userDao = new UserDAOImpl();

	Scanner sc = new Scanner(System.in);

	public void clientMenu(String username) {
		System.out.println("-----------------------------------------------------");
		System.out.println("                 1)View All Category                   ");
		System.out.println("                 2)View Category                      ");
		System.out.println("                 3)View All SubCategory                      ");
		System.out.println("                 4)View SubCategory                      ");
		System.out.println("                 5)View All Policy                      ");
		System.out.println("                 6)View Policy                      ");
		System.out.println("                 7)Apply for Policy                      ");
		System.out.println("                 8)View my policies                      ");
		System.out.println("                 9)Go Back                              ");
		System.out.println("-----------------------------------------------------");
		System.out.println("Enter your Choice");
		int choice = sc.nextInt();

		switch (choice) {
		case 1:
			List<InsuranceCategory> viewAllCategory = catDao.viewAllInsuranceCategory();
			System.out.println("ID" + "\t" + "Category");
			for (InsuranceCategory c : viewAllCategory) {
				System.out.println(c.getCid() + "\t" + c.getCname());
			}
			clientMenu(username);
			break;
		case 2:
			System.out.println("Enter Category ID");
			InsuranceCategory c = catDao.viewCategory(sc.nextInt());
			System.out.println("ID" + "\t" + "Category");
			if (c != null) {
				System.out.println(c.getCid() + "\t" + c.getCname());
			} else {
				System.out.println("Category Doesnot Exists");
			}
			clientMenu(username);
			break;
		case 3:
			List<InsuranceSubcategory> viewAllSubCategory = scatDao.viewAllInsuranceSubcategory();
			System.out.println("ID" + "\t" + "Sub-Category");
			for (InsuranceSubcategory c1 : viewAllSubCategory) {
				System.out.println(c1.getSid() + "\t" + c1.getSname());
			}
			clientMenu(username);
			break;
		case 4:
			System.out.println("Enter Sub-Category ID");
			InsuranceSubcategory c1 = scatDao.viewSubcategory(sc.nextInt());
			System.out.println("ID" + "\t" + "Sub-Category");
			if (c1 != null) {
				System.out.println(c1.getSid() + "\t" + c1.getSname());
			} else {
				System.out.println("SubCategory Doesnot Exists");
			}
			clientMenu(username);
			break;
		case 5:
			List<InsurancePolicy> viewAllPolicy = pcatDAO.viewAllPolicy();
			System.out.println("ID" + "\t" + "Policy" + "\t" + "PolicyPrice");
			for (InsurancePolicy p : viewAllPolicy) {
				System.out.println(p.getPid() + "\t" + p.getPname() + "\t" + p.getPrice());
			}
			clientMenu(username);
			break;
		case 6:
			System.out.println("Enter Policy ID");
			InsurancePolicy p = pcatDAO.viewPolicy(sc.nextInt());
			System.out.println("ID" + "\t" + "Policy" + "\t" + "PolicyPrice");
			if (p != null) {
				System.out.println(p.getPid() + "\t" + p.getPname());
			} else {
				System.out.println("Policy Doesn't Exist");
			}
			clientMenu(username);
			break;
		case 7:
			System.out.println("Enter the Policy you want to Apply");
			pcatDAO.buyPolicy(sc.nextInt(), username);
			break;
		case 8:

			List<User> users = userDao.viewAllUsers();

			for (User u : users) {
				if (u.getUserName().equals(username)) {
					List<InsurancePolicy> policies = u.getPolicy();
					for (InsurancePolicy p1 : policies) {
						System.out.println("My current Policies");
						System.out.println(
								p1.getHolder() + "\t" + p1.getPid() + "\t" + p1.getPname() + "\t" + p1.getPrice());
					}
				}
			}
		case 9:
			ImsClient.main(null);
			break;
		default:
			System.out.println("Choose from 1 to 3");
		}
	}

	public void ClientMenuSubCat() {
		System.out.println("--------------------------------------------------------- ");
		System.out.println("                 1)View All SubCategory                   ");
		System.out.println("                 2)View Sub Category                      ");
		System.out.println("                 3)Go Back                                 ");
		System.out.println("--------------------------------------------------------- ");


		System.out.println("Enter your Choice");
		int choice = sc.nextInt();

		switch (choice) {
		case 1:
			List<InsuranceSubcategory> viewAllSubCategory = scatDao.viewAllInsuranceSubcategory();
			for (InsuranceSubcategory c : viewAllSubCategory) {
				System.out.println(c.getSid() + "\t" + c.getSname());
			}
			ClientMenuSubCat();
			break;
		case 2:
			System.out.println("Enter Sub-Category ID");
			InsuranceSubcategory c = scatDao.viewSubcategory(sc.nextInt());
			if (c != null) {
				System.out.println(c.getSid() + "\t" + c.getSname());
			} else {
				System.out.println("SubCategory Doesn't Exist");
			}
			ClientMenuSubCat();
			break;
		case 3:
			System.exit(0);
			break;
		default:
			System.out.println("Choose from 1 to 3");
		}
	}
}
