/*
* StringLogInterface.java   by Dale/Joyce/Weems     Chapter 2
*
* Interface for a class that implements a log of strings.
* A log "remembers" the elements placed into it.
*
* A log must have a "name."
*/

package ch02.stringLogs;

public interface StringLogInterface {
    void insert(String element);
    // Precondition: StringLog is not full.
    //
    // Places a new element into the StringLog.

    boolean contains(String element);
    // Returns true when the element exists in the StringLog.
    // The contains method ignores case.

    int size();
    // Returns the number of items in the StringLog.

    boolean isFull();
    // Returns true if the StringLog is full.

    void clear();
    // Makes the StringLog empty

    String getName();
    // Returns the name of the StringLog

    String toString();
    // Returns the entire StringLog as a single String.
}