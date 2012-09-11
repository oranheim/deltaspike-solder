package org.jboss.seam.rest.exceptions.integration;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.apache.deltaspike.core.api.exception.control.annotation.ExceptionHandler;
import org.apache.deltaspike.core.api.exception.control.annotation.Handles;
import org.jboss.solder.exception.control.CaughtException;
//import org.jboss.solder.exception.control.Handles;
//import org.jboss.solder.exception.control.HandlesExceptions;
import org.jboss.solder.exception.control.Precedence;
//import org.jboss.solder.exception.control.TraversalMode;
import org.jboss.seam.rest.exceptions.RestRequest;
import org.jboss.seam.rest.exceptions.RestResource;
import org.jboss.seam.rest.validation.ValidationException;
import org.jboss.seam.rest.validation.ValidationExceptionHandler;

/**
 * The default handler that obtains {@link ValidationException} from Seam Catch and converts it to an HTTP response.
 *
 * @author <a href="http://community.jboss.org/people/jharting">Jozef Hartinger</a>
 */
@ExceptionHandler
@ApplicationScoped
public class CatchValidationExceptionHandler {
    @Inject
    private ValidationExceptionHandler delegate;

    public void handleValidationException(
    		// , during = TraversalMode.DEPTH_FIRST
            @Handles(ordinal = Precedence.BUILT_IN) @RestRequest CaughtException<ValidationException> event,
            @RestResource ResponseBuilder builder) {
        delegate.handleValidationException(event.getException(), builder);
        event.handled();
    }
}
