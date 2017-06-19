package Util.MyDataStructures.Tests;

import Model.User;
import Util.MyDataStructures.Exceptions.StackOverFlowException;
import Util.MyDataStructures.Implementations.Stack.StackBounded;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

/**
 * Created by Matt on 6/15/2017.
 */
public class StackBoundedTest {
    StackBounded<User> testStack = new StackBounded<>();

    User user1 = new User("test1");
    User user2 = new User("test2");
    User user3 = new User("test3");
    User user4 = new User("test4");

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void stackOverflowTest() throws StackOverFlowException {
        thrown.expect(StackOverFlowException.class);
        testStack.push(user1);
        testStack.push(user2);
        testStack.push(user3);
        testStack.push(user4);
        testStack.push(user1);
    }

    @Test
    public void push() throws Exception {
        testStack.push(user1);
        testStack.push(user2);
        testStack.push(user3);
        testStack.push(user4);

    }

    @Test
    public void isFull() throws Exception {
        testStack.push(user1);
        testStack.push(user1);
        testStack.push(user1);
        testStack.push(user1);

        assertEquals(true,testStack.isFull());
    }

}