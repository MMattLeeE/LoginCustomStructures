package Util.MyDataStructures.Implementations.List;

import Util.MyDataStructures.Exceptions.ListElementNotFound;
import Util.MyDataStructures.Exceptions.ListIndexOutOfBounds;
import Util.MyDataStructures.Exceptions.ListUnderFlowException;
import Util.MyDataStructures.Implementations.NodeIndexed;
import Util.MyDataStructures.Interfaces.List.IListBase;
import com.sun.corba.se.impl.encoding.EncapsOutputStream;

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
    public boolean contains(E object) {
        reset(); //set the pointer to start at front of list
        boolean isFound = false;

        if (isEmpty()) {
            isFound = false;
        } else if (count == 1) { //checking if list only has one element
            if (pointer.getInfo().compareTo(object) == 0) {
                isFound = true;
            }
        } else {
            //check until it reaches the last node which should have no right link
            while (pointer.getRight() != null && isFound == false) {
                int result = pointer.getInfo().compareTo(object);
                if (result == 0) {
                    isFound = true;
                } else {//move the pointer to the next node
                    pointer = pointer.getRight();
                }
            }
            if (isFound != true) {//check the last element. the while loop above skips it as it has a null right link.
                if (pointer.getInfo().compareTo(object)== 0) {
                    isFound = true;
                }
            }
        }
        return isFound;
    }

    @Override
    public boolean isEmpty() {
        return front==null;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public void reset() {
        pointer = front;
    }

    @Override
    public E getNext() throws ListUnderFlowException, ListIndexOutOfBounds {
        E output;

        if (isEmpty()) {
            throw new ListUnderFlowException("The list is empty. No elements to getNext().");
        } else if(pointer.getRight() != null){
            output = pointer.getRight().getInfo();
            pointer = pointer.getRight();
        } else {
            throw new ListIndexOutOfBounds("End of list. There is no element to getNext().");
        }

        return output;
    }

    @Override
    public String toString() {
        String queueString ="";

        reset();

        while (pointer != null) {
            queueString = queueString + "\n" + pointer.toString();
            pointer = pointer.getRight();
        }

        reset();
        return queueString;
    }

    @Override
    public boolean remove(E object) throws ListElementNotFound, ListUnderFlowException, ListIndexOutOfBounds {
        boolean isFound = false;

        reset();

        if (isEmpty()) {
            throw new ListUnderFlowException("List is empty. Nothing to search");
        } else if (!contains(object)) {
            throw new ListElementNotFound("The element you are looking for does not exist in the list");
        } else {
            reset();
            while (!isFound) {
                if (pointer.getInfo().compareTo(object) == 0) {//match found
                    if (size()== 1 ) {//only one element in list
                        pointer = null;
                        front = null;
                        back = null;
                        count--;
                    } else if (pointer.getLeft()==null){//if match at front of list
                        NodeIndexed<E> newFront = pointer.getRight();
                        newFront.setLeft(null);
                        front = newFront;
                        count--;
                        reset();

                        while(pointer != null) {
                            int currentIndex = pointer.getIndex();
                            pointer.setIndex(currentIndex - 1);
                            pointer = pointer.getRight();
                        }
                    } else if(pointer.getRight()==null) {//if match at end of list
                        NodeIndexed<E> newBack = pointer.getLeft();
                        newBack.setRight(null);
                        count--;
                    } else {//match anywhere else
                        NodeIndexed<E> pointerLeft = pointer.getLeft();
                        NodeIndexed<E> pointerRight = pointer.getRight();

                        pointerLeft.linkTo(pointerRight);
                        count--;
                        pointer = pointerRight.getRight();//set pointer on the right node to start decrementing indexes

                        while(pointer != null) {
                            int currentIndex = pointer.getIndex();
                            pointer.setIndex(currentIndex - 1);
                            pointer = pointer.getRight();
                        }
                    }

                    isFound = true;
                } else {
                    pointer = pointer.getRight();
                }
            }
        }

        return isFound;
    }

    public E getFront() {
        return front.getInfo();
    }

    public E getBack() {
        return back.getInfo();
    }

    public NodeIndexed<E> getPointerNode() {
        return pointer;
    }
}
