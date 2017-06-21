package Util.MyDataStructures.Implementations.List;

import Util.MyDataStructures.Exceptions.ListElementDuplicate;
import Util.MyDataStructures.Exceptions.ListElementNotFound;
import Util.MyDataStructures.Exceptions.ListUnderFlowException;
import Util.MyDataStructures.Implementations.NodeIndexed;
import Util.MyDataStructures.Interfaces.List.IListOrdered;

import java.io.Serializable;

/**
 * Created by Matt on 6/12/2017.
 * A doubly linked ordered index list.
 */
public class ListOrdered<E extends Comparable<E>> extends ListAbstract<E> implements IListOrdered<E>, Serializable {

    /**
     * Adds an element into the list and maintains order using compareTo.
     * @param object The element to insert into list.
     * @throws ListElementDuplicate If the element being added already exists in the list.
     */
    @Override
    public void add(E object) throws ListElementDuplicate {

        NodeIndexed<E> tempNode = new NodeIndexed<>(object);

        boolean inserted = false;

        if (isEmpty()) {
            front =tempNode;
            pointer = tempNode;
            back = tempNode;
            count++;
        } else if (contains(object)){
            throw new ListElementDuplicate("The element already exists in the list");
        } else {
            reset();
            while (!inserted) {
                if (object.compareTo(pointer.getInfo()) > 0) {//if the insert object is GREATER than current pointer
                    if (pointer.getRight() != null) {
                        pointer = pointer.getRight();
                    } else if (pointer.getRight() == null) {//if the last element of the list
                        pointer.linkTo(tempNode);
                        back = tempNode;
                        count++;
                        inserted = true;
                    }
                } else if (object.compareTo(pointer.getInfo()) < 0) {//if the insert object is LESS than current pointer
                    if (pointer.getLeft() != null) {//if there is an element that is to the left
                        pointer.getLeft().linkTo(tempNode);
                        tempNode.linkTo(pointer);
                        count++;
                        inserted = true;
                    } else if (pointer.getLeft() == null){//if the first element of the list
                        tempNode.linkTo(pointer);
                        count++;
                        front = tempNode;
                        inserted = true;
                    }
                }
            }
        }
    }

    /**
     * A method that returns the element where the pointer is currently at.
     * @return
     * E The element the pointer is currently at.
     * @throws
     * ListElementNotFound If the current pointer has no element to return or the list is empty
     *
     */
    @Override
    public E get() throws ListElementNotFound {
        E output;
        if (pointer == null) {
            throw new ListElementNotFound("There is no element to return. Pointer is null.");
        } else if (isEmpty()) {
            throw new ListElementNotFound("The list is empty. There is no element to get.");
        } else {
            output = pointer.getInfo();
        }
        return output;
    }

    /**
     * Used to get an element from the List.
     * When implemented with User class a temporary user object with the username to search for is used as the argument to find a user.
     * @param object The element to get. In the case of Users, a User object is instantiated with the username one wants and is used as the argument.
     * @return
     * The actual element from the list.
     * @throws ListElementNotFound If the element doesn't exist in the list.
     */
    @Override
    public E get(E object) throws ListElementNotFound {
        E output = null;
        if (!contains(object)) {
            throw new ListElementNotFound("The element to get does not exist in this list");
        } else {
            reset();
            boolean isFound = false;
            while(!isFound) {
                if (pointer.getInfo().compareTo(object)==0) {
                    output = pointer.getInfo();
                    isFound = true;
                } else {
                    pointer = pointer.getRight();
                }
            }
        }
        return output;
    }

}
