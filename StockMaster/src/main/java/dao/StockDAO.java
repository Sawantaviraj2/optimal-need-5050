package dao;

import java.util.List;

import entity.Stock;
import exception.NoRecordFoundException;
import exception.SomeThingWentWrongException;

public interface StockDAO {

	void addStock(Stock stock) throws SomeThingWentWrongException;
	public List<Stock> getStockList() throws SomeThingWentWrongException, NoRecordFoundException;
	public void updateStock(Stock stock) throws SomeThingWentWrongException, NoRecordFoundException;
	void DeleteStockById(int id) throws SomeThingWentWrongException, NoRecordFoundException;
}
