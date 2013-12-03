/*
*
*
*/

package ch02.stringLogs;

public class LinkedStringLog implements StringLogInterface {
    protected LLStringNode log; // reference to the first node
    protected String name;      // name of this StringLog

    public LinkedStringLog(String name) {
        log = null;
        this.name = name;
    }

    public void insert(String element) {
        LLStringNode newNode = new LLStringNode(element);
        newNode.setLink(log);
        log = newNode;
    }

    public void clear() {
        log = null;
    }

    public boolean isFull() {
        return false;
    }

    public String getName() {
        return name;
    }

    public int size() {
        int count = 0;
        LLStringNode node = log;

        while (node != null) {
            count++;
            node = node.getLink();
        }

        return count;
    }

    @Override public String toString() {
        String logString = "Log: " + name + "\n\n";
        LLStringNode node = log;
        int count = 0;

        while (node != null) {
            count++;
            logString += count + ". " + node.getInfo() + "\n";
            node = node.getLink();
        }

        return logString;
    }

    public boolean contains(String element) {
        LLStringNode node = log;

        while (node != null) {
            if (node.getInfo().equalsIgnoreCase(element))
                return true;
            node = node.getLink();
        }

        return false;
    }
}