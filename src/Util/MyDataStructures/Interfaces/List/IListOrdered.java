package Util.MyDataStructures.Interfaces.List;

import Util.MyDataStructures.Exceptions.ListElementDuplicate;
import Util.MyDataStructures.Exceptions.ListElementNotFound;
import Util.MyDataStructures.Exceptions.ListUnderFlowException;

/**
 * Created by Matt on 6/11/2017.
 * Holds methods with different behavior than ListIndexed
 */
public interface IListOrdered<E> extends IListBase<E> {
    void add(E object) throws ListElementDuplicate;
    E get() throws ListElementNotFound;
    E get(E object) throws ListElementNotFound;
}
