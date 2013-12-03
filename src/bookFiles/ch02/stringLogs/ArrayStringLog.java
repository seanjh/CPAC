/*
* ArrayStringLog.java
*
*/

package ch02.stringLogs;

public class ArrayStringLog implements StringLogInterface {
    protected String name; // name of this log
    protected String[] log; // array that holds the log elements
    protected int lastIndex = -1; // index of the last string in the array

    public ArrayStringLog(String name, int maxSize) {
        // Precondition: maxSize > 0
        log = new String[maxSize];
        this.name = name;
    }

    public ArrayStringLog(String name) {
        this(name, 100);
    }

    public void insert(String element) {
        // Precondition: This StringLog is not full
        lastIndex++;
        log[lastIndex] = element;
    }

    public void clear() {
        // Makes the StringLog empty
        for (int i = 1; i <= lastIndex; i++) {
            log[i] = null;
        }

        lastIndex = -1;
    }

    public boolean isFull() {
        return (lastIndex == log.length - 1);
    }

    public int size() {
        return (lastIndex + 1);
    }

    public String getName() {
        return name;
    }

    @Override public String toString() {
        String logString = "Log: " + name + "\n\n";

        for (int i = 0; i <= lastIndex; i++) {
            logString += (i + 1) + ". " + log[i] + "\n";
        }

        return logString;
    }

    public boolean contains(String element) {
        for (int i = 0; i <= lastIndex; i++) {
            if (log[i].equalsIgnoreCase(element)) {
                return true; // Found element in the StringLog
            }
        }

        return false; // Did not find element in the StringLog
    }
}