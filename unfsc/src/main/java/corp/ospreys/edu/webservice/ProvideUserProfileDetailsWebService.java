/**
 * 
 */
package corp.ospreys.edu.webservice;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import corp.ospreys.edu.dto.ProfileDetails;
import corp.ospreys.edu.service.ProfileDetailsService;

/**
 * @author sandyturlapaty
 *
 */
@Service("provideUserProfileDetailsWebService")
@Path("/profile-details/{profile-id}")
public class ProvideUserProfileDetailsWebService {
	
	private static Logger logger= Logger.getLogger(ProvideUserProfileDetailsWebService.class);

	@Autowired
	private ProfileDetailsService profileDetailsService;
	

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response retrieveProfileDetailsById(@PathParam("profile-id") String profileId) {
		logger.info("In ProvideUserProfileDetailsWebService class : retrieveProfileDetailsById method : START");
		ProfileDetails details = profileDetailsService.retrieveProfileById(profileId);
		return Response.status(200).entity(details).build();
	}

}