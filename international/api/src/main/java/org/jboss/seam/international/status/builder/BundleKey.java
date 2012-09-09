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
package org.jboss.seam.international.status.builder;

import java.io.Serializable;
import java.util.ResourceBundle;

/**
 * Represents the name/key pair for a {@link ResourceBundle} lookup.
 *
 * @author <a href="mailto:lincolnbaxter@gmail.com">Lincoln Baxter, III</a>
 */
public class BundleKey implements Serializable {
    private static final long serialVersionUID = -4817189437146173796L;

    private String bundle;
    private String key;

    public BundleKey(final String bundle, final String key) {
        super();
        this.bundle = bundle;
        this.key = key;
    }

    @Override
    public String toString() {
        return "BundleKey [bundle=" + bundle + ", key=" + key + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((bundle == null) ? 0 : bundle.hashCode());
        result = prime * result + ((key == null) ? 0 : key.hashCode());
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        BundleKey other = (BundleKey) obj;
        if (bundle == null) {
            if (other.bundle != null) {
                return false;
            }
        } else if (!bundle.equals(other.bundle)) {
            return false;
        }
        if (key == null) {
            if (other.key != null) {
                return false;
            }
        } else if (!key.equals(other.key)) {
            return false;
        }
        return true;
    }

    /*
     * Getters & Setters
     */
    public String getBundle() {
        return bundle;
    }

    public void setBundle(final String bundle) {
        this.bundle = bundle;
    }

    public String getKey() {
        return key;
    }

    public void setKey(final String key) {
        this.key = key;
    }
}
