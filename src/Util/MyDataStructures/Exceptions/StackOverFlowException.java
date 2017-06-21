package Util.MyDataStructures.Exceptions;

/**
 * Created by Matt on 6/14/2017.
 * Thrown when pushing onto a full stack.
 */
public class StackOverFlowException extends Exception {
    /**
     * Calls the super class Exception's constructor for a string.
     * @param
     * msg The message that is output when an error occurs.
     */
    public StackOverFlowException(String msg) {
        super(msg);
    }
}
