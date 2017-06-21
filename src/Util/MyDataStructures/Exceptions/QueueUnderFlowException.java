package Util.MyDataStructures.Exceptions;

/**
 * Created by Matt on 6/13/2017.
 * Thrown when attempting to dequeue an empty queue.
 */
public class QueueUnderFlowException extends Exception {
    /**
     * Calls the super class Exception's constructor for a string.
     * @param
     * msg The message that is output when an error occurs.
     */
    public QueueUnderFlowException(String msg){
        super(msg);
    }
}
