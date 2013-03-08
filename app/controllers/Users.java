package controllers;

import java.util.List;

//import models.Shipment;
import models.Person;
import controllers.CRUD.ObjectType;
import play.*;
import play.mvc.*;

// @With(Secure.class)
public class Persons extends CRUD {

    public static void list(int page, String search, String searchFields, String orderBy, String order) {
        ObjectType type = ObjectType.get(getControllerClass());
        notFoundIfNull(type);
        if (page < 1) {
            page = 1;
        }

        Person person = Person.find("byEmail", Security.connected()).first();
        Long count = Person.count("byCompany", person.company);
        		
        List<Person> objects = Person.find("byCompany", person.company).fetch();
        if (person.isAdmin) {
            objects = Person.findAll();
            count = type.count(search, searchFields, (String) request.args.get("where"));
        }

        Long totalCount = type.count(null, null, (String) request.args.get("where"));
        
        render(type, objects, count, totalCount, page, orderBy, order, person);
    }
    
	public static void blank() {
        Person connectedPerson = Person.find("byEmail", Security.connected()).first();
        render(connectedPerson);
    }

}