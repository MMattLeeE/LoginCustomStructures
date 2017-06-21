package Util.MyDataStructures.Exceptions;

/**
 * Created by Matt on 6/13/2017.
 * QueueOverFlowException is thrown when adding an element to a full queue
 */
public class QueueOverFlowException extends Exception {
    /**
     * Calls the super class Exception's constructor for a string.
     * @param
     * msg The message that is output when an error occurs.
     */
    public QueueOverFlowException(String msg) {
        super(msg);
    }
}
