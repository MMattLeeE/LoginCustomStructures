package Util.MyDataStructures.Implementations.Queue;

import Util.MyDataStructures.Interfaces.Queue.IQueueUnbounded;
import Util.MyDataStructures.Implementations.Node;

/**
 * Created by msl2420 on 6/12/2017.
 */
public class QueueUnbounded<E> extends QueueAbstract<E> implements IQueueUnbounded<E> {

    public QueueUnbounded() {
        super();
    }

    @Override
    public void enqueue(E input) {
        Node<E> newNode = new Node<>(input);

        if(isEmpty()) {
            front = newNode;
        } else {
            back.setLink(newNode);
        }

        back = newNode;
        count++;
    }
}
