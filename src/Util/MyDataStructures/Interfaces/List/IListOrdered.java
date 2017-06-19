package Util.MyDataStructures.Interfaces.List;

import Util.MyDataStructures.Exceptions.ListElementNotFound;
import Util.MyDataStructures.Exceptions.ListUnderFlowException;

/**
 * Created by Matt on 6/11/2017.
 */
public interface IListOrdered<E> extends IListBase<E> {
    void add(E object);
    E get();
    void remove(E object) throws ListElementNotFound, ListUnderFlowException;

}
