package org.danielmaloof.icecream.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.danielmaloof.icecream.database.DatabaseClass;
import org.danielmaloof.icecream.exception.DataNotFoundException;
import org.danielmaloof.icecream.exception.InvalidParametersException;
import org.danielmaloof.icecream.model.Profile;

public class ProfileService {

	private Map<String, Profile> profiles = DatabaseClass.getProfiles();
	
	
	/*
	 *  Populates the 'database' with user profiles.
	 *  As of now, the database is just hard-coded into the program.
	 */
	public ProfileService() {
		profiles.put("danielmaloof", new Profile(1L, "danielmaloof", "Daniel", "Maloof", "Vanilla"));
		profiles.put("johndoe", new Profile(2L, "johndoe", "John", "Doe", "Chocolate"));
		profiles.put("janedoe", new Profile(3L, "janedoe", "Jane", "Doe", "Strawberry"));
		profiles.put("stevenow", new Profile(4L, "stevenow", "Steve", "Now", "Strawberry"));
		profiles.put("bob", new Profile(5L, "bob", "Bob", "", "Chocolate"));
		profiles.put("chadsmith", new Profile(6L, "chadsmith", "Chad", "Smith", "Vanilla"));
		profiles.put("bradsmith", new Profile(7L, "bradsmith", "Brad", "Smith", "Chocolate"));
		profiles.put("joel", new Profile(8L, "joel", "Joel", "", "Chocolate"));
		profiles.put("angela", new Profile(9L, "angela", "Angela", "Smith", "Vanilla"));
	}
	
	
	/*
	 *  This Service returns an ArrayList of all of the profiles listed inside of the database.
	 *  Returns ArrayList<Profile>
	 */
	public List<Profile> getAllProfiles() {
		return new ArrayList<Profile>(profiles.values());
	}
	
	
	/*
	 * This Service is used with the Query Parameter that looks for profiles with users that have
	 * listed their favorite IceCream equal to that of the query passed.
	 * It will return a list of all profiles with a specific IceCream listed as their favorite.
	 * Returns ArrayList<Profile>
	 */
	public List<Profile> getAllProfilesWithIcecream(String icecream) {
		List<Profile> profilesWithIcecream = new ArrayList<>();
		for (Profile profile : profiles.values()) {
			if (profile.getFavoriteIceCream().toLowerCase().equals(icecream.toLowerCase())) {
				profilesWithIcecream.add(profile);
			}
		}
		return profilesWithIcecream;
	}
	
	
	/*
	 *  This Service is used with the GET Requests that target a specific Profile Name.
	 *  Will Return the specified profile if it exists. If it does not exist, will throw a 
	 *  DataNotFoundException.
	 */
	public Profile getProfile(String profileName) {
		Profile profile = profiles.get(profileName);
		if (profile == null) {
			throw new DataNotFoundException("Profile with profileName: " + profileName + " was not found.");
		}
		return profile;
	}
	
	
	/*  This Service is used with the POST Request, and will add a new profile to the database.
	 *  If the ProfileName is not defined, or If the Profile Name already exists, will throw 
	 *  InvalidParametersException.
	 *  If the favorite IceCream is not defined, will also throw an InvalidParametersException.
	 */
	public Profile addProfile(Profile profile) {
		String profileName = profile.getProfileName();
		String favoriteIceCream = profile.getFavoriteIceCream();
		if (profileName == null) {
			throw new InvalidParametersException("Post request must have a valid profilename.");
		} else if (profiles.get(profileName) != null) {
			throw new InvalidParametersException("That profilename already exists!");
		} else if (favoriteIceCream == null) {
			throw new InvalidParametersException("Post request must have a valid favorite icecream name.");
		}
		profile.setId(profiles.size() + 1);
		profiles.put(profileName, profile);
		return profile;
	}
	
	
	/*
	 *  This Service is used with the PUT Request. It will update a specific profile based on what
	 *  profile name is passed to it. If the profile name is empty, then it will return null.
	 */
	public Profile updateProfile(Profile profile) {
		if (profile.getProfileName().isEmpty()) {
			return null;
		}
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	
	/*
	 *  This Service is used with the DELETE Request. It will delete the specified profile based on
	 *  the profile name that is passed to it.
	 */
	public Profile removeProfile(String profileName) {
		return profiles.remove(profileName);
	}
}
