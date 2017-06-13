package Util.MyDataStructures.Queue;

import Util.MyDataStructures.Interfaces.Queue.IUnboundedQueue;
import Util.MyDataStructures.Node;

import java.util.Objects;
import java.util.Queue;

/**
 * Created by msl2420 on 6/12/2017.
 */
public class MyQueueUnbounded<E> implements IUnboundedQueue<E> {
    private Node<E> front;
    private Node<E> back;
    private int count;

    public MyQueueUnbounded() {
        front = null;
        back = null;
    }

    @Override
    public void enqueue(E element) {
        Node newNode = new Node(element);

        if(isEmpty()) {
            front = newNode;
        } else {
            back.setLink(newNode);
        }
        back = newNode;
        count++;
    }

    @Override
    public E Dequeue() {
        E temp = null;

        if(isEmpty()) {
            //throw custom exception here
        } else {
            temp = front.getInfo();
            front = front.getLink();
            if (front==back) {
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
