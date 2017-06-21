package Util.MyDataStructures.Implementations.List;

import Util.MyDataStructures.Exceptions.ListElementDuplicate;
import Util.MyDataStructures.Exceptions.ListElementNotFound;
import Util.MyDataStructures.Exceptions.ListIndexOutOfBounds;
import Util.MyDataStructures.Exceptions.ListUnderFlowException;
import Util.MyDataStructures.Implementations.NodeIndexed;
import Util.MyDataStructures.Interfaces.List.IListIndexed;

import java.util.List;

/**
 * Created by Matt on 6/12/2017.
 * A doubly linked index list.
 */
public class ListIndexed<E extends Comparable<E>> extends ListAbstract<E> implements IListIndexed<E> {

    /**
     * Calls the default constructor of the ListAbstract class.
     */
    public ListIndexed() {
        super();
    }

    /**
     * Add a new element to the end of the list.
     *
     * @param
     * object the object to be inserted into the list.
     */
    @Override
    public void add(E object) throws ListElementDuplicate {

        NodeIndexed<E> tempNode = new NodeIndexed<>(object);
        //If the node is the first node conditional
        if (isEmpty()) {//inserting the first node
            //the index of the node should be 0
            front = tempNode;
            pointer = tempNode;
            back = tempNode;
            count++;
        } else if (contains(object)) {
            throw new ListElementDuplicate("Element already exists in the list");
        } else {
            reset();
            //if the list has at least one node in it
            back.linkTo(tempNode);//connect the current back node to the new node being added
            back = tempNode;//point the back of the list to the new node
            count++;
        }

    }

    /**
     * Add an element at a specified index. Does not replace the element that is already their but
     * instead shifts everything to the right.
     *
     * @param
     * index the index to insert the element at
     * object object to insert into a list
     *
     *       @throws
     *       ListIndexOutOfBounds - if the specified parameter index does not exist in the list
     */
    @Override
    public void add(int index, E object) throws ListIndexOutOfBounds, ListElementDuplicate {

        NodeIndexed<E> insertNode = new NodeIndexed<>(object);

        //check to see if this is the first element being added to list:
        if (isEmpty()) {
            add(object);
        //check if index is in bounds
        } else if (index > count || index < 0) {
            throw new ListIndexOutOfBounds("The index specified is not in range of this list");
        } else if (contains(object)){
            throw new ListElementDuplicate("Element already exists in the list");
        } else {
            reset();//bring pointer to front

            if (index==0){//just adding to the FRONT of the list:
                insertNode.linkTo(front);
                front = insertNode;//set front of list to new node
                count++;
            } else if (index == (count-1)) {//just adding to the BACK of list:
                back.getLeft().linkTo(insertNode);
                insertNode.linkTo(back);//just like normal adding without an index specified
                count++;
            } else if (index == count){
                add(object);
            } else {//lastly if adding a node into any index not at the front or the back:

                //move pointer to specified index:
                for (int i = 0; i < index; i++) {
                    pointer = pointer.getRight();
                }

                //pointer should now be at the node in the specified index location

                //get the node before the pointer and connect it to the inserting node
                //also sets the index of the node we are connecting on the left and the inserting nodes index
                pointer.getLeft().linkTo(insertNode);

                insertNode.linkTo(pointer);//connect the inserting node to the pointer

                count++; //increase size of list

                //change all of the indexes of nodes after the new inserted node; the first node changed is the node that was replaced, also where the pointer is currently
                while (pointer != null) {//pointer will be null once it reads the last node which will have a null right link
                    pointer.setIndex(pointer.getLeft().getIndex() + 1);

                    if (pointer.getRight() == null) {//just before setting the pointer to null, set the back of list to the last node
                        back = pointer;
                    }

                    pointer = pointer.getRight();
                }

            }
        }
    }

