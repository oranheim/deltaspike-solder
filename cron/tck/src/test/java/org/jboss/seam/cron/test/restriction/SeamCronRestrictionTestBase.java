/**
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
package org.jboss.seam.cron.test.restriction;

import org.jboss.seam.cron.spi.asynchronous.CronAsynchronousProvider;
import org.jboss.seam.cron.spi.queue.CronQueueProvider;
import org.jboss.seam.cron.spi.scheduling.CronSchedulingProvider;
import org.jboss.seam.cron.test.SeamCronTestBase;
import org.jboss.seam.cron.test.restriction.beans.SomeAsyncAndRestrictionMethods;
import org.jboss.shrinkwrap.api.spec.JavaArchive;

/**
 *
 * @author Dave Oxley
 */
public abstract class SeamCronRestrictionTestBase {

    public static JavaArchive createRestrictionTestArchive() {
        return SeamCronTestBase.createTestArchiveTestBeansXML()
                .addPackage(SeamCronRestrictionTestBase.class.getPackage())
                .addPackage(SomeAsyncAndRestrictionMethods.class.getPackage())
                .addPackage(CronQueueProvider.class.getPackage())
                .addPackage(CronAsynchronousProvider.class.getPackage())
                .addPackage(CronSchedulingProvider.class.getPackage());
    }
    
}
