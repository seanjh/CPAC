/*
* LLStringNode.java
*
*/

package ch02.stringLogs;

public class LLStringNode {
    private String info;
    private LLStringNode link;

    public LLStringNode(String info) {
        this.info = info;
        link = null;
    }

    public void setInfo(String info) {
        this.info = info
    }

    public String getInfo() {
        return info;
    }

    public void setLink(LLStringNode link) {
        this.link = link;
    }

    public LLStringNode getLink() {
        return link;
    }
}