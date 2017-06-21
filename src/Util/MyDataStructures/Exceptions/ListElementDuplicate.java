package Util.MyDataStructures.Exceptions;

/**
 * ListElementDuplicate is the general exception for when an element already exists in the List.
 */
public class ListElementDuplicate extends Exception {
    /**
     * Calls the super class Exception's constructor for a string.
     * @param
     * msg The message that is output when an error occurs.
     */
    public ListElementDuplicate(String msg) {
        super(msg);
    }
}
