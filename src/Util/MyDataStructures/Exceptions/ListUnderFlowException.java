package Util.MyDataStructures.Exceptions;

/**
 * Created by Matt on 6/14/2017.
 * ListUnderFlowException is the general exception for when a list is empty and a removal action is being attempted on the list.
 */
public class ListUnderFlowException extends Exception {
    /**
     * Calls the super class Exception's constructor for a string.
     * @param
     * msg The message that is output when an error occurs.
     */
    public ListUnderFlowException(String msg) {
        super(msg);
    }
}
