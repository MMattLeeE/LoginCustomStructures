package Util.MyDataStructures.Interfaces.Queue;

/**
 * Created by Matt on 6/11/2017.
 */
public interface IBoundedQueue<E> extends IQueue<E> {

    void enqueue(E object);
    boolean isFull();
}
