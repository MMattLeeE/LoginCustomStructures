package Util.MyDataStructures.Implementations.Queue;

import Util.MyDataStructures.Interfaces.Queue.IQueueBounded;
import Util.MyDataStructures.Exceptions.QueueOverFlowException;

import Util.MyDataStructures.Implementations.Node;

/**
 * Created by Matt on 6/12/2017.
 * An unbounded link list queue bounded by a limit field that's checked when adding to the queue.
 */
public class QueueBounded<E> extends QueueAbstract<E> implements IQueueBounded<E> {
    private int limit = 4;

    public QueueBounded() {
        super();
    }

    /**
     * Add element to the end of the queue.
     * @param input The element to add to the queue.
     * @throws QueueOverFlowException If the queue is full.
     */
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

    /**
     * Checks if the queue is full
     * @return
     * true if the queue is full
     * false if teh queue is not full
     */
    @Override
    public boolean isFull() {
        return count == limit;
    }
}
