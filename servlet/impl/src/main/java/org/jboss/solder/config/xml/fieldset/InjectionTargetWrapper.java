/*
 * JBoss, Home of Professional Open Source
 * Copyright 2011, Red Hat, Inc. and/or its affiliates, and individual
 * contributors by the @authors tag. See the copyright.txt in the
 * distribution for a full listing of individual contributors.
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
package org.jboss.solder.config.xml.fieldset;

import java.util.List;
import java.util.Set;

import javax.enterprise.context.spi.CreationalContext;
import javax.enterprise.inject.spi.BeanManager;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.enterprise.inject.spi.InjectionTarget;

public class InjectionTargetWrapper<T> implements InjectionTarget<T> {
    private final InjectionTarget<T> target;
    private final List<FieldValueObject> fieldValues;
    private final BeanManager manager;

    public InjectionTargetWrapper(InjectionTarget<T> target, List<FieldValueObject> fieldValues, BeanManager manager) {
        this.fieldValues = fieldValues;
        this.target = target;
        this.manager = manager;
    }

    public void inject(T instance, CreationalContext<T> ctx) {
        for (FieldValueObject f : fieldValues) {
            f.setValue(instance, ctx, manager);
        }
        target.inject(instance, ctx);
    }

    public void postConstruct(T instance) {
        target.postConstruct(instance);
    }

    public void preDestroy(T instance) {
        target.preDestroy(instance);
    }

    public void dispose(T instance) {
        target.dispose(instance);
    }

    public Set<InjectionPoint> getInjectionPoints() {
        return target.getInjectionPoints();
    }

    public T produce(CreationalContext<T> ctx) {
        return target.produce(ctx);
    }

}
