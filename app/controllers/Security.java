package controllers;

import models.*;

public class Security extends Secure.Security {

	static boolean authenticate(String email, String password) {
		return Person.connect(email, password) != null;
	}
	
	static void onDisconnected() {
	    Application.index();
	}

	static void onAuthenticated() {
	    Admin.index();
	}
	
	static boolean check(String profile) {
	    if("admin".equals(profile)) {
	        return Person.find("byEmail", connected()).<Person>first().isAdmin;
	    }
	    return false;
	}
}
