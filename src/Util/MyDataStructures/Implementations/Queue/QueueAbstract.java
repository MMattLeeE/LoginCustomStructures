package Util.MyDataStructures.Implementations.Queue;

import Util.MyDataStructures.Interfaces.Queue.IQueueBase;
import Util.MyDataStructures.Exceptions.QueueUnderFlowException;
import Util.MyDataStructures.Implementations.Node;

/**
 * Created by Matt on 6/13/2017.
 */
public abstract class QueueAbstract<E> implements IQueueBase<E> {
    Node<E> front;
    Node<E> back;
    int count=0;

    public QueueAbstract() {
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
