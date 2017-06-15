package Util.MyDataStructures.Tests;

import Model.User;
import Util.MyDataStructures.Exceptions.StackUnderFlowException;
import Util.MyDataStructures.Implementations.Stack.StackUnbounded;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Matt on 6/14/2017.
 */
public class StackUnboundedTest {
    StackUnbounded<User> testStack = new StackUnbounded<>();

    User user1 = new User("test1");
    User user2 = new User("test2");
    User user3 = new User("test3");
    User user4 = new User("test4");

    @Test
    public void pushTest() throws Exception{
        testStack.push(user1);

        assertEquals(user1, testStack.top());

        testStack.push(user2);
        assertEquals(user2, testStack.top());

    }

    @Test
    public void pop() throws Exception {
        testStack.push(user1);
        testStack.pop();
        assertEquals(true,testStack.isEmpty());
        testStack.push(user1);
        testStack.push(user2);
        testStack.push(user3);
        testStack.pop();
        testStack.pop();
        assertEquals(user1,testStack.top());
    }

    @Test
    public void top() throws Exception {
        testStack.push(user1);
        assertEquals(user1,testStack.top());
        testStack.push(user2);
        assertEquals(user2,testStack.top());
        testStack.push(user3);
        assertEquals(user3,testStack.top());
        testStack.pop();
        assertEquals(user2,testStack.top());
    }

    @Test
    public void isEmpty() throws Exception {
        assertEquals(true,testStack.isEmpty());
        testStack.push(user1);
        assertEquals(false,testStack.isEmpty());
    }

    @Test
    public void size() throws Exception {
        assertEquals(0,testStack.size());
        testStack.push(user1);
        assertEquals(1,testStack.size());
        testStack.push(user2);
        assertEquals(2,testStack.size());
        testStack.push(user3);
        assertEquals(3,testStack.size());
        testStack.push(user4);
        assertEquals(4,testStack.size());
    }

    @Test
    public void toStringTest() throws Exception {
        testStack.push(user1);

        assertEquals(" " + user1.toString() + "\n",testStack.toString());

        testStack.push(user2);
        assertEquals(" " + user2.toString() + "\n" + " " + user1.toString() + "\n", testStack.toString());
    }

}