package org.danielmaloof.icecream.database;

import java.util.HashMap;
import java.util.Map;
import org.danielmaloof.icecream.model.Profile;

public class DatabaseClass {
	/*
	 * This class is used primarily to help create a hard-coded database.
	 */
	private static Map<String, Profile> profiles = new HashMap<>();
	
	public static Map<String, Profile> getProfiles() {
		return profiles;
	}
}
