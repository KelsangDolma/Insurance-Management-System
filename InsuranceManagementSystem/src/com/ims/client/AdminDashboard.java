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

public class AdminDashboard {
	InsuranceCategoryDAO catDao = new InsuranceCategoryDAOImpl();
	InsuranceSubcategoryDAO scatDao = new InsuranceSubcategoryDAOImpl();
	InsurancePolicyDAO pcatDAO = new InsurancePolicyDAOImpl();
	UserDAO userDao = new UserDAOImpl();

	Scanner sc = new Scanner(System.in);

	public void clientMenu(String username) {
		System.out.println("-----------------------------------------------------");
		System.out.println("                 1)ViewAllCategory                   ");
		System.out.println("                 2)ViewCategory                      ");
		System.out.println("                 3)ViewAllSubCategory                 ");
		System.out.println("                 4)ViewSubCategory                    ");
		System.out.println("                 5)ViewAllPolicy                      ");
		System.out.println("                 6)ViewPolicy                         ");
		System.out.println("                 7)ApplyforPolicy                      ");
		System.out.println("                 8)View my policies                   ");
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
				System.out.println("Policy Doesnot Exists");
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
	
	public void adminMenu() {
		while (true) {

			System.out.println("-----------------------------------------------------");

			System.out.println("                 1)View Users                      ");
			System.out.println("                 2)Category Menu                   ");
			System.out.println("                 3)SubCategory Menu                      ");
			System.out.println("                 4)Policy                      ");
			System.out.println("                 5)Manage Policies                   ");
			System.out.println("                 6)Go Back                              ");

			System.out.println("-----------------------------------------------------");

			System.out.println("Enter The choice");
			int choice = sc.nextInt();

			switch (choice) {
			case 1:

				List<User> allUsers = userDao.viewAllUsers();
				for (User u : allUsers) {
					System.out.println(u.getUid() + "\t" + u.getFirstName() + "\t" + u.getLastName() + "\t"
							+ u.getEmail() + "\t" + u.getRoleName());
				}

				break;
			case 2:
				adminMenuCat();
				break;
			case 3:
				adminMenuSubCat();
				break;
			case 4:
				adminMenuPolicy();

				break;
			case 5:
				catDao.managePolicy();

				adminMenuCat();
				break;
			case 6:
				ImsClient.main(null);

			default:
				System.out.println("Choose from 1 to 6");

			}

		}

	}

	public void adminMenuCat() {

		while (true) {
			System.out.println("----------------------------------------------------");

			System.out.println("                 1)Add Category                       ");
			System.out.println("                 2)View All Category                       ");
			System.out.println("                 3)View Category                      ");
			System.out.println("                 4)Update category                      ");
			System.out.println("                 5)Delete category                     ");
			System.out.println("                 6)Go Back                            ");

			System.out.println("----------------------------------------------------");

			System.out.println("Enter one option");
			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				catDao.addCategory();
				adminMenuCat();
				break;
			case 2:
				List<InsuranceCategory> viewAllInsuranceCategory = catDao.viewAllInsuranceCategory();
				System.out.println("ID" + "\t" + "Category");

				for (InsuranceCategory p : viewAllInsuranceCategory) {
					System.out.println(p.getCid() + "\t" + p.getCname());
				}

				adminMenuCat();

				break;
			case 3:

				System.out.println("Enter Product Id");

				InsuranceCategory p = catDao.viewCategory(sc.nextInt());
				System.out.println("ID" + "\t" + "Category");

				if (p != null) {
					System.out.println(p.getCid() + "\t" + p.getCname());

				} else
					System.out.println("Deosnt Exist Look At After Some Time");
				adminMenuCat();
				break;
			case 4:

				catDao.updateCategory();

				break;
			case 5:
				catDao.deleteCategory();

				adminMenuCat();
				break;
			case 6:
				adminMenu();

			default:
				System.out.println("Choose option 1 to 6");
			}
		}
	}

	public void adminMenuSubCat() {
		while (true) {
			System.out.println("-----------------------------------------------------");

			System.out.println("                 1)Add SubCategory                       ");
			System.out.println("                 2)View All SubCategory                   ");
			System.out.println("                 3)View SubCategory                      ");
			System.out.println("                 4)Update SubCategory                    ");
			System.out.println("                 5)Delete SubCategory                    ");
			System.out.println("                 6)Go Back                              ");

			System.out.println("-----------------------------------------------------");

			System.out.println("Enter The choice");
			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				scatDao.addSubcategory();
				adminMenuSubCat();
				break;
			case 2:

				List<InsuranceSubcategory> viewAllSubcategory = scatDao.viewAllInsuranceSubcategory();
				System.out.println("ID" + "\t" + "Sub-Category");
				for (InsuranceSubcategory c : viewAllSubcategory) {
					System.out.println(c.getSid() + "\t" + c.getSname());
				}
				adminMenuSubCat();
				break;
			case 3:
				System.out.println("Enter Sub-Category ID");
				InsuranceSubcategory c = scatDao.viewSubcategory(sc.nextInt());
				System.out.println("ID" + "\t" + "Sub-Category");
				if (c != null) {
					System.out.println(c.getSid() + "\t" + c.getSname());
				} else {
					System.out.println("SubCategory Doesnot Exists");
				}
				adminMenuSubCat();
				break;
			case 4:
				scatDao.updateSubCategory();
				break;
			case 5:
				scatDao.deleteSubCategory();

				adminMenuSubCat();
				break;
			case 6:
				ImsClient.main(null);

			default:
				System.out.println("Choose from 1 to 6");

			}

		}
	}

	public void adminMenuPolicy() {
		while (true) {
			System.out.println("-----------------------------------------------------");

			System.out.println("                 1)Add Policy                       ");
			System.out.println("                 2)View All Policy                   ");
			System.out.println("                 3)View Policy                     ");
			System.out.println("                 4)Update Policy                   ");
			System.out.println("                 5)Delete Policy                    ");
			System.out.println("                 6)Go Back                              ");

			System.out.println("-----------------------------------------------------");

			System.out.println("Enter The choice");
			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				pcatDAO.addPolicy();
				adminMenuPolicy();
				break;
			case 2:

				List<InsurancePolicy> viewAllPolicy = pcatDAO.viewAllPolicy();
				System.out.println("ID" + "\t" + "Policy" + "\t" + "PolicyPrice");
				for (InsurancePolicy p : viewAllPolicy) {
					System.out.println(p.getPid() + "\t" + p.getPname() + "\t" + p.getPrice());
				}
				adminMenuPolicy();
				break;
			case 3:
				System.out.println("Enter Policy ID");
				InsurancePolicy p = pcatDAO.viewPolicy(sc.nextInt());
				System.out.println("ID" + "\t" + "Policy" + "\t" + "PolicyPrice");
				if (p != null) {
					System.out.println(p.getPid() + "\t" + p.getPname() + "\t" + p.getPrice());
				} else {
					System.out.println("Policy Doesn't Exist");
				}
				adminMenuPolicy();
				break;
			case 4:
				pcatDAO.updatePolicy();
				break;
			case 5:
				pcatDAO.deletePolicy();

				adminMenuPolicy();
				break;

			case 6:
				ImsClient.main(null);

			default:
				System.out.println("Choose option 1 to 6");

			}

			
		}
	}
}
