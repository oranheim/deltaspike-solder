package org.apache.deltaspike.core.util.metadata.builder;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.enterprise.inject.spi.Annotated;
import javax.enterprise.inject.spi.AnnotatedConstructor;
import javax.enterprise.inject.spi.AnnotatedField;
import javax.enterprise.inject.spi.AnnotatedMethod;
import javax.enterprise.inject.spi.AnnotatedParameter;
import javax.enterprise.inject.spi.AnnotatedType;

import org.jboss.solder.messages.Messages;
import org.jboss.solder.reflection.Reflections;
import org.jboss.solder.reflection.annotated.AnnotationRedefiner;
import org.jboss.solder.reflection.annotated.RedefinitionContext;
import org.jboss.solder.support.SolderMessages;

import org.apache.deltaspike.core.api.exclude.annotation.Exclude;
import org.apache.deltaspike.core.util.metadata.builder.AnnotatedTypeBuilder;

@Exclude
public class SolderAnnotatedTypeBuilder<X> extends AnnotatedTypeBuilder<X> {

    public SolderAnnotatedTypeBuilder() {
		super();
	}

	/**
     * Redefine any annotations of the specified type. The redefinition callback
     * will be invoked for any annotation on the type definition or any of it's
     * members.
     *
     * @param annotationType the type of the annotation for which to call the
     *                       redefinition
     * @param redefinition   the redefiniton callback
     * @throws IllegalArgumentException if the annotationType or redefinition is
     *                                  null
     */
    public <A extends Annotation> AnnotatedTypeBuilder<X> redefine(Class<A> annotationType, AnnotationRedefiner<A> redefinition) {
    	/*
        if (annotationType == null) {
            throw new IllegalArgumentException(messages.parameterMustNotBeNull("annotationType"));
        }
        if (redefinition == null) {
            throw new IllegalArgumentException(messages.parameterMustNotBeNull("redefinition"));
        }
        redefineAnnotationBuilder(annotationType, redefinition, javaClass, javaClass, typeAnnotations, null);
        for (Entry<Field, AnnotationBuilder> field : fields.entrySet()) {
            redefineAnnotationBuilder(annotationType, redefinition, field.getKey(), field.getKey().getGenericType(), field.getValue(), field.getKey().getName());
        }
        for (Entry<Method, AnnotationBuilder> method : methods.entrySet()) {
            redefineAnnotationBuilder(annotationType, redefinition, method.getKey(), method.getKey().getGenericReturnType(), method.getValue(), method.getKey().getName());
        }
        for (Entry<Constructor<?>, AnnotationBuilder> constructor : constructors.entrySet()) {
            redefineAnnotationBuilder(annotationType, redefinition, constructor.getKey(), constructor.getKey().getDeclaringClass(), constructor.getValue(), null);
        }
        for (Entry<Method, AnnotationBuilder> method : methods.entrySet()) {
            if (methodParameters.get(method.getKey()) != null) {
                for (Entry<Integer, AnnotationBuilder> parameter : methodParameters.get(method.getKey()).entrySet()) {
                    Parameter<?> p = Parameter.create(method.getKey(), parameter.getKey());
                    redefineAnnotationBuilder(annotationType, redefinition, p, p.getBaseType(), parameter.getValue(), null);
                }
            }
        }
        for (Entry<Constructor<?>, AnnotationBuilder> constructor : constructors.entrySet()) {
            if (constructorParameters.get(constructor.getKey()) != null) {
                for (Entry<Integer, AnnotationBuilder> parameter : constructorParameters.get(constructor.getKey()).entrySet()) {
                    Parameter<?> p = Parameter.create(constructor.getKey(), parameter.getKey());
                    redefineAnnotationBuilder(annotationType, redefinition, p, p.getBaseType(), parameter.getValue(), null);
                }
            }
        }
        */
        return this;
    }

    protected <A extends Annotation> void redefineAnnotationBuilder(Class<A> annotationType, AnnotationRedefiner<A> redefinition, AnnotatedElement annotated, Type baseType, AnnotationBuilder builder, String elementName) {
    	/*
        if (builder.isAnnotationPresent(annotationType)) {
            redefinition.redefine(new RedefinitionContext<A>(annotated, baseType, builder, elementName));
        }
        */
    }
	
}
