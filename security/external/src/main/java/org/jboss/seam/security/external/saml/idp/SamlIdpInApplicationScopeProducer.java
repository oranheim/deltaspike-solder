package org.jboss.seam.security.external.saml.idp;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.New;
import javax.enterprise.inject.Produces;

import org.apache.deltaspike.core.api.exclude.annotation.Exclude;
//import org.jboss.solder.core.Veto;

/**
 * @author Marcel Kolsteren
 */
@Exclude
public class SamlIdpInApplicationScopeProducer {
    @Produces
    @ApplicationScoped
    public SamlIdpBean produce(@New SamlIdpBean idp) {
        return idp;
    }
}
