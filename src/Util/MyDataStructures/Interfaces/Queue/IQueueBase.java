package Util.MyDataStructures.Interfaces.Queue;

import Util.MyDataStructures.Exceptions.QueueUnderFlowException;

/**
 * Created by Matt on 6/11/2017.
 * Holds common methods that bounded and unbounded queues share
 */
public interface IQueueBase<E>{

    E dequeue() throws QueueUnderFlowException;
    boolean isEmpty();
    int size();
    String toString();
}