    /**
     * Takes out an element at a specified index and replaces it with object.
     * @param index The index to replace an element.
     * @param object The element that is being inserted.
     * @return
     * The element that is replaced.
     * @throws ListIndexOutOfBounds If an index is out of bounds of the list.
     * @throws ListUnderFlowException If the list is empty.
     * @throws ListElementDuplicate If a duplicate element is being inserted into the list.
     */
    @Override
    public E set(int index, E object) throws ListIndexOutOfBounds, ListUnderFlowException, ListElementDuplicate {

        E removedListElement;
        NodeIndexed<E> insertNode = new NodeIndexed<>(object);

        //check to see if this is the first element being added to list:
        if (isEmpty()) {
            throw new ListUnderFlowException("The list is empty. No elements to set");
            //check if index is in bounds
        } else if (index >= count || index < 0) {
            throw new ListIndexOutOfBounds("The index specified is not in range of this list");
        } else if (contains(object)) {
            throw new ListElementDuplicate("Element already exists in the list");
        } else {
            if (index == 0) {
                removedListElement = front.getInfo();
                insertNode.linkTo(front.getRight());
                front = insertNode;
            }else if(index == size()-1) {
                removedListElement = back.getInfo();
                back.getLeft().linkTo(insertNode);
                back = insertNode;
            } else {
                //set pointer to front
                reset();
                //move pointer to specified index:
                for (int i = 0; i < index; i++) {
                    pointer = pointer.getRight();
                }
                //info to return
                removedListElement = pointer.getInfo();
                pointer.getLeft().linkTo(insertNode);
                insertNode.linkTo(pointer.getRight());
            }
        }
        return removedListElement;
    }

    /**
     * Finds the element in the list.
     * @param index The location of the element desired.
     * @return
     * The element at the specified index in the list.
     * @throws ListIndexOutOfBounds If the index is not in the bounds of the list.
     */
    @Override
    public E get(int index) throws ListIndexOutOfBounds {
        E output;

        reset();
        if (index < 0 || index >= count) {
            throw new ListIndexOutOfBounds("The index cannot be negative or greater than or equal to the length of the list");
        } else {
            while (pointer.getIndex() != index) {
                pointer = pointer.getRight();
            }
            output = pointer.getInfo();
        }
        return output;
    }

    /**
     * Find the index of an element in a list.
     * @param object The element to be found in the list.
     * @return
     * The index of the object.
     * @throws ListElementNotFound If the element object doesn't exist in the list.
     * @throws ListUnderFlowException If the list is empty.
     */
    @Override
    public int indexOf(E object) throws ListElementNotFound, ListUnderFlowException {
        reset();
        int indexOut = -1;

        if (isEmpty()) {
            throw new ListUnderFlowException("List is empty. Nothing to search");
        } else {
            while (pointer != null && indexOut < 0) {
                if (pointer.getInfo().compareTo(object) == 0) {
                    indexOut = pointer.getIndex();
                } else {
                    pointer = pointer.getRight();
                }
            }
        }
        if (indexOut<0) {
            throw new ListElementNotFound("The element you are looking for does not exist in the list.");
        }
        return indexOut;
    }

    /**
     * Remove the element at the specified index in the list.
     * @param index The location in the list to remove an element.
     * @return
     * The removed element.
     * @throws ListIndexOutOfBounds If the index is out of the bounds of list.
     * @throws ListUnderFlowException If the list is empty.
     */
    @Override
    public E remove(int index) throws ListIndexOutOfBounds, ListUnderFlowException {
        E removedElement;

        if (isEmpty()) {
            throw new ListUnderFlowException("The list is empty. Nothing to remove.");
        } else if (index >= size() || index <0) {
            throw new ListIndexOutOfBounds("The index is not in the bounds of the list.");
        } else if (index==0) { //removal at the front of list
            reset();
            removedElement = front.getInfo();
            pointer = front.getRight();
            pointer.setLeft(null);
            front = pointer;
            count--;

            while(pointer != null) {
                int currentIndex = pointer.getIndex();
                pointer.setIndex(currentIndex - 1);
                pointer = pointer.getRight();
            }

        } else if (index==size()-1){ //removal at the end of list
                removedElement = back.getInfo();
                pointer = back.getLeft();
                pointer.setRight(null);
                count--;
        } else {
            reset();

            while (pointer.getIndex() != index) {
                pointer = pointer.getRight();
            }

            removedElement = pointer.getInfo();

            NodeIndexed<E> leftSide = pointer.getLeft();
            NodeIndexed<E> rightSide = pointer.getRight();

            leftSide.setRight(rightSide);
            rightSide.setLeft(leftSide);

            pointer = rightSide;
            count--;

            while(pointer != null) {
                int currentIndex = pointer.getIndex();
                pointer.setIndex(currentIndex - 1);
                pointer = pointer.getRight();
            }
        }

        return removedElement;
    }

}
