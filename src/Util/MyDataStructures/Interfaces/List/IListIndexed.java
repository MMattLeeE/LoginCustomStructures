package Util.MyDataStructures.Interfaces.List;

import Util.MyDataStructures.Exceptions.ListElementDuplicate;
import Util.MyDataStructures.Exceptions.ListElementNotFound;
import Util.MyDataStructures.Exceptions.ListIndexOutOfBounds;
import Util.MyDataStructures.Exceptions.ListUnderFlowException;

/**
 * Created by Matt on 6/11/2017.
 * Interface for ListIndexed that holds methods with different behavior from ListOrdered
 */
public interface IListIndexed<E> extends IListBase<E> {
    void add(E object) throws ListElementDuplicate;
    void add(int index, E object) throws ListIndexOutOfBounds, ListElementDuplicate;
    E set(int index, E object) throws ListIndexOutOfBounds, ListUnderFlowException, ListElementDuplicate;
    E get(int index) throws ListIndexOutOfBounds;
    int indexOf(E object) throws ListElementNotFound, ListUnderFlowException;
    E remove(int index) throws ListIndexOutOfBounds, ListUnderFlowException;
}
