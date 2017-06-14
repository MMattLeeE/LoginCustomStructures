package Util.MyDataStructures.Interfaces.Queue;

import Util.MyDataStructures.MyExceptions.QueueOverFlowException;

/**
 * Created by Matt on 6/11/2017.
 */
public interface IBoundedQueue<E> extends IQueue<E> {

    void enqueue(E input) throws QueueOverFlowException;
    boolean isFull();
}
