package fr.istic.gla.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.ValueBoxBase.TextAlignment;

import fr.istic.gla.shared.BookItf;
import fr.istic.gla.shared.Personne;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class glagerseygwt implements EntryPoint {

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {

		System.err.println("entree ici");


		// Create a label
		final Label label = new Label("Display a person with id");
		RootPanel.get().add(label);


		// Create a text
		final TextBox area = new TextBox();
		area.setValue("2");
		RootPanel.get().add(area);

		// Create a button
		com.google.gwt.user.client.ui.Button b = new Button();
		b.setText("test call json restful service");

		RootPanel.get().add(b);

		b.addClickHandler(new ClickHandler() {

			public void onClick(ClickEvent event) {
				RequestBuilder rb = new RequestBuilder(RequestBuilder.GET, GWT
						.getHostPageBaseURL() + "rest/books/search/" + area.getText());
				rb.setCallback(new RequestCallback() {

					public void onError(Request request, Throwable exception) {
						Window.alert(exception.getMessage());
					}

					public void onResponseReceived(Request request,
							Response response) {
						if (200 == response.getStatusCode()) {
							BookItf b = BookJsonConverter.getInstance()
									.deserializeFromJson(response.getText());
							Window.alert("get the book from :" + b.getAuthor()
									+ " isbn : " + b.getIsbn().toString());

						}
					}
				});
				try {
					rb.send();
				} catch (RequestException e) {
					e.printStackTrace();
				}

			}
		});

		//Create a button

		com.google.gwt.user.client.ui.Button display = new Button();
		display.setText("Display");

		RootPanel.get().add(display);

		display.addClickHandler(new ClickHandler() {

			public void onClick(ClickEvent event) {
				RequestBuilder rb = new RequestBuilder(RequestBuilder
						.GET, GWT
						.getHostPageBaseURL() 
						+ "rest/services/Person/search/" 
						+ area.getText());
				rb.setCallback(new RequestCallback() {

					public void onError(Request request, Throwable exception) {
						Window.alert(exception.getMessage());
					}

					public void onResponseReceived(Request request,
							Response response) {
						if (200 == response.getStatusCode()) {

							/*Personne p = (Personne) PersonJsonConverter.getInstance()
											.deserializeFromJson(response.getText());

									Window.alert("get the person from: "
											+ p.name
											+ " id: "+ p.getId());*/
						}
					}
				});
				try {
					rb.send();
				} catch (RequestException e) {
					e.printStackTrace();
				}

			}
		});

	}
}
