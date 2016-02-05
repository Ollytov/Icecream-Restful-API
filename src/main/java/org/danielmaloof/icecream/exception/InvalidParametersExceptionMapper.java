package org.danielmaloof.icecream.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.danielmaloof.icecream.model.ErrorMessage;

@Provider
public class InvalidParametersExceptionMapper implements ExceptionMapper<InvalidParametersException>{

	@Override
	public Response toResponse(InvalidParametersException ex) {
		ErrorMessage errorMessage = new ErrorMessage(ex.getMessage(), 400, "linktowebsite.com");
		return Response.status(Status.BAD_REQUEST).entity(errorMessage).build();
	}
	
}