/*
 * JBoss, Home of Professional Open Source
 * Copyright 2011, Red Hat, Inc., and individual contributors
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jboss.seam.faces.environment;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Typed;
import javax.faces.context.ExternalContext;
import javax.faces.context.ExternalContextWrapper;
import javax.inject.Inject;

import org.jboss.seam.faces.context.RenderContext;
import org.jboss.seam.faces.context.RenderScopedContext;

@Typed(SeamExternalContext.class)
@RequestScoped
public class SeamExternalContext extends ExternalContextWrapper {
    private ExternalContext wrapped;

    @Inject
    RenderContext flash;

    @Inject
    RenderScopedContext context;

    public void setWrapped(final ExternalContext wrapped) {
        this.wrapped = wrapped;
    }

    @Override
    public ExternalContext getWrapped() {
        return wrapped;
    }

    @Override
    public String encodeRedirectURL(final String baseUrl, Map<String, List<String>> parameters) {
        String redirectURL = "";
        if ((flash.getId() != null) && (context.countRenderContexts() > 1)) {
            if (parameters == null) {
                parameters = new HashMap<String, List<String>>();
            }
            String id = String.valueOf(flash.getId());
            parameters.put(context.getRequestParameterName(), Arrays.asList(id));
        }

        redirectURL = super.encodeRedirectURL(baseUrl, parameters);
        return redirectURL;
    }

    @Override
    public void redirect(final String url) throws IOException {
        super.redirect(url);
    }
}
