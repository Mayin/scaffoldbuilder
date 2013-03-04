package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

public class Application extends Controller {

	@Before
	static void addDefaults() {
		renderArgs.put("apptitle", Play.configuration.getProperty("app.apptitle"));
		renderArgs.put("appbaseline", Play.configuration.getProperty("app.appbaseline"));
	}
	
    public static void index() {
        Structure frontStructure = 
        	Structure.find("order by postedAt desc").first();
        List<Structure> olderStructures = 
        	Structure.find("order by postedAt desc").from(1).fetch(10);
        
        render(frontStructure, olderStructures);
    }
    
//    public static void show(Long id) {
//    	Structure structure = Structure.findById(id);
//    	
//    	structure.numOfHorz = structure.width / 10;
//    	structure.numOfVert = structure.height / 10;
//    	render(structure);
//    }

}