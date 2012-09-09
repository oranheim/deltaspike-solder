/*
 * JBoss, Home of Professional Open Source
 * Copyright 2010, Red Hat Middleware LLC, and individual contributors
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
package org.jboss.solder.servlet.event;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.inject.Qualifier;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletRequestEvent;

import org.jboss.solder.core.Requires;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Qualifies observer method parameters to select events that fire when HTTP artifacts are being initialized.
 * <p/>
 * The event parameter can be a {@link ServletContextEvent} or a {@link ServletRequestEvent}.
 *
 * @author Nicklas Karlsson
 */
@Requires("javax.servlet.ServletContextEvent")
@Qualifier
@Target({FIELD, PARAMETER})
@Retention(RUNTIME)
@Documented
public @interface Initialized {
}
