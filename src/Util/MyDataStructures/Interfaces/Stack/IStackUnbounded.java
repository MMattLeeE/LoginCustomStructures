package Util.MyDataStructures.Interfaces.Stack;

/**
 * Created by Matt on 6/11/2017.
 * Contains just the method push without throwing an exception.
 */
public interface IStackUnbounded<E> extends IStackBase<E> {
    void push(E input);
}
