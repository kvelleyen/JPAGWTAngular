package fr.istic.gla.server;


import javax.ws.rs.PathParam;

import fr.istic.gla.shared.Personne;


public interface IServices {
	
	public void createPerson (String name);
	
	public Personne deletePersonById(String id);
	
	public Personne findById(@PathParam("id") String arg0);
	
}
