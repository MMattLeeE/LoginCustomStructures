package Util.MyDataStructures.Implementations.List;

import Util.MyDataStructures.Exceptions.ListUnderFlowException;
import Util.MyDataStructures.Implementations.NodeIndexed;
import Util.MyDataStructures.Interfaces.List.IListBase;

/**
 * Created by Matt on 6/14/2017.
 */
public abstract class ListAbstract<E extends Comparable<E>> implements IListBase<E> {

    NodeIndexed<E> front;
    NodeIndexed<E> pointer;
    NodeIndexed<E> back;
    int count = 0;

    public ListAbstract() {
        front = null;
        pointer = null;
        back = null;
    }

    @Override
    public String toString() {
        String queueString =" ";

        NodeIndexed<E> currentNode = pointer;

        while (currentNode.getRight()!= null) {
            queueString = queueString + " " + currentNode.getInfo().toString() + "\n";
            currentNode = currentNode.getRight();
        }

        queueString = queueString + " " + currentNode.getInfo().toString() + "\n";

        return queueString;
    }

    @Override
    public boolean contains(E object) {
        NodeIndexed<E> currentNode = pointer;

        boolean isFound = false;

        if (isEmpty()) {
            isFound = false;
        } else if (count == 1) {
            isFound = currentNode.getInfo().compareTo(object) == 0;
        } else {
            while (currentNode.getRight() != null && isFound == false) {
                int result = currentNode.getInfo().compareTo(object);
                if (result == 0) {
                    isFound = true;
                } else {
                    currentNode = currentNode.getRight();
                }
            }
            if (isFound != true) {
                isFound = currentNode.getInfo().compareTo(object)== 0;
            }
        }
        return isFound;
    }

    public boolean isEmpty() {
        return count==0;
    }

    public void reset() throws ListUnderFlowException{
        if (isEmpty()) {
            throw new ListUnderFlowException("List is empty. Nothing to reset.");
        }
        while(pointer.getLeft()!=null) {
           pointer = pointer.getLeft();
        }
    }

    public E getNext() throws ListUnderFlowException {
        if (isEmpty()) {
            throw new ListUnderFlowException("The list is empty. No elements to output.");
        } else {
            E output = pointer.getRight().getInfo();
            pointer = pointer.getRight();
            return output;
        }
    }

    @Override
    public int size() {
        return count;
    }

}
