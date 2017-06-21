package Util.MyDataStructures.Implementations;

/**
 * @author Matt
 *
 * 6/12/2017.
 * Node class is used to created a linked list of nodes where the element being stored is placed in private field 'info'
 * and the link to the next node is placed in private field 'link'
 * Used only for queue and stack
 * .
 */
public class Node <T> {
    private T info;
    private Node<T> link;

    /**
     * A constructor that creates a new node and stores the element inserted into the param info. The link is null by default.
     * @param
     * info The element that is stored in the node.
     *
     */
    public Node(T info) {
        this.info = info;
    }

    /**
     * Returns the element stored in the node.
     * @return
     * info - The element that was stored in the node.
     */
    public T getInfo() {
        return info;
    }

    /**
     * Store an element in a node.
     * @param
     * info The element to be stored.
     */
    public void setInfo(T info) {
        this.info = info;
    }

    /**
     * Returns the node connected to this node if any. Will return null if no node is linked.
     * @return
     * link - A node that this node is connected to.
     */
    public Node<T> getLink() {
        return link;
    }

    /**
     * Connect this node to another node.
     *
     * @param
     * link The node that is being connected to.
     */
    public void setLink(Node<T> link) {
        this.link = link;
    }

}
