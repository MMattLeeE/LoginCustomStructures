package Util.MyDataStructures.Queue;

import Util.MyDataStructures.Interfaces.Queue.IBoundedQueue;
import Util.MyDataStructures.MyExceptions.QueueOverFlowException;

import Util.MyDataStructures.Node;

/**
 * Created by Matt on 6/12/2017.
 */
public class MyQueueBounded<E> extends MyQueueAbstract<E> implements IBoundedQueue<E> {
    private int limit = 4;

    public MyQueueBounded() {
        super();
    }

    @Override
    public void enqueue(E input) throws QueueOverFlowException {
        Node<E> newNode = new Node<>(input);

        if (isFull()) {
            throw new QueueOverFlowException("The queue size limit is: " + limit);
        } else if (isEmpty()) {
            front = newNode;
        } else {
            back.setLink(newNode);
        }

        back = newNode;
        count++;
    }

    @Override
    public boolean isFull() {
        return count == limit;
    }
}
