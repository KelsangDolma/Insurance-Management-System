package com.ims.client;

import java.util.Scanner;

import com.ims.dao.impl.UserDAOImpl;

public class ImsClient {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		UserDAOImpl daoImpl = new UserDAOImpl();
		AdminDashboard details = new AdminDashboard();
		ClientDashboard cdetails = new ClientDashboard();

		while (true) {
			System.out.println(" ----------------------------------------------------");
			System.out.println("|             1)Register                             |");
			System.out.println("|             2)Login                                |");
			System.out.println("|             3)ForgotPassword?                      | ");
			System.out.println("|             4)Exit                                 |");
			System.out.println(" ---------------------------------------------------");

			System.out.println("Enter one option");
			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				daoImpl.addUsers();
				break;
			case 2:

				System.out.println("Enter the UserName");
				String uname = sc.next();
				System.out.println("Enter the Password");
				String pass = sc.next();

				// ...
				String msg=daoImpl.verifyUnameAndPass(uname, pass);
				if (msg != null) {
					if (msg == "admin") {
						
					 details.adminMenu();
					 

					} else {
						 cdetails.clientMenu(uname);
					}
				} // end of if
				else
					System.out.println("In Valid User");
				break;
				

			case 3:
				System.out.println("Enter your Email");
				String email = sc.next();
				String password = daoImpl.forgotPassword(email);
				if (password != null)
					System.out.println("Password :   " + password);
				else
					System.out.println("Email doesn't not Exist");
				break;

			case 4:
				System.out.println("Thanks for Using!");
				System.exit(0);
			default:
				System.out.println("Choose option 1 to 4");

			}

		} // end of while

	}

}
