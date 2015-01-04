package fr.istic.gla.client;

import com.google.gwt.core.client.GWT;
import com.google.web.bindery.autobean.shared.AutoBean;
import com.google.web.bindery.autobean.shared.AutoBeanCodex;
import com.google.web.bindery.autobean.shared.AutoBeanUtils;

import fr.istic.gla.shared.Book;
import fr.istic.gla.shared.BookItf;
import fr.istic.gla.shared.MyFactory;
import fr.istic.gla.shared.Personne;

public class PersonJsonConverter {
	private PersonJsonConverter() {
	}
	
	private static PersonJsonConverter instance = new PersonJsonConverter();
	
	/*
	  // Instantiate the factory
	  MyFactory factory = GWT
			  .create(MyFactory.class);
	  // In non-GWT code, use AutoBeanFactorySource.create(MyFactory.class);

	  /*public Personne makePerson() {
	    // Construct the AutoBean
	    AutoBean<Personne> personne = factory.person();

	    // Return the Book interface shim
	    return personne.as();
	  }

	  String serializeToJson(Personne person) {
	    // Retrieve the AutoBean controller
	    AutoBean<Personne> bean = AutoBeanUtils.getAutoBean(person);

	    return AutoBeanCodex.encode(bean).getPayload();
	  }

	  BookItf deserializeFromJson(String json) {
	    AutoBean<BookItf> bean = AutoBeanCodex.decode(factory, BookItf.class, json);
	    return bean.as();
	  }

	public static PersonJsonConverter getInstance() {
		return instance;
	}*/
}
