package service;

import exception.SomeThingWentWrongException;

public interface OrderService {

	public void purchaseStock(int stockId,String stockName)throws SomeThingWentWrongException;
}
