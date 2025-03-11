package modelo.dao;

import jakarta.persistence.*;

public class ConnectionFactory {
	private static final EntityManagerFactory fabrica =
		Persistence.createEntityManagerFactory("ProjetoJAXRS");
	
	public static EntityManager getEntityManager() {
		return fabrica.createEntityManager();
	}
}
