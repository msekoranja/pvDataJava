/**
 * Copyright - See the COPYRIGHT that is included with this distribution.
 * EPICS pvData is distributed subject to a Software License Agreement found
 * in file LICENSE that is included with this distribution.
 */
package org.epics.pvdata.misc;

/**
 * Interface implemented by ThreadCreate
 * @author mrk
 *
 */
public interface ThreadReady {
    /**
     * Called by RunnableReady.run when it is ready.
     */
    void ready();
}
