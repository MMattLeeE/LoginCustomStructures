package Util.MyDataStructures.Implementations.Queue;

import Util.MyDataStructures.Interfaces.Queue.IQueueBounded;
import Util.MyDataStructures.Exceptions.QueueOverFlowException;

import Util.MyDataStructures.Implementations.Node;

/**
 * Created by Matt on 6/12/2017.
 */
public class QueueBounded<E> extends QueueAbstract<E> implements IQueueBounded<E> {
    private int limit = 4;

    public QueueBounded() {
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
