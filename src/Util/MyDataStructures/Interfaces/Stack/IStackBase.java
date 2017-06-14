package Util.MyDataStructures.Interfaces.Stack;

import Util.MyDataStructures.Exceptions.StackUnderFlowException;

/**
 * Created by Matt on 6/11/2017.
 */
public interface IStackBase<E>{
    E pop() throws StackUnderFlowException;
    E top() throws StackUnderFlowException;
    boolean isEmpty();
    int size();
    String toString();

}
