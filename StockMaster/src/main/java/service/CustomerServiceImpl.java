package service;

import java.util.List;

import dao.CustomerDAO;
import dao.CustomerDAOImpl;
import exception.NoRecordFoundException;
import exception.SomeThingWentWrongException;

public class CustomerServiceImpl implements CustomerService {

	@Override
	public List<Object[]> getCustomerList() throws SomeThingWentWrongException, NoRecordFoundException {
		//Create an object of CustomerDAO
		CustomerDAO customerDAO = new CustomerDAOImpl();
		return customerDAO.getCustomerList();
	}

}
