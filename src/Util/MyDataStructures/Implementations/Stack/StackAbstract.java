package Util.MyDataStructures.Implementations.Stack;

import Util.MyDataStructures.Implementations.Node;
import Util.MyDataStructures.Interfaces.Stack.IStackBase;
import Util.MyDataStructures.Exceptions.StackUnderFlowException;

import java.lang.Object;
/**
 * Created by Matt on 6/14/2017.
 * An unbounded link list stack.
 */
public abstract class StackAbstract<E> implements IStackBase<E> {
    Node<E> stackTop;
    int count=0;

    /**
     * The default constructor for all stacks.
     */
    public StackAbstract() {
        stackTop = null;
        count = 0;
    }

    /**
     * Remove and return the top element of stack.
     * @return
     * The top element of stack.
     * @throws StackUnderFlowException if the stack is empty.
     */
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

    /**
     * Returns the top of stack but does not remove.
     * @return
     * the top of the stack
     * @throws StackUnderFlowException if the stack is empty.
     */
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

    /**
     * Checks if stack is empty.
     * @return
     * true if stack is empty.
     * false if stack if not empty.
     */
    @Override
    public boolean isEmpty() {
        return stackTop==null;
    }

    /**
     * The number of elements in stack
     * @return
     * The number of elements in the stack
     */
    @Override
    public int size() {
        return count;
    }

    /**
     * Creates a string representation of the elements in the stack
     * @return
     * String representation of the stack
     */
    public String toString() {
        String stackString = "";
        Node<E> currentNode = stackTop;

        while (currentNode.getLink()!= null) {
            stackString = stackString + " " + currentNode.getInfo().toString() + "\n";
            currentNode = currentNode.getLink();
        }

        stackString = stackString + " " + currentNode.getInfo().toString() + "\n";

        return stackString;
    }
}
