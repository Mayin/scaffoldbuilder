import play.*;
import play.jobs.*;
import play.test.*;


import models.*;

@OnApplicationStart
public class Bootstrap extends Job {
	public void doJob() {

//		if (Structure.count() == 0) {
			Fixtures.deleteDatabase();
			Fixtures.loadModels("initial-data.yml");
//		}
	}
}


