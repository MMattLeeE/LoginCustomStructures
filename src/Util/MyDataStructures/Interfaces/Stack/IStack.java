package Util.MyDataStructures.Interfaces.Stack;

/**
 * Created by Matt on 6/11/2017.
 */
public interface IStack<E>{
    E push(E object);
    E pop();
    E top();
    boolean isEmpty();
    int size();
    String toString();

}
