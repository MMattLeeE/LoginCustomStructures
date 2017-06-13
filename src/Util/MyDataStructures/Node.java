package Util.MyDataStructures;

/**
 * Created by msl2420 on 6/12/2017.
 */
public class Node <T> {
    private T info;
    private Node link;

    public Node(T info) {
        this.info = info;
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public Node getLink() {
        return link;
    }

    public void setLink(Node link) {
        this.link = link;
    }
}
