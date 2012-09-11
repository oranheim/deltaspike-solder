package org.jboss.seam.security.annotations.management;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Target({TYPE})
@Documented
@Retention(RUNTIME)
@Inherited
public @interface IdentityEntity {
    EntityType value();
}
