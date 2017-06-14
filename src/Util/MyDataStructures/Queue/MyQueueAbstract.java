package Util.MyDataStructures.Queue;

import Util.MyDataStructures.Interfaces.Queue.IQueue;
import Util.MyDataStructures.MyExceptions.QueueUnderFlowException;
import Util.MyDataStructures.Node;

/**
 * Created by Matt on 6/13/2017.
 */
public abstract class MyQueueAbstract<E> implements IQueue<E>{
    Node<E> front;
    Node<E> back;
    int count=0;

    public MyQueueAbstract() {
        front = null;
        back = null;
    }

    @Override
    public E dequeue() throws QueueUnderFlowException {
        E temp;

        if(isEmpty()) {
            throw new QueueUnderFlowException("The Queue has no elements");
        } else {
            temp = front.getInfo();

            front = front.getLink();

            if (front==null) {
                back = null;
            }
        }
        count--;
        return temp;
    }

    @Override
    public boolean isEmpty() {
        return front==null;
    }

    @Override
    public int size() {
        return count;
    }
}
