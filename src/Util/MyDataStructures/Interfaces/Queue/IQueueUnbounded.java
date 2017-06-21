package Util.MyDataStructures.Interfaces.Queue;

/**
 * Created by Matt on 6/12/2017.
 * Holds methods that behave differently from QueueBounded
 */
public interface IQueueUnbounded<E> extends IQueueBase<E> {
    void enqueue (E input);
}
