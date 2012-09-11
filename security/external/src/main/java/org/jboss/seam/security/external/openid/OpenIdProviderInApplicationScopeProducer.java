package org.jboss.seam.security.external.openid;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.New;
import javax.enterprise.inject.Produces;

import org.apache.deltaspike.core.api.exclude.annotation.Exclude;
//import org.jboss.solder.core.Veto;

/**
 * @author Marcel Kolsteren
 */
@Exclude
public class OpenIdProviderInApplicationScopeProducer {
    @Produces
    @ApplicationScoped
    public OpenIdProviderBean produce(@New OpenIdProviderBean op) {
        return op;
    }
}
