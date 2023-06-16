package dao;

import java.util.Set;

import entity.Customer;
import entity.LoggedInUserId;
import entity.Stock;
import exception.SomeThingWentWrongException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.Query;
import utility.EMUtils;

public class OrderDAOImpl implements OrderDAO {
//	static EntityManagerFactory emf;
//
//	static {
//		emf = Persistence.createEntityManagerFactory("Stock_Master");
//	}

	@Override
	public void purchaseStock(int stockId, String stockName) throws SomeThingWentWrongException {
		// TODO Auto-generated method stub

		EntityManager em = null;
		try {
			em = EMUtils.getEntityManager();
			Query query = em.createQuery("FROM Stock s WHERE stockName = :stockName");
			query.setParameter("stockName", stockName);
			// Here we can use getSingleResult because we are sure that plan exists with
			// given name
			Stock stock = (Stock) query.getSingleResult();
			// get the entity of Customer
			Customer customer = em.find(Customer.class, LoggedInUserId.loggedInUserId);

			Set<Stock> stockSet = customer.getOrderStockSet();
			stockSet.add(stock);
			customer.setOrderStockSet(stockSet);

			Set<Customer> cusSet = stock.getCustomer();
			cusSet.add(customer);
			stock.setCustomer(cusSet);

			EntityTransaction et = em.getTransaction();
			et.begin();
			em.persist(customer);
			et.commit();
		} catch (PersistenceException | IllegalArgumentException ex) {
			ex.printStackTrace();
			throw new SomeThingWentWrongException("Unable to process request, try again later");
		} finally {
			em.close();
		}
	}

}
