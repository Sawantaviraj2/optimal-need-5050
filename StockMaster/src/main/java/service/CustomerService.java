package service;

import java.util.List;

import exception.NoRecordFoundException;
import exception.SomeThingWentWrongException;

public interface CustomerService {
	List<Object[]> getCustomerList() throws SomeThingWentWrongException, NoRecordFoundException;

}
