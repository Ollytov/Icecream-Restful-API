package org.danielmaloof.icecream.resources;

import java.net.URI;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import org.danielmaloof.icecream.model.Profile;
import org.danielmaloof.icecream.service.ProfileService;

@Path("/profiles")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProfileResource {

	private ProfileService profileService = new ProfileService();
	
	
	/*
	 *  GET Request
	 *  Returns All Profiles stores inside of the Database
	 *  @QueryParam allows queries to be passed into the URI.
	 *  If QueryParam exists, will instead return a list of Profiles that have 
	 *  their favorite IceCream equal to that of the query.
	 */
	@GET
	public List<Profile> getProfiles(@QueryParam("icecream") String icecream) {
		if (icecream != null) {
			return profileService.getAllProfilesWithIcecream(icecream);
		}
		return profileService.getAllProfiles();
	}
	
	
	/*
	 *  GET Request with Additional Path Parameter
	 *  Retrieves Profile from Database with specified Profile Name
	 *  @PathParam stores the parameter placed in URI into String profileName.
	 *  Returns Response Status Code '200 OK' if Successful
	 */
	@GET 
	@Path("/{profileName}")
	public Response getProfile(@PathParam("profileName") String profileName) {
		Profile foundProfile = profileService.getProfile(profileName);
		return Response.ok(foundProfile).build();
	}
	
	
	/*
	 *  POST Request
	 *  Adds a New Profile to the Database. 
	 *  @Context UriInfo is used to get the API URI for the newly created Profile .
	 *  The API URI will automatically be included in the Response Header.
	 *  Returns the newly created Profile, and the Response Status Code '201 Created'
	 */
	@POST
	public Response addProfile(Profile profile, @Context UriInfo uriInfo) {
		Profile newProfile = profileService.addProfile(profile);
		String profileName = String.valueOf(newProfile.getProfileName());
		URI uri = uriInfo.getAbsolutePathBuilder().path(profileName).build();
		return Response.created(uri).entity(newProfile).build();
	}
	
	
	/*
	 * PUT Request
	 * Updates the Profile that is passed into its Path. If no such profile exists
	 * with the name, it will create a new profile. (If you want to create a new profile,
	 * use the POST method above)
	 * Returns the newly updated profile, and the Response status code '200 OK' if successful.
	 */
	@PUT
	@Path("/{profileName}")
	public Response updateProfile(@PathParam("profileName") String profileName, Profile profile) {
		profile.setProfileName(profileName);
		Profile updatedProfile = profileService.updateProfile(profile);
		return Response.ok(updatedProfile).build();
	}
	
	
	/*
	 * DELETE Request
	 * Deletes the Profile with the profile name listed in the path.
	 * Returns Response status code '204 No Content' if successful.
	 */
	@DELETE
	@Path("/{profileName}")
	public Response deleteProfile(@PathParam("profileName") String profileName) {
		profileService.removeProfile(profileName);
		return Response.status(Status.NO_CONTENT).build();
	}
}
