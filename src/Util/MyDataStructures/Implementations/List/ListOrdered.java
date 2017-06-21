package Util.MyDataStructures.Implementations.List;

import Util.MyDataStructures.Exceptions.ListElementDuplicate;
import Util.MyDataStructures.Exceptions.ListElementNotFound;
import Util.MyDataStructures.Exceptions.ListUnderFlowException;
import Util.MyDataStructures.Implementations.NodeIndexed;
import Util.MyDataStructures.Interfaces.List.IListOrdered;

/**
 * Created by Matt on 6/12/2017.
 */
public class ListOrdered<E extends Comparable<E>> extends ListAbstract<E> implements IListOrdered<E> {

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
