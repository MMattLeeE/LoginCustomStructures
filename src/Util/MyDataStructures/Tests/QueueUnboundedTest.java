package Util.MyDataStructures.Tests;

import Model.User;
import Util.MyDataStructures.Exceptions.QueueUnderFlowException;
import Util.MyDataStructures.Implementations.Queue.QueueUnbounded;
import Util.MyDataStructures.Implementations.Stack.StackUnbounded;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

/**
 * Created by Matt on 6/13/2017.
 */
public class QueueUnboundedTest {

    QueueUnbounded<String> testQueue = new QueueUnbounded<>();

    String node1 = "node1";
    String node2 = "node2";
    String node3 = "node3";
    String node4 = "node4";

    String test1 ="empty";
    String test2 ="empty";
    String test3 ="empty";
    String test4 ="empty";

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void enqueue() throws Exception {
        testQueue.enqueue(node1);
        testQueue.enqueue(node2);
        testQueue.enqueue(node3);
        testQueue.enqueue(node4);

        assertEquals(node1, testQueue.dequeue());
        assertEquals(node2, testQueue.dequeue());
        assertEquals(node3, testQueue.dequeue());
        assertEquals(node4, testQueue.dequeue());
    }

    @Test
    public void dequeue() throws Exception{
        testQueue.enqueue(node1);
        testQueue.enqueue(node2);
        testQueue.enqueue(node3);
        testQueue.enqueue(node4);

        test1 = testQueue.dequeue();
        test2 = testQueue.dequeue();
        test3 = testQueue.dequeue();
        test4 = testQueue.dequeue();

        assertEquals(node1, test1);
        assertEquals(node2, test2);
        assertEquals(node3, test3);
        assertEquals(node4, test4);
    }

    @Test
    public void isEmpty() throws Exception{
        assertEquals(true,testQueue.isEmpty());
        testQueue.enqueue(node1);
        assertEquals(false,testQueue.isEmpty());
    }

    @Test
    public void size()throws Exception{
        assertEquals(0,testQueue.size());
        testQueue.enqueue(node1);
        assertEquals(1,testQueue.size());
        testQueue.enqueue(node2);
        assertEquals(2,testQueue.size());
        testQueue.enqueue(node3);
        assertEquals(3,testQueue.size());

    }

    @Test
    public void enqueueDequeue() throws Exception{
        testQueue.enqueue(node1);
        testQueue.enqueue(node2);

        test1 = (String) testQueue.dequeue();

        testQueue.enqueue(node3);;

        test2 = testQueue.dequeue();
        test3 = testQueue.dequeue();

        assertEquals(node1,test1);
        assertEquals(node2,test2);
        assertEquals(node3,test3);
    }

    @Test
    public void oneNode() throws Exception{
        testQueue.enqueue(node1);

        test1 = testQueue.dequeue();

        assertEquals(node1,test1);
    }

    @Test
    public void dequeueUnderflow() throws QueueUnderFlowException{
        thrown.expect(QueueUnderFlowException.class);
        testQueue.dequeue();

    }

    @Test
    public void toStringTest() {
        StackUnbounded testStack = new StackUnbounded();

        User user1 = new User("test1");
        User user2 = new User("test2");

        testStack.push(user1);

        assertEquals(" " + user1.toString() + "\n",testStack.toString());

        testStack.push(user2);
        assertEquals(" " + user2.toString() + "\n" + " " + user1.toString() + "\n", testStack.toString());

    }
}