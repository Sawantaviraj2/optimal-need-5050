package dao;

import java.util.List;

import entity.Customer;
import exception.NoRecordFoundException;
import exception.SomeThingWentWrongException;

public interface CustomerDAO {

	void addCustomer(Customer customer) throws SomeThingWentWrongException;

	List<Object[]> getCustomerList() throws SomeThingWentWrongException, NoRecordFoundException;

	void login(String username, String password) throws SomeThingWentWrongException;

	void ViewPurchasedStocks() throws SomeThingWentWrongException, NoRecordFoundException;

	void SellStock(int id, String stockName) throws SomeThingWentWrongException, NoRecordFoundException;

	void changePassword(String oldPassword, String newPassword) throws SomeThingWentWrongException;

	void deleteAccount() throws SomeThingWentWrongException;

}
