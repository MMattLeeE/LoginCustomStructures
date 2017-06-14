package Util.MyDataStructures.Implementations.Stack;

import Util.MyDataStructures.Implementations.Node;
import Util.MyDataStructures.Interfaces.Stack.IStackBase;
import Util.MyDataStructures.Exceptions.StackUnderFlowException;

import java.lang.Object;
/**
 * Created by Matt on 6/14/2017.
 */
public abstract class StackAbstract<E> implements IStackBase<E> {
    Node<E> stackTop;
    int count=0;

    // Returns the top element on stack and removes it from stack.
    @Override
    public E pop() throws StackUnderFlowException {
        E temp;

        if (isEmpty()) {
            throw new StackUnderFlowException("The stack is empty. Nothing to pop.");
        } else {
            temp = stackTop.getInfo();

            stackTop = stackTop.getLink();
        }

        count--;
        return temp;
    }

    // Assuming top() is the same as peek(),
    // returns the top element on stack without removing it.
    @Override
    public E top() throws StackUnderFlowException {
        E temp;

        if (isEmpty()) {
            throw new StackUnderFlowException("The Stack is empty. Nothing to top.");
        } else {
            temp = stackTop.getInfo();
        }

        return temp;
    }

    @Override
    public boolean isEmpty() {
        return stackTop==null;
    }

    @Override
    public int size() {
        return count;
    }

    public String toString() {
        String stackString = "";
        Node<E> currentNode = stackTop;

        while (currentNode.getLink()!= null) {
            stackString = stackString + " " + currentNode.getInfo().toString() + "\n";
            currentNode = currentNode.getLink();
        }

        return stackString;
    }
}
