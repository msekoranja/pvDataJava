/**
 * Copyright - See the COPYRIGHT that is included with this distribution.
 * EPICS JavaIOC is distributed subject to a Software License Agreement found
 * in file LICENSE that is included with this distribution.
 */
package org.epics.pvData.pv;

/**
 * Class required by get/put PVByteArray methods.
 * Get will set data and offset.
 * @author mrk
 *
 */
public class ByteArrayData {
    /**
     * The byte[].
     * PVByteArray.get sets this value.
     * PVByteArray.put requires that the caller set the value. 
     */
    public byte[] data;
    /**
     * The offset.
     * PVByteArray.get sets this value.
     * PVByteArray.put requires that the caller set the value. 
     */
    public int offset;
}
