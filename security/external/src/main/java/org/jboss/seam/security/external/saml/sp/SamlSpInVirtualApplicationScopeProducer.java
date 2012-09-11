package org.jboss.seam.security.external.saml.sp;

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
public class SamlSpInVirtualApplicationScopeProducer {
    @Produces
    @VirtualApplicationScoped
    public SamlSpBean produceSp(@New SamlSpBean sp, VirtualApplication virtualApplication) {
        String hostName = virtualApplication.getHostName();
        sp.setHostName(hostName);
        sp.setEntityId("https://" + hostName);

        return sp;
    }
}
