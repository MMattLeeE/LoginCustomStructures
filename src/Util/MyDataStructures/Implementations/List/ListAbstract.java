package Util.MyDataStructures.Implementations.List;

import Util.MyDataStructures.Exceptions.ListElementNotFound;
import Util.MyDataStructures.Exceptions.ListIndexOutOfBounds;
import Util.MyDataStructures.Exceptions.ListUnderFlowException;
import Util.MyDataStructures.Implementations.NodeIndexed;
import Util.MyDataStructures.Interfaces.List.IListBase;
import com.sun.corba.se.impl.encoding.EncapsOutputStream;

import java.io.Serializable;

/**
 * Created by Matt on 6/14/2017.
 * The base class for both the ListIndexed and ListOrdered classes.
 * ListAbstract holds methods ListIndexed and ListOrdered have in common.
 * Created to not have to copyPasta() in both ListIndexed and ListOrdered.
 *
 * All lists are doubly linked index lists. The ListOrdered just doesn't use the index fields on NodeIndexed.
 */
public abstract class ListAbstract<E extends Comparable<E>> implements IListBase<E>, Serializable {

    NodeIndexed<E> front;
    NodeIndexed<E> pointer;
    NodeIndexed<E> back;
    int count = 0;

    /**
     * The default constructor. Sets the pointers front pointer and back to null.
     */
    public ListAbstract() {
        front = null;
        pointer = null;
        back = null;
    }

    /**
     * Checks a list to see if it holds the specified element.
     * @param
     * object the element to be searched for in the list.
     * @return
     * true if object is in the list.
     * false if object is not in the list.
     *
     */
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

    /**
     * Checks if the list is empty or not.
     * @return
     * true if the list is empty.
     * false if teh list is not empty.
     */
    @Override
    public boolean isEmpty() {
        return front==null;
    }

    /**
     * Gets the number of elements in a list.
     * @return
     * The number of elements in the list.
     */
    @Override
    public int size() {
        return count;
    }

    /**
     * Moves the pointer back to the front of the list.
     */
    @Override
    public void reset() {
        pointer = front;
    }

    /**
     * Gets the element next to the pointer.
     * @return
     * The element next to the pointer.
     * @throws ListUnderFlowException if the list is empty.
     * @throws ListElementNotFound if at the end of the list and there is nothing to getNext.
     */
    @Override
    public E getNext() throws ListUnderFlowException, ListElementNotFound {
        E output;

        if (isEmpty()) {
            throw new ListUnderFlowException("The list is empty. No elements to getNext().");
        } else if(pointer.getRight() != null){
            output = pointer.getRight().getInfo();
            pointer = pointer.getRight();
        } else {
            throw new ListElementNotFound("End of list. There is no element to getNext().");
        }

        return output;
    }

    /**
     * Creates a string representation of the List
     * @return
     * A string representation of the list.
     */
    @Override
    public String toString() {
        String outString ="";
        reset();

        while (pointer != null) {
            outString = outString + pointer.getInfo().toString();
            pointer = pointer.getRight();
        }

        reset();
        return outString;
    }

    /**
     * Creates a string representation of the nodes and the elements in each node in the list.
     * Useful for testing and debugging.
     * @return
     * A string representation of the nodes in the list.
     */
    public String nodeToString() {
        String queueString ="";

        reset();

        while (pointer != null) {
            queueString = queueString + "\n" + pointer.toString();
            pointer = pointer.getRight();
        }

        reset();
        return queueString;
    }

    /**
     * Removes the specified element from the list.
     * @param
     * object The element to be removed from the list.
     * @return
     * True if the element if found in the list.
     * @throws ListElementNotFound If the element is not found in the list.
     * @throws ListUnderFlowException If attempt to remove from an empty list.
     */
    @Override
    public boolean remove(E object) throws ListElementNotFound, ListUnderFlowException {
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

    /**
     * Get the element held in the front node of list.
     * @return
     * The element held in the front of the list.
     */
    public E getFront() {
        return front.getInfo();
    }

    /**
     * Get the last element in the list.
     * @return
     * The element at the end of the list.
     */
    public E getBack() {
        return back.getInfo();
    }

    /**
     * Get the Node that the pointer is pointing to.
     * @return
     * The node in the pointer.
     */
    public NodeIndexed<E> getPointerNode() {
        return pointer;
    }

}
