import play.*;
import play.jobs.*;
import play.test.*;


import models.*;

@OnApplicationStart
public class Bootstrap extends Job {
	public void doJob() {
		if (Structure.count() == 0) {
<<<<<<< HEAD
=======
			
>>>>>>> 8e98bc8e8a3fa91f56fa38ee260b7f9774664d1c
			Fixtures.deleteDatabase();
			Fixtures.loadModels("initial-data.yml");
		}
	}
}


