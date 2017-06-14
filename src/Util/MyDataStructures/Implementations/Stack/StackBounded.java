package Util.MyDataStructures.Implementations.Stack;

import Util.MyDataStructures.Implementations.Node;
import Util.MyDataStructures.Interfaces.Stack.IStackBounded;
import Util.MyDataStructures.Exceptions.StackOverFlowException;

/**
 * Created by msl2420 on 6/12/2017.
 */
public class StackBounded<E> extends StackAbstract<E> implements IStackBounded<E>{
    int limit = 4;

    @Override
    public void push(E input) throws StackOverFlowException {
        Node<E> newNode = new Node<>(input);

        if (isEmpty()) {
            stackTop = newNode;
        } else if(isFull()) {
            throw new StackOverFlowException("The stack is at full capacity. Max stack size is: " + limit);
        } else {
            newNode.setLink(stackTop);
            stackTop = newNode;
        }
        count++;
    }

    @Override
    public boolean isFull() {
        return count == limit;
    }
}
