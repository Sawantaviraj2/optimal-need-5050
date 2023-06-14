package dao;

import java.util.List;

import exception.NoRecordFoundException;
import exception.SomeThingWentWrongException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.Query;
import utility.EMUtils;

public class CustomerDAOImpl implements CustomerDAO {

	@Override
	public List<Object[]> getCustomerList() throws SomeThingWentWrongException, NoRecordFoundException {
		EntityManager em = null;
		List<Object[]> customerList = null;
		try {
			em = EMUtils.getEntityManager();
			Query query = em.createQuery("SELECT c.name, c.username, c.dateOfBirth, c.isDeleted FROM Customer c");
			customerList = query.getResultList();
			if (customerList.size() == 0) {
				throw new NoRecordFoundException("No Customer Found");
			}
		} catch (PersistenceException ex) {
			throw new SomeThingWentWrongException("Unable to process request, try again later");
		} finally {
			em.close();
		}
		return customerList;
	}

}
