package dao;

import java.util.List;

import exception.NoRecordFoundException;
import exception.SomeThingWentWrongException;

public interface CustomerDAO {

	List<Object[]> getCustomerList() throws SomeThingWentWrongException, NoRecordFoundException;

}
