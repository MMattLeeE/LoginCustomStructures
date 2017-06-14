package Util.MyDataStructures.Queue;

import Util.MyDataStructures.Interfaces.Queue.IUnboundedQueue;
import Util.MyDataStructures.Node;

/**
 * Created by msl2420 on 6/12/2017.
 */
public class MyQueueUnbounded<E> extends MyQueueAbstract<E> implements IUnboundedQueue<E> {

    public MyQueueUnbounded() {
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
