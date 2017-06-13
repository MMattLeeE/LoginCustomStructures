package Util.MyDataStructures.Interfaces.List;

/**
 * Created by msl2420 on 6/12/2017.
 */
public interface IList<E> {
    void add(E object);
    void remove();
    void contains();
    boolean isEmpty();
    int size();
    E get();
    String toString();
    void reset();
}
