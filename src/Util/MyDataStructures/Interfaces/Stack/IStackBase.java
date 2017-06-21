package Util.MyDataStructures.Interfaces.Stack;

import Util.MyDataStructures.Exceptions.StackUnderFlowException;

/**
 * Created by Matt on 6/11/2017.
 * Base interface for Stacks. Holds methods that behave the same in both StackBounded and StackUnbounded
 */
public interface IStackBase<E> {
    E pop() throws StackUnderFlowException;
    E top() throws StackUnderFlowException;
    boolean isEmpty();
    int size();
    String toString();

}
