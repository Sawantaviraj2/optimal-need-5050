package service;

import java.util.List;

import dao.CustomerDAO;
import dao.CustomerDAOImpl;
import entity.Customer;
import exception.NoRecordFoundException;
import exception.SomeThingWentWrongException;

public class CustomerServiceImpl implements CustomerService {

	@Override
	public List<Object[]> getCustomerList() throws SomeThingWentWrongException, NoRecordFoundException {
		//Create an object of CustomerDAO
		CustomerDAO customerDAO = new CustomerDAOImpl();
		return customerDAO.getCustomerList();
	}

	@Override
	public void login(String username, String password) throws SomeThingWentWrongException, NoRecordFoundException {
		// TODO Auto-generated method stub
		CustomerDAO customerDAO = new CustomerDAOImpl();
		customerDAO.login(username, password);		
	}

	@Override
	public void ViewPurchasedStocks() throws SomeThingWentWrongException, NoRecordFoundException {
		// TODO Auto-generated method stub
		CustomerDAO customerDAO = new CustomerDAOImpl();
		customerDAO.ViewPurchasedStocks();		
	}

	@Override
	public void SellStock(int id, String stockName) throws SomeThingWentWrongException, NoRecordFoundException {
		// TODO Auto-generated method stub
		CustomerDAO customerDAO = new CustomerDAOImpl();
		customerDAO.SellStock( id,  stockName);	
	}

	@Override
	public void changePassword(String oldPassword, String newPassword) throws SomeThingWentWrongException {
		// TODO Auto-generated method stub
		CustomerDAO customerDAO = new CustomerDAOImpl();
		customerDAO.changePassword( oldPassword,  newPassword);
		
	}

	@Override
	public void deleteAccount() throws SomeThingWentWrongException {
		CustomerDAO customerDAO = new CustomerDAOImpl();
		customerDAO.deleteAccount();
		
	}

	@Override
	public void addCustomer(Customer customer) throws SomeThingWentWrongException {
		// TODO Auto-generated method stub
		CustomerDAO customerDAO = new CustomerDAOImpl();
		customerDAO.addCustomer(customer);
		
	}

}
