package ui;

import java.util.List;
import java.util.Scanner;

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

		// code to create Company Entity object
		Stock stock = new Stock();
		stock.setStockName(stockName);
		stock.setStockestdYear(stockestdYear);
		stock.setStocksectorType(stocksectorType);
		stock.setStockPrice(stockPrice);

//		 Create an object of Service Layer here	
		stockService stockService = new stockServiceImpl();
		try {
			stockService.addStock(stock);
			System.out.println("Stock added successfully");
		} catch (SomeThingWentWrongException ex) {
			System.out.println(ex.getMessage());
		}
	}

	public static void viewStocks() {
		// TODO Auto-generated method stub

		stockService stockService = new stockServiceImpl();
		try {
			List<Stock> stockList = stockService.getStockList();
			stockList.forEach(stock -> System.out
					.println("Id: " + stock.getId() + " stock Name:" + stock.getStockName() + " stock Estd Year:"
							+ stock.getStockestdYear() + " stock Sector Type:" + stock.getStocksectorType()));
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
		System.out.print("Enter sector type (Government/private) ");
		String stocksectorType = sc.next();

		// code to create Company Entity object
		Stock stock = new Stock();
		stock.setId(id);
		stock.setStockName(stockName);
		stock.setStockestdYear(stockestdYear);
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
			for (Object obj[] : customerList) {
				System.out.println("Name: " + obj[0] + " Username: " + obj[1] + " Date of Birth: " + obj[2]
						+ " User Active: " + (((Integer) obj[3]).intValue() == 0 ? "Yes" : "No"));
			}
		} catch (SomeThingWentWrongException | NoRecordFoundException ex) {
			System.out.println(ex.getMessage());
		}

	}
}
