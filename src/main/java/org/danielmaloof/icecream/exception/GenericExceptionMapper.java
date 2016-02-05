package org.danielmaloof.icecream.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import org.danielmaloof.icecream.model.ErrorMessage;

@Provider
public class GenericExceptionMapper implements ExceptionMapper<Throwable>{
	/*
	 * This is a generic catch all, so that any errors not caught will return a JSON object rather than
	 * an HTML document. This isn't really the best practice, but I wanted to get it down here while I 
	 * was looking for the best exceptions to catch.
	 */
	@Override
	public Response toResponse(Throwable ex) {
		ErrorMessage errorMessage = new ErrorMessage(ex.getMessage(), 500, "linktowebsite.com");
		return Response.status(Status.INTERNAL_SERVER_ERROR).entity(errorMessage).build();
	}
	
}
