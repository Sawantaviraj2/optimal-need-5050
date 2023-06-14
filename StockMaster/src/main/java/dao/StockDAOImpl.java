package dao;

import java.util.List;

import entity.Stock;
import exception.NoRecordFoundException;
import exception.SomeThingWentWrongException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.Query;
import utility.EMUtils;

public class StockDAOImpl implements StockDAO {
	@Override
	public void addStock(Stock stock) throws SomeThingWentWrongException {
		// TODO Auto-generated method stub
		EntityManager em = null;
		EntityTransaction et = null;
		try {
			em = EMUtils.getEntityManager();
			// check if company with same name exists
			Query query = em.createQuery("SELECT count(s) FROM Stock s WHERE stockName = :stockName");
			query.setParameter("stockName", stock.getStockName());
			if ((Long) query.getSingleResult() > 0) {
				// you are here means company with given name exists so throw exceptions
				throw new SomeThingWentWrongException("Stock already exists with name " + stock.getStockName());
			}

			// you are here means no company with given name
			et = em.getTransaction();
			et.begin();
			em.persist(stock);
			et.commit();
		} catch (PersistenceException ex) {
			throw new SomeThingWentWrongException("Unable to process request, try again later");
		} finally {
			em.close();
		}
	}

	@Override
	public List<Stock> getStockList() throws SomeThingWentWrongException, NoRecordFoundException {
		EntityManager em = null;
		List<Stock> stockList = null;
		try {
			em = EMUtils.getEntityManager();
			Query query = em.createQuery("FROM Stock s");
			stockList = (List<Stock>) query.getResultList();
			if (stockList.size() == 0) {
				throw new NoRecordFoundException("No Stocks Found");
			}
		} catch (IllegalArgumentException ex) {
			throw new SomeThingWentWrongException("Unable to process request, try again later");
		} finally {
			em.close();
		}
		return stockList;
	}

	@Override
	public void updateStock(Stock stock) throws SomeThingWentWrongException, NoRecordFoundException {
		// TODO Auto-generated method stub

		EntityManager em = null;
		try {
			em = EMUtils.getEntityManager();
			// check if company with company with given id exists
			Stock stockFromDB = em.find(Stock.class, stock.getId());

			if (stockFromDB == null) {
				throw new NoRecordFoundException("No Stock found with the given id " + stock.getId());
			}

			// You are here means company exists with given id
			// check if company is to be renamed
			if (!stockFromDB.getStockName().equals(stock.getStockName())) {
				// you are here means company is to be renamed, check for no existing company
				// with new name.
				// check if company with same name exists
				Query query = em.createQuery("SELECT count(s) FROM Stock s WHERE stockName = :stockName");

				query.setParameter("stockName", stock.getStockName());
				if ((Long) query.getSingleResult() > 0) {
					// you are here means company with given name exists so throw exceptions
					throw new SomeThingWentWrongException("Stock already exists with name " + stock.getStockName());
				}
			}

			// proceed for update operation

			EntityTransaction et = em.getTransaction();
			et.begin();
			stockFromDB.setStockName(stock.getStockName());
			stockFromDB.setStockestdYear(stock.getStockestdYear());
			stockFromDB.setStocksectorType(stock.getStocksectorType());
			et.commit();
		} catch (PersistenceException ex) {
			throw new SomeThingWentWrongException("Unable to process request, try again later");
		} finally {
			em.close();
		}

	}

	@Override
	public void DeleteStockById(int id) throws SomeThingWentWrongException, NoRecordFoundException {
		// TODO Auto-generated method stub
		
		EntityManager em = null;
		EntityTransaction et = null;
		try {
			em = EMUtils.getEntityManager();
			// check if company with company with given id exists
			Stock stock = em.find(Stock.class,id);
			if (stock == null) {
				throw new NoRecordFoundException("No Stock found with the given id " + id);
			}

			// You are here means company exists with given id
		
			et = em.getTransaction();
			et.begin();
			em.remove(stock);
			et.commit();
		} catch (PersistenceException ex) {
			throw new SomeThingWentWrongException("Unable to process request, try again later");
		} finally {
			em.close();
		}

		
	}

}
