package Util.MyDataStructures.Implementations;

/**
 * @author Matt
 *
 * 6/12/2017.
 * Node class is used to created a linked list of nodes where the element being stored is placed in private field 'info'
 * and the right to the next node is placed in private field 'right'.
 *
 * A node is:
 * -----------------------
 * | left | info | right |
 * -----------------------
 */
public class NodeIndexed <T extends Comparable<T>> implements Comparable<NodeIndexed<T>> {
    private NodeIndexed<T> left;
    private T info;
    private NodeIndexed<T> right;
    private int index = 0;

    /**
     * A constructor that creates a new node and stores the element inserted into the param info. The right is null by default.
     * @param
     * info The element that is stored in the node.
     *
     */
    public NodeIndexed(T info) {
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
     * right - A node that this node is connected to.
     */
    public NodeIndexed<T> getRight() {
        return right;
    }

    /**
     * Connect this node to another node.
     *
     * @param
     * right The node that is being connected to.
     */
    public void setRight(NodeIndexed<T> right) {
        this.right = right;
    }

    public NodeIndexed<T> getLeft() {
        return left;
    }

    public void setLeft(NodeIndexed<T> left) {
        this.left = left;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    @Override
    public int compareTo(NodeIndexed<T> o) {
        return info.compareTo(o.info);
    }
}