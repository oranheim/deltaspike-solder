package org.jboss.seam.security.external.saml.idp;

import javax.enterprise.inject.New;
import javax.enterprise.inject.Produces;

import org.apache.deltaspike.core.api.exclude.annotation.Exclude;
import org.jboss.seam.security.external.virtualapplications.api.VirtualApplication;
import org.jboss.seam.security.external.virtualapplications.api.VirtualApplicationScoped;
//import org.jboss.solder.core.Veto;

/**
 * @author Marcel Kolsteren
 */
@Exclude
public class SamlIdpInVirtualApplicationScopeProducer {
    @Produces
    @VirtualApplicationScoped
    public SamlIdpBean produce(@New SamlIdpBean idp, VirtualApplication virtualApplication) {
        String hostName = virtualApplication.getHostName();
        idp.setHostName(hostName);
        idp.setEntityId("https://" + hostName);

        return idp;
    }
}
