package org.danielmaloof.icecream.model;

import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Profile {
	
	/*
	 *  The Main Profile Model for the Program.
	 *  Contains all of the variables for the class, as well as all of the
	 *  getters/setters and the class constructor.
	 */
	
	private long id;
	private String profileName;
	private String firstName;
	private String lastName;
	private String favoriteIceCream;
	private Date created;
	
	public Profile() {}

	public Profile(long id, String profileName, String firstName, String lastName, String favoriteIceCream) {
		this.id = id;
		this.profileName = profileName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.favoriteIceCream = favoriteIceCream;
		this.created = new Date();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getProfileName() {
		return profileName;
	}

	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFavoriteIceCream() {
		return favoriteIceCream;
	}

	public void setFavoriteIceCream(String favoriteIceCream) {
		this.favoriteIceCream = favoriteIceCream;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}
	
}
