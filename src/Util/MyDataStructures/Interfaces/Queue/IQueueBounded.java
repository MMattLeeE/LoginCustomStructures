package Util.MyDataStructures.Interfaces.Queue;

import Util.MyDataStructures.Exceptions.QueueOverFlowException;

/**
 * Created by Matt on 6/11/2017.
 * Holds methods that behave differently from QueueUnbounded
 */
public interface IQueueBounded<E> extends IQueueBase<E> {

    void enqueue(E input) throws QueueOverFlowException;
    boolean isFull();
}
