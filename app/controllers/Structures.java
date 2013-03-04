package controllers;

import models.Structure;
import play.*;
import play.mvc.*;

public class Structures extends CRUD {
	
    public static void draw(Long id) {
    	Structure structure = Structure.findById(id);
    	
    	structure.numOfHorz = structure.width / 10;
    	structure.numOfVert = structure.height / 10;
    	render(structure);
    }
	
}
