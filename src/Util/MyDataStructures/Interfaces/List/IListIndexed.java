package Util.MyDataStructures.Interfaces.List;

import Util.MyDataStructures.Exceptions.ListElementNotFound;
import Util.MyDataStructures.Exceptions.ListIndexOutOfBounds;
import Util.MyDataStructures.Exceptions.ListUnderFlowException;

/**
 * Created by Matt on 6/11/2017.
 */
public interface IListIndexed<E> extends IListBase<E> {
    void add(E object);
    void add(int index, E object) throws ListIndexOutOfBounds;
    void set(int index, E object) throws ListIndexOutOfBounds;
    E get(int index) throws ListIndexOutOfBounds;
    int indexOf(E object) throws ListElementNotFound;
    void remove(int index) throws ListElementNotFound, ListUnderFlowException;

}
