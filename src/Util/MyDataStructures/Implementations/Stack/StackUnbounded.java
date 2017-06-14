package Util.MyDataStructures.Implementations.Stack;

import Util.MyDataStructures.Implementations.Node;
import Util.MyDataStructures.Interfaces.Stack.IStackUnbounded;

/**
 * Created by Matt on 6/12/2017.
 */
public class StackUnbounded<E> extends StackAbstract<E> implements IStackUnbounded<E> {
    @Override
    public void push(E input) {
        Node<E> newNode = new Node<>(input);

        if (isEmpty()) {
            stackTop = newNode;
        } else {
            newNode.setLink(stackTop);
            stackTop = newNode;
        }
        count++;
    }
}
