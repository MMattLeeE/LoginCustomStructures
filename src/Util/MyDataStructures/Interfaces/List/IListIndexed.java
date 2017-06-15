package Util.MyDataStructures.Interfaces.List;

/**
 * Created by Matt on 6/11/2017.
 */
public interface IListIndexed<E> extends IListBase<E> {
    void add(E object);
    void add(int index, E object);
    void set(int index, E object);
    int indexOf(E object);
}
