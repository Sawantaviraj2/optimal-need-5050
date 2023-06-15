package dao;

import exception.SomeThingWentWrongException;

public interface OrderDAO {

	void purchaseStock(int stockId,String stockName) throws SomeThingWentWrongException;
}
