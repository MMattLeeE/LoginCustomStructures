package Util.MyDataStructures.Implementations.Stack;

import Util.MyDataStructures.Implementations.Node;
import Util.MyDataStructures.Interfaces.Stack.IStackBounded;
import Util.MyDataStructures.Exceptions.StackOverFlowException;

/**
 * Created by msl2420 on 6/12/2017.
 * A stack that has a limit/upper bound
 */
public class StackBounded<E> extends StackAbstract<E> implements IStackBounded<E>{
    int limit = 4;

    public StackBounded() {
        super();
    }

    /**
     * Add to stack. Checks if its full
     * @param input element to add
     * @throws StackOverFlowException if stack is full
     */
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

    /**
     * Checks if stack is full
     * @return
     * true if stack is full
     * false if stack is not full
     */
    @Override
    public boolean isFull() {
        return count == limit;
    }
}
