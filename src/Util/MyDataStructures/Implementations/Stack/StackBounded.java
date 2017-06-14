package Util.MyDataStructures.Implementations.Stack;

import Util.MyDataStructures.Interfaces.Stack.IStackBounded;
import Util.MyDataStructures.Exceptions.StackOverFlowException;

/**
 * Created by msl2420 on 6/12/2017.
 */
public class StackBounded<E> extends StackAbstract<E> implements IStackBounded<E>{

    @Override
    public void push(E object) throws StackOverFlowException {

    }

    @Override
    public boolean isFull() {
        return false;
    }
}
