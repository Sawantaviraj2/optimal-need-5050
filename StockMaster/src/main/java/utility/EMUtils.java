package utility;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EMUtils {

	static EntityManagerFactory emf;
	static {
		emf = Persistence.createEntityManagerFactory("Stock_Master");
	}

	static public EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
}
