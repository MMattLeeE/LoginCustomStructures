package Util.MyDataStructures.Tests;

import Util.MyDataStructures.Implementations.NodeIndexed;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Matt on 6/19/2017.
 */
public class NodeIndexedTest {
    NodeIndexed<String> testNode1 = new NodeIndexed<>("test1");
    NodeIndexed<String> testNode2 = new NodeIndexed<>("test2");
    NodeIndexed<String> testNode3 = new NodeIndexed<>("test3");


    @Test
    public void linkTo() throws Exception {
        System.out.println(testNode1.toString());
        System.out.println(testNode2.toString());
        System.out.println(testNode3.toString());
        System.out.println();

        testNode1.linkTo(testNode2);
        System.out.println(testNode1.toString());
        System.out.println(testNode2.toString());
        System.out.println();

        testNode2.linkTo(testNode3);
        System.out.println(testNode1.toString());
        System.out.println(testNode2.toString());
        System.out.println(testNode3.toString());
        System.out.println();

        assertEquals(testNode1,testNode2.getLeft());
        assertEquals(testNode2,testNode1.getRight());
        assertEquals(testNode3,testNode2.getRight());
    }

}