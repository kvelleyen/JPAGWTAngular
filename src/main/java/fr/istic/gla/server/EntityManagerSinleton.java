package fr.istic.gla.server;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerSinleton {

	static EntityManagerSinleton instance = new EntityManagerSinleton();
	
	public static EntityManagerSinleton getInstance() {
		return instance;
	}

	EntityManager manager;
	
	public EntityManager getManager() {
		return manager;
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	private EntityManagerSinleton() {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("dev");
		manager = factory.createEntityManager();}
}
