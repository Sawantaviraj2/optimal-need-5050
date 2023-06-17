package service;

import java.util.List;

import entity.Stock;
import exception.NoRecordFoundException;
import exception.SomeThingWentWrongException;

public interface stockService {

	void addStock(Stock stock) throws SomeThingWentWrongException;
	List<Stock> getStockList() throws SomeThingWentWrongException, NoRecordFoundException;
	void updateStock(Stock stock) throws SomeThingWentWrongException, NoRecordFoundException;
	void DeleteStockById(int id)throws SomeThingWentWrongException, NoRecordFoundException;
}
