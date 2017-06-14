package Util.MyDataStructures.Implementations.Stack;

import Util.MyDataStructures.Implementations.Node;
import Util.MyDataStructures.Interfaces.Stack.IStackBase;
import Util.MyDataStructures.Exceptions.StackUnderFlowException;

/**
 * Created by Matt on 6/14/2017.
 */
public abstract class StackAbstract<E> implements IStackBase<E> {
    Node<E> stackTop;

    @Override
    public E pop() throws StackUnderFlowException {
        return null;
    }

    @Override
    public E top() throws StackUnderFlowException {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }
}
