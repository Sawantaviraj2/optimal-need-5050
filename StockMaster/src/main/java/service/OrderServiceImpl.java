package service;

import dao.OrderDAO;
import dao.OrderDAOImpl;
import exception.SomeThingWentWrongException;

public class OrderServiceImpl implements OrderService {

	@Override
	public void purchaseStock(int stockId, String stockName) throws SomeThingWentWrongException {
		// TODO Auto-generated method stub

		OrderDAO orderDAO = new OrderDAOImpl();
		orderDAO.purchaseStock(stockId, stockName);

	}

}
