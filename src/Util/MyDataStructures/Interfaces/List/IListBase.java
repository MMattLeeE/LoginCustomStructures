package Util.MyDataStructures.Interfaces.List;

import Util.MyDataStructures.Exceptions.ListElementNotFound;

import Util.MyDataStructures.Exceptions.ListIndexOutOfBounds;
import Util.MyDataStructures.Exceptions.ListUnderFlowException;
import Util.MyDataStructures.Implementations.NodeIndexed;

/**
 * Created by Matt on 6/11/2017.
 *
 * IListBase is the base interface that IListIndexed and IlistOrdered extend.
 *
 * IListBase holds common methods that both IListIndexed and IListOrdered contain.
 *
 * Multiple interfaces were created because IListIndexed and IListOrdered have different exceptions
 * and parameters for specific methods.
 *
 */

public interface IListBase<E> {
    boolean contains(E object);
    boolean isEmpty();
    int size();
    String toString();
    void reset();
    E getNext() throws ListUnderFlowException, ListIndexOutOfBounds;
    boolean remove(E object) throws ListElementNotFound, ListUnderFlowException, ListIndexOutOfBounds;

}
