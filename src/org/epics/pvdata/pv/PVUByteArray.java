/**
 * Copyright - See the COPYRIGHT that is included with this distribution.
 * EPICS pvData is distributed subject to a Software License Agreement found
 * in file LICENSE that is included with this distribution.
 */
package org.epics.pvdata.pv;

/**
 * Get/put a byte array.
 * Since Java does not support unsigned the actual arguments are signed.
 * Code that calls methods of the class is responsible for integer overflow problems.
 * The caller must be prepared to get/put the array in chunks.
 * The return argument is always the number of elements that were transfered.
 * It may be less than the number requested.
 * @author mrk
 *
 */
public interface PVUByteArray extends PVScalarArray{
    /**
     * Get values from a <i>PVByteArray</i> and put them into <i>byte[]from</i>.
     *
     * @param offset the offset to the first element to get
     * @param length the maximum number of elements to transfer
     * @param data the class containing the data and an offset into the data.
     * Get sets these values. The caller must do the actual data transfer.
     * @return the number of elements that can be transfered.
     * This is always less than or equal to length.
     * If the value is less then length then get should be called again.
     * If the return value is greater than 0 then data.data is
     * a reference to the array and data.offset is the offset into the
     * array.
     */
    int get(int offset, int length, ByteArrayData data);

    /**
     * Put values into a <i>PVByteArray</i> from <i>byte[]to</i>.
     * @param offset the offset to the first element to put
     * @param length the maximum number of elements to transfer
     * @param from the array from which to get the data
     * @param fromOffset The offset into from
     * @return the number of elements transfered.
     * This is always less then length than or equal to length.
     * If the value is less than the length then put should be called again.
     * @throws IllegalStateException if the field is not mutable.
     */
    int put(int offset,int length, byte[] from, int fromOffset);

    /**
     * Share the data from caller.
     * The capacity and length are taken from the array and this array is made immutable.
     * This should only be used to share immutable data.
     *
     * @param from the data to share
     */
    void shareData(byte[] from);
}
