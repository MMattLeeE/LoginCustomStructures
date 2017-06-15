package Util.MyDataStructures.Interfaces.List;

/**
 * Created by Matt on 6/11/2017.
 */
public interface IListOrdered<E> extends IListBase<E> {
    void add(E object);
    E getNext();
}
