package Util.MyDataStructures.Interfaces.Queue;

import Util.MyDataStructures.MyExceptions.QueueUnderFlowException;

/**
 * Created by Matt on 6/11/2017.
 */
public interface IQueue<E>{

    E dequeue() throws QueueUnderFlowException;
    boolean isEmpty();
    int size();
    String toString();
}
