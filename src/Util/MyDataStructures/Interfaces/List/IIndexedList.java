package Util.MyDataStructures.Interfaces.List;

/**
 * Created by Matt on 6/11/2017.
 */
public interface IIndexedList<E> extends IList<E>{
    void set();
    int indexOf(E object);
}
