package Util.MyDataStructures.Implementations.List;

import Util.MyDataStructures.Exceptions.ListElementNotFound;
import Util.MyDataStructures.Exceptions.ListIndexOutOfBounds;
import Util.MyDataStructures.Exceptions.ListUnderFlowException;
import Util.MyDataStructures.Implementations.NodeIndexed;
import Util.MyDataStructures.Interfaces.List.IListIndexed;

/**
 * Created by Matt on 6/12/2017.
 */
public class ListIndexed<E extends Comparable<E>> extends ListAbstract<E> implements IListIndexed<E> {

    public ListIndexed() {
        super();
    }

    @Override
    public void add(E object) {
        //create a new node to insert into list
        NodeIndexed<E> tempNode = new NodeIndexed<>(object);
        //If the node is the first node conditional
        if (isEmpty()) {
            tempNode.setIndex(count);
            pointer = tempNode;
            count++;
        } else {
            tempNode.setLeft(pointer);
            tempNode.setIndex(count);
            pointer = tempNode;
            count++;
        }

    }

    @Override
    public void add(int index, E object) throws ListIndexOutOfBounds {

    }

    @Override
    public void set(int index, E object) throws ListIndexOutOfBounds {

    }

    @Override
    public E get(int index) throws ListIndexOutOfBounds {
        return null;
    }

    @Override
    public int indexOf(E object) throws ListElementNotFound {
        return 0;
    }

    @Override
    public void remove(int index) throws ListElementNotFound, ListUnderFlowException {

    }

}
