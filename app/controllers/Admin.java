package controllers;

import play.*;
import play.data.validation.Validation;
import play.mvc.*;

import java.util.*;

import models.*;

@With(Secure.class)
public class Admin extends Controller {
	
	@Before
	static void setConnectedPerson() {
		if(Security.isConnected()) {
			Person person = Person.find("byEmail", Security.connected()).first();
			renderArgs.put("person", person.firstname);
		}
	}
	 
    public static void index() {
        render();
    }

    
//	public static void index() {
//		String person = Security.connected();
//		List<Shipment> shipments = Shipment.find("person.email", person).fetch();
//		render(shipments);
//	}
//
//	public static void save(Long id) {
//		Shipment shipment;
//		if(id == null) {
//			// Create Shipment
//			Person person = Person.find("byEmail", Security.connected()).first();
//			shipment = new Shipment(person);
//		} else {
//			// Retrieve Shipments
//			shipment = Shipment.findById(id);
//			
//			// Edit
//			shipment.person = person;
//		}
//		
//		
//		// Validate
//		validation.valid(shipment);
//		if(validation.hasErrors()) {
//			render("@form", shipment);
//		}
//		
//		// Save
//		shipment.save();
//		index();
//	}
//	
//	public static void form(Long id) {
//		if(id != null) {
//			Shipment shipment = Shipment.findById(id);
//			render(shipment);
//		}
//		render();
//	}
}
