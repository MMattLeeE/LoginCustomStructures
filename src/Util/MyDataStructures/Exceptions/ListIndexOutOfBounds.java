package Util.MyDataStructures.Exceptions;

/**
 * Created by Matt on 6/14/2017.
 * ListIndexOutOfBounds is the general exception for when an index that doesn't exist in a list instance is used as an argument
 */
public class ListIndexOutOfBounds extends Exception{
    /**
     * Calls the super class Exception's constructor for a string.
     * @param
     * msg The message that is output when an error occurs.
     */
    public ListIndexOutOfBounds(String msg) {
        super(msg);
    }
}
