package Util.MyDataStructures.Interfaces;

/**
 * Created by Matt on 6/11/2017.
 */
public interface iStack <E>{
    E push();
    E pop();
    E top();
    boolean isEmpty();
    int size();
    String toString();

}
