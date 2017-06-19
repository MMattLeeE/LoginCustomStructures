package Util.MyDataStructures.Implementations.List;

import Util.MyDataStructures.Exceptions.ListElementNotFound;
import Util.MyDataStructures.Exceptions.ListUnderFlowException;
import Util.MyDataStructures.Interfaces.List.IListOrdered;

/**
 * Created by Matt on 6/12/2017.
 */
public class ListOrdered<E extends Comparable<E>> extends ListAbstract<E> implements IListOrdered<E> {

    @Override
    public void add(E object) {

    }

    @Override
    public E get() {
        return null;
    }

    @Override
    public void remove(E object) throws ListElementNotFound, ListUnderFlowException {

    }

}
