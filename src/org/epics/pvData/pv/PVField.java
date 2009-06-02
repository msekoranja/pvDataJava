/**
 * Copyright - See the COPYRIGHT that is included with this distribution.
 * EPICS JavaIOC is distributed subject to a Software License Agreement found
 * in file LICENSE that is included with this distribution.
 */
package org.epics.pvData.pv;

/**
 * PVField is the base class for each PVData field.
 * Each PVType has an interface that extends PVField.
 * @author mrk
 *
 */
public interface PVField extends Requester, Serializable {
    /**
     * Get offset of the PVField field within top level structure.
     * Every field within the PVStructure has a unique offset.
     * The top level structure has an offset of 0.
     * The first field within the structure has offset equal to 1.
     * The other offsets are determined by recursively traversing each structure of the tree.
     * @return The offset.
     */
    int getFieldOffset();
    /**
     * Get the next offset. If the field is a scalar or array field then this is just offset + 1.
     * If the field is a structure it is the offset of the next field after this structure.
     * Thus (nextOffset - offset) is always equal to the number of fields within the field.
     * @return
     */
    int getNextFieldOffset();
    /**
     * Get the total number of fields in this field.
     * This is equal to nextFieldOffset - fieldOffset.
     * @return The number of fields.
     */
    int getNumberFields();
    /**
     * Get the PVAuxInfo interface for the PVField.
     * @return The PVAuxInfo interface.
     */
    PVAuxInfo getPVAuxInfo();
    /**
     * Can the data for the field be modified?
     * @return If it can be modified
     */
    boolean isMutable();
    /**
     * Specify if the data for the field can be modified
     * @param value (false,true) if the data (can not, can) be modified
     */
    void setMutable(boolean value);
    /**
     * Get the fullFieldName, i.e. the complete hierarchy.
     * @return The name.
     */
    String getFullFieldName();
    /**
     * Get the full name, which is the recordName plus the fullFieldName
     * @return The name.
     */
    String getFullName();
    /**
     * Get the <i>Field</i> that describes the field.
     * @return Field, which is the reflection interface.
     */
    Field getField();
    /**
     * Get the parent of this field.
     * @return The parent interface or null if this is PVRecord
     */
    PVStructure getParent();
    /**
     * Get the record.
     * @return The record interface.
     */
    PVRecord getPVRecord();
    /**
     * Replace the data implementation for a field.
     * @param newPVField The new implementation for this field.
     */
    void replacePVField(PVField newPVField);
    /**
     * Rename the field name.
     * @param newName The new name.
     */
    void renameField(String newName);
    /**
     * Add a listener to this field.
     * @param pvListener The pvListener to add to list for postPut notification.
     * @return (false,true) if the pvListener (was not,was) added.
     * If the listener was already in the list false is returned.
     */
    boolean addListener(PVListener pvListener);
    /**
     * remove a pvListener.
     * @param pvListener The listener to remove.
     */
    void removeListener(PVListener pvListener);
    /**
     * post that data has been modified.
     * This must be called by the code that issues a put request..
     */
    void postPut();
    /**
     * Convert the PVField to a string.
     * @return The string.
     */
    String toString();
    /**
     * Convert the PVField to a string.
     * Each line is indented.
     * @param indentLevel The indentation level.
     * @return The string.
     */
    String toString(int indentLevel);
}
