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
package org.jboss.seam.faces.event;

import java.lang.annotation.Annotation;

import javax.enterprise.event.Observes;
import javax.enterprise.inject.spi.BeanManager;
import javax.enterprise.util.AnnotationLiteral;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.inject.Inject;

import org.jboss.seam.faces.event.qualifier.After;
import org.jboss.seam.faces.event.qualifier.ApplyRequestValues;
import org.jboss.seam.faces.event.qualifier.Before;
import org.jboss.seam.faces.event.qualifier.InvokeApplication;
import org.jboss.seam.faces.event.qualifier.ProcessValidations;
import org.jboss.seam.faces.event.qualifier.RenderResponse;
import org.jboss.seam.faces.event.qualifier.RestoreView;
import org.jboss.seam.faces.event.qualifier.UpdateModelValues;
import org.jboss.solder.logging.Logger;

/**
 * A PhaseListener used to bridge JSF phase events to the CDI event model.
 * <p/>
 * <p/>
 * For each JSF {@link PhaseEvent}, a corresponding Seam CDI event will be fired. Event listeners can be registered by observing
 * the appropriate Seam CDI event (see @{@link Observes}):
 * <p/>
 * <b>For example:</b>
 * <p/>
 * <code>
 * public void listener(@Observes @Before @RenderResponse PhaseEvent event)
 * {
 * //do something
 * }
 * </code>
 *
 * @author Nicklas Karlsson
 * @author <a href="mailto:lincolnbaxter@gmail.com>Lincoln Baxter, III</a>
 */
public class PhaseEventBridge implements PhaseListener {
    private static final long serialVersionUID = -6181019551463318453L;

    private transient final Logger log = Logger.getLogger(PhaseEventBridge.class);

    @Inject
    private BeanManager beanManager;

    /**
     * @param whenQualifier When this event occurred (e.g.: {@link PhaseListener#beforePhase(PhaseEvent)} or
     *                      {@link PhaseListener#afterPhase(PhaseEvent)})
     * @param event         The JSF PhaseEvent to be propagated
     */
    private void handlePhase(final AnnotationLiteral<?> whenQualifier, final PhaseEvent event) {
        Annotation phaseQualifier = null;

        if (PhaseId.RESTORE_VIEW.equals(event.getPhaseId())) {
            phaseQualifier = RESTORE_VIEW;
        } else if (PhaseId.PROCESS_VALIDATIONS.equals(event.getPhaseId())) {
            phaseQualifier = PROCESS_VALIDATIONS;
        } else if (PhaseId.APPLY_REQUEST_VALUES.equals(event.getPhaseId())) {
            phaseQualifier = APPLY_REQUEST_VALUES;
        } else if (PhaseId.INVOKE_APPLICATION.equals(event.getPhaseId())) {
            phaseQualifier = INVOKE_APPLICATION;
        } else if (PhaseId.UPDATE_MODEL_VALUES.equals(event.getPhaseId())) {
            phaseQualifier = UPDATE_MODEL_VALUES;
        } else if (PhaseId.RENDER_RESPONSE.equals(event.getPhaseId())) {
            phaseQualifier = RENDER_RESPONSE;
        } else {
            log.error("Unknown JSF PhaseId detected during CDI event broadcasting");
        }

        /*
         * This propagates the event to CDI
         */
        Annotation[] qualifiers = new Annotation[]{whenQualifier, phaseQualifier};
        log.debugf("Fired event [" + event + "] with qualifiers [" + qualifiers + "]");
        beanManager.fireEvent(event, qualifiers);
    }

    public void afterPhase(final PhaseEvent e) {
        handlePhase(AFTER, e);
    }

    public void beforePhase(final PhaseEvent e) {
        handlePhase(BEFORE, e);
    }

    public PhaseId getPhaseId() {
        return PhaseId.ANY_PHASE;
    }

    /*
     * Annotation Literal Constants
     */
    private static final AnnotationLiteral<Before> BEFORE = new AnnotationLiteral<Before>() {
        private static final long serialVersionUID = -1610281796509557441L;
    };

    private static final AnnotationLiteral<After> AFTER = new AnnotationLiteral<After>() {
        private static final long serialVersionUID = 5121252401235504952L;
    };

    private static final AnnotationLiteral<RestoreView> RESTORE_VIEW = new AnnotationLiteral<RestoreView>() {
        private static final long serialVersionUID = 8812020629644833820L;
    };

    private static final AnnotationLiteral<ProcessValidations> PROCESS_VALIDATIONS = new AnnotationLiteral<ProcessValidations>() {
        private static final long serialVersionUID = 8637149472340997800L;
    };

    private static final AnnotationLiteral<ApplyRequestValues> APPLY_REQUEST_VALUES = new AnnotationLiteral<ApplyRequestValues>() {
        private static final long serialVersionUID = 8558744089046159077L;
    };

    private static final AnnotationLiteral<InvokeApplication> INVOKE_APPLICATION = new AnnotationLiteral<InvokeApplication>() {
        private static final long serialVersionUID = 3161037426109802030L;
    };

    private static final AnnotationLiteral<UpdateModelValues> UPDATE_MODEL_VALUES = new AnnotationLiteral<UpdateModelValues>() {
        private static final long serialVersionUID = -2714189905299700793L;
    };

    private static final AnnotationLiteral<RenderResponse> RENDER_RESPONSE = new AnnotationLiteral<RenderResponse>() {
        private static final long serialVersionUID = -8708300190197778734L;
    };

}
