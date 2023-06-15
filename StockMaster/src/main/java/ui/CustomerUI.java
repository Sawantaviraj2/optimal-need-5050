package ui;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Scanner;

import entity.Customer;
import entity.LoggedInUserId;
import exception.NoRecordFoundException;
import exception.SomeThingWentWrongException;
import service.CustomerService;
import service.CustomerServiceImpl;
import service.OrderService;
import service.OrderServiceImpl;

public class CustomerUI {

	public static void userRegistration(Scanner sc) {
		// TODO Auto-generated method stub
		System.out.print("Enter name ");
		String name = sc.next();
		System.out.print("Enter username ");
		String username = sc.next();
		System.out.print("Enter password ");
		String password = sc.next();
		System.out.print("Enter date of birth ");
		LocalDate dateOfBirth = LocalDate.parse(sc.next());
		
		Customer customer = new Customer(name,username,password,dateOfBirth, new HashSet<>());
		
		try {
			CustomerService customerService = new CustomerServiceImpl();
			customerService.addCustomer(customer);
			System.out.println("Customer added successfully");
		}catch(SomeThingWentWrongException ex) {
			System.out.println(ex);
		}
		
	}
	public static void userLogin(Scanner sc) {
		// TODO Auto-generated method stub
		System.out.print("Enter username ");
		String username = sc.next();
		System.out.print("Enter password ");
		String password = sc.next();
		try {
			CustomerService customerService = new CustomerServiceImpl();
			customerService.login(username, password);
			System.out.println("Loged in Successfully");
			userMenu(sc);
		} catch (NoRecordFoundException | SomeThingWentWrongException ex) {
			System.out.println(ex.getMessage());
		}
	}

	private static void purchaseNewStock(Scanner sc) {
		// TODO Auto-generated method stub
		System.out.println("Enter Stock Id");
		int id = sc.nextInt();
		System.out.print("Enter Stock name ");
		String planName = sc.next();
		try {
			OrderService orderService = new OrderServiceImpl();
			orderService.purchaseStock(id, planName);
			System.out.println("Stock purchased Successfully");
		} catch (SomeThingWentWrongException ex) {
			System.out.println(ex.getMessage());
		}
	}

	private static void ViewPurchasedStocks(Scanner sc) {
		// TODO Auto-generated method stub
		try {
			CustomerService customerService = new CustomerServiceImpl();
			customerService.ViewPurchasedStocks();
		} catch (NoRecordFoundException | SomeThingWentWrongException ex) {
			System.out.println(ex.getMessage());
		}
	}

	private static void SellStock(Scanner sc) {
		// TODO Auto-generated method stub
		System.out.println("Enter Sell Stock Id");
		int id = sc.nextInt();
		System.out.println("Enter Stock Name");
		String stockName = sc.next();

		try {
			CustomerService customerService = new CustomerServiceImpl();
			customerService.SellStock(id, stockName);
		} catch (NoRecordFoundException | SomeThingWentWrongException ex) {
			System.out.println(ex.getMessage());
		}

	}

	private static void ChangePassword(Scanner sc) {
		// TODO Auto-generated method stub
		System.out.print("Enter old password ");
		String oldPassword = sc.next();
		System.out.print("Enter new password ");
		String newPassword = sc.next();
		System.out.print("Re-Enter new password ");
		String reEnterNewPassword = sc.next();
		
		if(!newPassword.equals(reEnterNewPassword)) {
			System.out.println("New password and Re-Entered password mismtached");
			return;
		}else if(newPassword.equals(oldPassword)) {
			System.out.println("New password and old password must be different");
			return;
		}

		try {
			CustomerService customerService = new CustomerServiceImpl();
			customerService.changePassword(oldPassword, reEnterNewPassword);
			System.out.println("Password updated");
		}catch(SomeThingWentWrongException ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	private static void DeleteAccount(Scanner sc) {
		// TODO Auto-generated method stub
		System.out.print("Are you sure you want to delete your account?[y/n] ");
		char choice = sc.next().toLowerCase().charAt(0);
		if(choice == 'y') {
			try {
				CustomerService customerService = new CustomerServiceImpl();
				customerService.deleteAccount();
				System.out.println("Its really sad to see you go, As per your request account is deleted");			
			}catch(SomeThingWentWrongException ex) {
				System.out.println(ex.getMessage());
			}
		}
		
	}
	private static void userMenu(Scanner sc) {
		int choice = 0;
		do {
			displayUserMenu();
			System.out.print("Enter selection ");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				AdminUI.viewStocks();
				break;
			case 2:
				purchaseNewStock(sc);
				break;
			case 3:
				ViewPurchasedStocks(sc);
				break;
			case 4:
				SellStock(sc);
				break;
			case 5:
				ChangePassword(sc);
				break;
			case 6 :
				DeleteAccount(sc);
				System.out.println("Account Deleted Successfully");
				break;
			case 0:
				LoggedInUserId.loggedInUserId = -1; // -1 id cannot belong to any customer
				System.out.println("LogedOut Successfully");
				break;
			default:
				System.out.println("Invalid Selection, try again");
			}
		} while (choice != 0);

	}
	private static void displayUserMenu() {
		System.out.println("1. View All Stocks");
		System.out.println("2. Purchase a new Stock");
		System.out.println("3. View Purchased Stocks");
		System.out.println("4. Sell Stock");
		System.out.println("5. Change Password");
		System.out.println("6. Delete Account");
		System.out.println("0. Logout");

	}



}
