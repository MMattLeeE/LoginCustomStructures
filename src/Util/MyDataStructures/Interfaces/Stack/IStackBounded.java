package Util.MyDataStructures.Interfaces.Stack;

import Util.MyDataStructures.Exceptions.StackOverFlowException;

/**
 * Created by Matt on 6/11/2017.
 */
public interface IStackBounded<E> extends IStackBase<E> {
    void push(E object) throws StackOverFlowException;
    boolean isFull();
}
