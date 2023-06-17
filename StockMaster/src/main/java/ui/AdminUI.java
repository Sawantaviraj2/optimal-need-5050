package ui;

import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import entity.Customer;
import entity.Stock;
import exception.NoRecordFoundException;
import exception.SomeThingWentWrongException;
import service.CustomerService;
import service.CustomerServiceImpl;
import service.stockService;
import service.stockServiceImpl;

public class AdminUI {

	public static void addStock(Scanner sc) {
		// TODO Auto-generated method stub
		System.out.print("Enter Stock name ");
		String stockName = sc.next();
		System.out.print("Enter establishment year");
		int stockestdYear = sc.nextInt();
		System.out.println("Enter Stock Price");
		int stockPrice = sc.nextInt();
		System.out.print("Enter sector type (Government/private) ");
		String stocksectorType = sc.next();

		// code to create Stock Entity object
		Stock stock = new Stock(stockName, stockestdYear, stockPrice, stocksectorType, new HashSet<>());

//		 Create an object of Service Layer here	
		stockService stockService = new stockServiceImpl();
		try {
			stockService.addStock(stock);
			System.out.println("Stock added successfully");
		} catch (SomeThingWentWrongException ex) {
			System.out.println(ex.getMessage());
		}
	}

	public static void viewStocks(Scanner sc) {
		// TODO Auto-generated method stub

		stockService stockService = new stockServiceImpl();
		try {
			List<Stock> stockList = stockService.getStockList();
			System.out.println(
					"____________________________________________________________________________________________________");
			stockList.forEach(stock -> System.out
					.println("Id: " + stock.getId() + " stock Name:" + stock.getStockName() + " stock Estd Year:"
							+ stock.getStockestdYear() + " stock Sector Type:" + stock.getStocksectorType()+" StockPrice :"+stock.getStockPrice()));
			System.out.println(
					"____________________________________________________________________________________________________");
			System.out.println("\n");

			int ch;
			do {
				System.out.println("1. View stock By Assending Order of Stock Price");
				System.out.println("2. View stock By Desending Order of Stock Price");
				System.out.println("3. View stock By Assending Order of Year");
				System.out.println("4. View stock By Desending Order of Year");
				System.out.println("0. Exit");

				ch = sc.nextInt();
				
				switch(ch) {
				case 1 : 
					stockList.stream().sorted((s1,s2) -> s1.getStockPrice() - s2.getStockPrice()).forEach(st -> System.out.println("Id: " + st.getId() + " stock Name:" + st.getStockName() + " stock Estd Year:"
							+ st.getStockestdYear() + " stock Sector Type:" + st.getStocksectorType()+" StockPrice :"+st.getStockPrice()) );
					System.out.println("\n");
					break;
				case 2:
					stockList.stream().sorted((s1,s2) -> s2.getStockPrice() - s1.getStockPrice()).forEach(st -> System.out.println("Id: " + st.getId() + " stock Name:" + st.getStockName() + " stock Estd Year:"
							+ st.getStockestdYear() + " stock Sector Type:" + st.getStocksectorType()+" StockPrice :"+st.getStockPrice()) );
					System.out.println("\n");
					break;
				case 3 : 
					stockList.stream().sorted((s1,s2) -> s1.getStockestdYear() - s2.getStockestdYear()).forEach(st -> System.out.println("Id: " + st.getId() + " stock Name:" + st.getStockName() + " stock Estd Year:"
							+ st.getStockestdYear() + " stock Sector Type:" + st.getStocksectorType()+" StockPrice :"+st.getStockPrice()) );
					System.out.println("\n");
					break;
				case 4:
					stockList.stream().sorted((s1,s2) -> s2.getStockestdYear() - s1.getStockestdYear()).forEach(st -> System.out.println("Id: " + st.getId() + " stock Name:" + st.getStockName() + " stock Estd Year:"
							+ st.getStockestdYear() + " stock Sector Type:" + st.getStocksectorType()+" StockPrice :"+st.getStockPrice()) );
					System.out.println("\n");
					break;
				default:
					System.out.println("Enter Valid Choice");
					System.out.println("\n");
				}
			} while (ch != 0);

		} catch (SomeThingWentWrongException | NoRecordFoundException ex) {
			System.out.println(ex.getMessage());
		}
	}

	public static void updateStockDetails(Scanner sc) {
		// TODO Auto-generated method stub
		System.out.print("Enter id ");
		int id = sc.nextInt();
		System.out.print("Enter Stock name ");
		String stockName = sc.next();
		System.out.print("Enter establishment year");
		int stockestdYear = sc.nextInt();
		System.out.println("Enter Price of Stock");
		int stockPrice = sc.nextInt();
		System.out.print("Enter sector type (Government/private) ");
		String stocksectorType = sc.next();

		// code to create Company Entity object
		Stock stock = new Stock();
		stock.setId(id);
		stock.setStockName(stockName);
		stock.setStockestdYear(stockestdYear);
		stock.setStockPrice(stockPrice);
		stock.setStocksectorType(stocksectorType);

		stockService stockService = new stockServiceImpl();

		try {
			stockService.updateStock(stock);
			System.out.println("Stock updated successfully");
		} catch (SomeThingWentWrongException | NoRecordFoundException ex) {
			System.out.println(ex.getMessage());
		}

	}

	public static void DeleteStockById(Scanner sc) {
		// TODO Auto-generated method stub
		System.out.println("Enter Stock Id");
		int id = sc.nextInt();

		stockService stockService = new stockServiceImpl();
		try {
			stockService.DeleteStockById(id);
			System.out.println("Stock Deleted Successfully");
		} catch (SomeThingWentWrongException | NoRecordFoundException ex) {
			System.out.println(ex.getMessage());
		}

	}

	public static void viewAllCustomers(Scanner sc) {
		try {
			CustomerService customerService = new CustomerServiceImpl();
			List<Object[]> customerList = customerService.getCustomerList();
			System.out.println(
					"____________________________________________________________________________________________________");
			for (Object obj[] : customerList) {
				System.out.println("Name: " + obj[0] + " Username: " + obj[1] + " Date of Birth: " + obj[2]
						+ " User Active: " + (((Integer) obj[3]).intValue() == 0 ? "Yes" : "No"));
				System.out.println(
						"____________________________________________________________________________________________________");
			}

		} catch (SomeThingWentWrongException | NoRecordFoundException ex) {
			System.out.println(ex.getMessage());
		}

	}
}
