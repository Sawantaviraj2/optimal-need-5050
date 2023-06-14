package service;

import java.util.List;

import dao.StockDAO;
import dao.StockDAOImpl;
import entity.Stock;
import exception.NoRecordFoundException;
import exception.SomeThingWentWrongException;

public class stockServiceImpl implements stockService {

	@Override
	public void addStock(Stock stock) throws SomeThingWentWrongException {
		StockDAO stockDAO = new StockDAOImpl();
		stockDAO.addStock(stock);
	}

	@Override
	public List<Stock> getStockList() throws SomeThingWentWrongException, NoRecordFoundException {
		// TODO Auto-generated method stub
		
		StockDAO stockDAO = new StockDAOImpl();
		return stockDAO.getStockList();
	}

	@Override
	public void updateStock(Stock stock) throws SomeThingWentWrongException, NoRecordFoundException {
		// TODO Auto-generated method stub
		StockDAO stockDAO = new StockDAOImpl();
		stockDAO.updateStock(stock);
		
	}

	@Override
	public void DeleteStockById(int id) throws SomeThingWentWrongException, NoRecordFoundException {
		// TODO Auto-generated method stub
		StockDAO stockDAO = new StockDAOImpl();
		stockDAO.DeleteStockById(id);
		
	}
	
	

}
