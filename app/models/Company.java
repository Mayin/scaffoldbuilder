package models;

import java.util.*;

import javax.persistence.*;

import play.db.jpa.*;
import play.data.validation.*;

@Entity
public class Company extends Model {

	@Required
	public String name;

	public String toString() {
	    return name;
	}
	
}
