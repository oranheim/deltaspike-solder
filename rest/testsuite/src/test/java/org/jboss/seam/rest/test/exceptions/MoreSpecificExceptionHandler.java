package org.jboss.seam.rest.test.exceptions;

import javax.ws.rs.core.Response.ResponseBuilder;

import org.apache.deltaspike.core.api.exception.control.annotation.ExceptionHandler;
import org.apache.deltaspike.core.api.exception.control.annotation.Handles;
import org.jboss.solder.exception.control.CaughtException;
//import org.jboss.solder.exception.control.Handles;
//import org.jboss.solder.exception.control.HandlesExceptions;
import org.jboss.seam.rest.exceptions.RestRequest;
import org.jboss.seam.rest.exceptions.RestResource;

@ExceptionHandler
public class MoreSpecificExceptionHandler {
    public void handleInstantiationException(
            @Handles(ordinal = 0) @RestRequest CaughtException<InstantiationException> event,
            @RestResource ResponseBuilder builder) {
        builder.status(415);
        event.handled();
    }
}
