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
package org.jboss.solder.bean.generic;

import java.lang.annotation.Annotation;
import java.util.Set;

import javax.enterprise.context.spi.CreationalContext;
import javax.enterprise.inject.spi.AnnotatedField;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;

import org.apache.deltaspike.core.util.Annotateds;
import org.jboss.solder.reflection.Reflections;
//import org.jboss.solder.reflection.annotated.Annotateds;

import static org.jboss.solder.reflection.Reflections.getFieldValue;

class GenericProducerField<T, X> extends AbstractGenericProducerBean<T> {

    private final AnnotatedField<X> field;

    GenericProducerField(Bean<T> originalBean, GenericIdentifier identifier, AnnotatedField<X> field, Set<Annotation> qualifiers, Set<Annotation> declaringBeanQualifiers, Class<? extends Annotation> scopeOverride, boolean alternative, Class<?> declaringBeanClass, BeanManager beanManager) {
        super(originalBean, identifier, qualifiers, declaringBeanQualifiers, scopeOverride, Annotateds.createFieldId(field), alternative, declaringBeanClass, beanManager);
        this.field = field;
    }

    @Override
    protected T getValue(Object receiver, CreationalContext<T> creationalContext) {
        field.getJavaMember().setAccessible(true);
        return getFieldValue(field.getJavaMember(), receiver, Reflections.<T>getRawType(field.getBaseType()));
    }

    @Override
    public void destroy(T instance, CreationalContext<T> creationalContext) {
        // Generic managed beans must be dependent
        creationalContext.release();
    }

}
