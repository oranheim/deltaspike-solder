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
package org.jboss.seam.faces.transaction;

import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.inject.Inject;
import javax.transaction.UserTransaction;

import org.jboss.seam.faces.view.config.ViewConfigStore;
import org.jboss.solder.logging.Logger;
//import org.jboss.seam.persistence.PersistenceContexts;
import org.jboss.solder.core.Requires;
//import org.jboss.seam.transaction.DefaultTransaction;
//import org.jboss.seam.transaction.SeamTransaction;

import static javax.faces.event.PhaseId.ANY_PHASE;
import static javax.faces.event.PhaseId.RENDER_RESPONSE;

/**
 * Phase listener that is responsible for seam managed transactions. It is also responsible for setting the correct flush mode
 * on the persistence context during the render response phase
 *
 * @author Stuart Douglas
 * @author <a href="mailto:bleathem@gmail.com">Brian Leathem</a>
 */
@Requires({"org.jboss.seam.persistence.PersistenceContextsImpl", "org.jboss.seam.transaction.TransactionExtension"})
public class TransactionPhaseListener implements PhaseListener {
    private static final long serialVersionUID = -9127555729455066493L;

    private transient final Logger log = Logger.getLogger(TransactionPhaseListener.class);

    @Inject
    private ViewConfigStore dataStore;

    @Inject
    //@DefaultTransaction
    private UserTransaction transaction;

//    @Inject
//    private PersistenceContexts persistenceContexts;

    public PhaseId getPhaseId() {
        return ANY_PHASE;
    }

    public void beforePhase(final PhaseEvent event) {
        log.trace("before phase: " + event.getPhaseId());
        handleTransactionsBeforePhase(event);
    }

    public void afterPhase(final PhaseEvent event) {
        if (event.getPhaseId() == RENDER_RESPONSE) {
//            persistenceContexts.afterRender();
        }
        handleTransactionsAfterPhase(event);
    }

    public void handleTransactionsBeforePhase(final PhaseEvent event) {
        PhaseId phaseId = event.getPhaseId();
        if (seamManagedTransactionStatus(phaseId)) {
            if (phaseId == RENDER_RESPONSE) {
//                persistenceContexts.beforeRender();
                begin(phaseId);
            }
        }
    }

    public void handleTransactionsAfterPhase(final PhaseEvent event) {
        PhaseId phaseId = event.getPhaseId();
        if (seamManagedTransactionStatus(phaseId)) {
            boolean commitTran = (phaseId == PhaseId.INVOKE_APPLICATION) || event.getFacesContext().getRenderResponse()
                    || event.getFacesContext().getResponseComplete();

            if (commitTran) {
                commitOrRollback(phaseId);  // we commit before destroying contexts,
                                            // cos the contexts have the PC in them
            }
        }
    }

    void begin(final PhaseId phaseId) {
        begin("prior to phase: " + phaseId);
    }

    void begin(final String phaseString) {
//        try {
//            if (!transaction.isActiveOrMarkedRollback()) {
//                log.debug("beginning transaction " + phaseString);
//                transaction.begin();
//            }
//        } catch (Exception e) {
//            throw new IllegalStateException("Could not start transaction", e);
//        }
    }

    void commitOrRollback(final PhaseId phaseId) {
        commitOrRollback("after phase: " + phaseId);
    }

    void commitOrRollback(final String phaseString) {
//        try {
//            if (transaction.isActive()) {
//                try {
//                    log.debug("committing transaction " + phaseString);
//                    transaction.commit();
//
//                } catch (IllegalStateException e) {
//                    log.warn(
//                            "TX commit failed with illegal state exception. This may be because the tx timed out and was rolled back in the background.",
//                            e);
//                }
//            } else if (transaction.isRolledBackOrMarkedRollback()) {
//                log.debug("rolling back transaction " + phaseString);
//                transaction.rollback();
//            }
//
//        } catch (Exception e) {
//            throw new IllegalStateException("Could not commit transaction", e);
//        }
    }

    private boolean seamManagedTransactionStatus(final PhaseId phase) {
        SeamManagedTransaction an = null;
        SeamManagedTransactionType config;
        if (FacesContext.getCurrentInstance() != null && FacesContext.getCurrentInstance().getViewRoot() != null) {
            an = dataStore.getAnnotationData(FacesContext.getCurrentInstance().getViewRoot().getViewId(),
                    SeamManagedTransaction.class);
        }
        if (an == null) {
            // enable seam managed transactions by default
            config = SeamManagedTransactionType.ENABLED;
        } else {
            config = an.value();
        }
        if (config == SeamManagedTransactionType.DISABLED) {
            return false;
        } else if ((config == SeamManagedTransactionType.RENDER_RESPONSE) && (phase != PhaseId.RENDER_RESPONSE)) {
            return false;
        }
        return true;
    }
}
