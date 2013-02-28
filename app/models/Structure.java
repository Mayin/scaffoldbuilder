package models;

import java.util.*;
import javax.persistence.*;

import play.db.jpa.*;

@Entity
public class Structure extends Model {
	public String name;
	public int height;
	public int width;
	public int numOfHorz;
	public int numOfVert;
	public Date postedAt;

	public Structure(String name, int height, int width, Date postedAt, int numOfHorz, int numOfVert) {
		this.name = name;
		this.height = height;
		this.width = width;
		this.numOfHorz = numOfHorz;
		this.numOfVert = numOfVert;
		this.postedAt = new Date();
	}
	
	public Structure previous() {
		return Structure.find("postedAt < ? order by postedAt desc", postedAt).first();
	}
	
	public Structure next() {
		return Structure.find("postedAt > ? order by postedAt desc", postedAt).first();
	}

	public String toString() {
	    return name;
	}
	

}

