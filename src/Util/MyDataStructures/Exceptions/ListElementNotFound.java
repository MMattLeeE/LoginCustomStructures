package Util.MyDataStructures.Exceptions;

/**
 * Created by Matt on 6/14/2017.
 * ListElementNotFound is the general exception for when an element is not found in a list.
 */
public class ListElementNotFound extends Exception {
    /**
     * Calls the super class Exception's constructor for a string.
     * @param
     * msg The message that is output when an error occurs.
     */
    public ListElementNotFound(String msg) {
        super(msg);
    }
}
