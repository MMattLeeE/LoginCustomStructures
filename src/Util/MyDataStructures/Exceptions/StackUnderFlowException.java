package Util.MyDataStructures.Exceptions;

/**
 * Created by Matt on 6/14/2017.
 * Thrown when attempting to pop an empty stack.
 */
public class StackUnderFlowException extends Exception{
    /**
     * Calls the super class Exception's constructor for a string.
     * @param
     * msg The message that is output when an error occurs.
     */
    public StackUnderFlowException(String msg){
        super(msg);
    }
}
