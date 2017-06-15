package Util.MyDataStructures.Tests;

import Util.MyDataStructures.Exceptions.QueueOverFlowException;
import Util.MyDataStructures.Implementations.Queue.QueueBounded;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

/**
 * Created by Matt on 6/14/2017.
 */
public class QueueBoundedTest {
    QueueBounded<String> testQueue = new QueueBounded<>();

    String node1 = "node1";
    String node2 = "node2";
    String node3 = "node3";
    String node4 = "node4";

    String test1 = "empty";
    String test2 = "empty";
    String test3 = "empty";
    String test4 = "empty";

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void enqueue()throws Exception{
        testQueue.enqueue(node1);
        testQueue.enqueue(node2);
        testQueue.enqueue(node3);
        testQueue.enqueue(node4);

        test1 = testQueue.dequeue();
        test2 = testQueue.dequeue();
        test3 = testQueue.dequeue();

        assertEquals(node1,test1);
        assertEquals(node2,test2);
        assertEquals(node3,test3);
    }

    @Test
    public void enqueueOverFlowTest() throws QueueOverFlowException {
        thrown.expect(QueueOverFlowException.class);
            testQueue.enqueue(node1);
            testQueue.enqueue(node1);
            testQueue.enqueue(node1);
            testQueue.enqueue(node1);
            testQueue.enqueue(node1);
    }

    @Test
    public void isFull() throws Exception {
        testQueue.enqueue(node1);
        testQueue.enqueue(node1);
        testQueue.enqueue(node1);
        testQueue.enqueue(node1);

        assertEquals(true,testQueue.isFull());
    }

}