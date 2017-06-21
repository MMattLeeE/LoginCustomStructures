package Util.MyDataStructures.Implementations.Queue;

import Util.MyDataStructures.Interfaces.Queue.IQueueBase;
import Util.MyDataStructures.Exceptions.QueueUnderFlowException;
import Util.MyDataStructures.Implementations.Node;

/**
 * Created by Matt on 6/13/2017.
 * The base class for the queue.
 */
public abstract class QueueAbstract<E> implements IQueueBase<E> {
    Node<E> front;
    Node<E> back;
    int count=0;

    /**
     * The default constructor for all queues. Sets the nodes to null.
     */
    public QueueAbstract() {
        front = null;
        back = null;
    }

    /**
     * Removes the front element of the queue
     * @return
     * The removed element.
     * @throws QueueUnderFlowException If the queue is empty.
     */
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

    /**
     * Checks if the queue is empty.
     * @return
     * True if queue empty.
     * False if queue is not empty.
     */
    @Override
    public boolean isEmpty() {
        return front==null;
    }

    /**
     * Returns how many elements in the queue.
     *
     * @return
     * Number of elements in the queue.
     */
    @Override
    public int size() {
        return count;
    }

    /**
     * Creates a string represenation of the queue.
     * @return
     * The string representation of the queue.
     */
    public String toString() {
        String queueString =" ";

        Node<E> currentNode = front;

        while (currentNode.getLink()!= null) {
            queueString = queueString + " " + currentNode.getInfo().toString() + "\n";
            currentNode = currentNode.getLink();
        }

        queueString = queueString + " " + currentNode.getInfo().toString() + "\n";


        return queueString;
    }
}
