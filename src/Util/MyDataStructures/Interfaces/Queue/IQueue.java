package Util.MyDataStructures.Interfaces.Queue;

/**
 * Created by Matt on 6/11/2017.
 */
public interface IQueue<E>{

    E Dequeue();
    boolean isEmpty();
    int size();
    String toString();
}
