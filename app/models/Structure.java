package models;

import java.util.*;
import javax.persistence.*;

import play.db.jpa.*;

@Entity
public class Structure extends Model {
	public String name;
	public int height;
	public int width;
	public Date postedAt;

	public Structure(String name, int height, int width, Date postedAt) {
		this.name = name;
		this.height = height;
		this.width = width;
		this.postedAt = new Date();
	}
}

