package org.jboss.seam.rest.exceptions.integration;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Event;
import javax.enterprise.inject.Instance;
import javax.enterprise.inject.Specializes;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.ext.ExceptionMapper;

import org.apache.deltaspike.core.api.exception.control.annotation.ExceptionHandler;
import org.apache.deltaspike.core.api.exception.control.annotation.Handles;
import org.apache.deltaspike.core.api.exception.control.event.ExceptionToCatchEvent;

import org.jboss.solder.logging.Logger;
import org.jboss.solder.exception.control.CaughtException;
import org.jboss.solder.exception.control.Precedence;
//import org.jboss.solder.exception.control.ExceptionToCatch;
//import org.jboss.solder.exception.control.Handles;
//import org.jboss.solder.exception.control.HandlesExceptions;
//import org.jboss.solder.exception.control.Precedence;
//import org.jboss.solder.exception.control.TraversalMode;
import org.jboss.seam.rest.exceptions.RestRequest;
import org.jboss.seam.rest.exceptions.RestResource;
import org.jboss.seam.rest.exceptions.SeamExceptionMapper;

/**
 * A JAX-RS ExceptionMapper implementation that maps all exceptions (i.e., Throwable) raised during a JAX-RS request to the Seam
 * Catch exception handling bus.
 * <p>
 * Exceptions are send to Seam Catch by firing an event of type {@link ExceptionToCatch} to the CDI event bus. The event payload
 * contains the exception and the qualifier &#064;RestRequest. The qualifier allows handlers that deal specifically with REST
 * requests to be selected.
 * </p>
 *
 * @author <a href="http://community.jboss.org/people/dan.j.allen">Dan Allen</a>
 * @author <a href="http://community.jboss.org/people/jharting">Jozef Hartinger</a>
 */
@ApplicationScoped
//@HandlesExceptions
@ExceptionHandler
@Specializes
public class CatchExceptionMapper extends SeamExceptionMapper implements ExceptionMapper<Throwable> {
    @Inject
    @RestResource
    private Instance<Response> response;
    @Inject
    private Event<ExceptionToCatchEvent> bridgeEvent;

    private static final Logger log = Logger.getLogger(CatchExceptionMapper.class);

    @Override
    public Response toResponse(Throwable exception) {
        ExceptionToCatchEvent payload = new ExceptionToCatchEvent(exception, RestRequest.RestRequestLiteral.INSTANCE);

        // The call returns if the exception is handled. The exception is rethrown by catch otherwise.
        bridgeEvent.fire(payload);

        return response.get();
    }

    public void handleException(
    		// , during = TraversalMode.DEPTH_FIRST
            @Handles(ordinal = Precedence.BUILT_IN) @RestRequest CaughtException<Throwable> event,
            @RestResource ResponseBuilder builder) {
        Class<? extends Throwable> exceptionType = event.getException().getClass();
        log.debugv("Handling {0}", exceptionType);

        if (getMappings().containsKey(exceptionType)) {
            produceResponse(event.getException(), builder);
            event.handled();
        } else {
            event.rethrow();
            event.unmute(); // let us handle the causing exception
        }
    }
}
