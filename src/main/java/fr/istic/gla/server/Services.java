package fr.istic.gla.server;

import java.awt.Window;
import java.sql.Date;
import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.istic.gla.shared.Book;
import fr.istic.gla.shared.BookItf;
import fr.istic.gla.shared.Personne;


@Path("/services")
public class Services implements IServices{

	EntityManager manager;

	public Services() {
		// TODO Auto-generated constructor stub
		
		manager = EntityManagerSinleton.getInstance().getManager();

		/*EntityTransaction t = manager.getTransaction();
		t.begin();

		Personne p = new Personne("toto");

		manager.persist(p);

		t.commit();*/
	}


	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public Collection<Personne> list() {
		return manager.createQuery("select e from Personne as e").getResultList();
	}

	@GET
	@Path("/Person/{name}")
	public void createPerson(@PathParam("name") String name) {
		EntityTransaction t1 = manager.getTransaction();
		t1.begin();

		Personne p = new Personne(name);

		manager.persist(p);

		t1.commit();
	}

	@DELETE
	@Path("/Person/delete/{id}")
	//@Produces({ MediaType.APPLICATION_JSON })
	public Personne deletePersonById(@PathParam("id") String id) {

		EntityTransaction t = manager.getTransaction();
		t.begin();
		Personne p = manager.find(Personne.class, Integer.parseInt(id));
		manager.remove(p);
		t.commit();
		return p;
	}

	@GET
	@Path("/Person/search/{id}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Personne findById(@PathParam("id") String arg0) {
		return manager.find(Personne.class, Integer.parseInt(arg0));
	}


}
