package Util.MyDataStructures.Tests;

import Util.MyDataStructures.Implementations.List.ListOrdered;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Matt on 6/21/2017.
 */
public class ListOrderedTest {
    ListOrdered<String> testOrderedList = new ListOrdered<>();
    String test1 = "a";
    String test2 = "b";
    String test3 = "c";
    String test4 = "d";
    String test5 = "e";
    String test6 = "f";
    String test7 = "g";

    public void insertOrderedElements() throws Exception{
        testOrderedList.add(test1);
        testOrderedList.add(test2);
        testOrderedList.add(test3);
        testOrderedList.add(test4);
        testOrderedList.add(test5);
        testOrderedList.add(test6);
        testOrderedList.add(test7);

    }

    @Test
    public void add() throws Exception {
        testOrderedList.add(test1);
        testOrderedList.add(test3);
        testOrderedList.add(test7);
        testOrderedList.add(test5);
        testOrderedList.add(test2);
        testOrderedList.add(test4);
        testOrderedList.add(test6);

        //System.out.println(testOrderedList.toString());
        testOrderedList.reset();
        assertEquals(test2,testOrderedList.getNext());
        assertEquals(test3,testOrderedList.getNext());
    }

    @Test
    public void get() throws Exception {
        insertOrderedElements();

        assertEquals(test1,testOrderedList.get(test1));
    }

    @Test
    public void remove() throws Exception {
        insertOrderedElements();

        testOrderedList.remove(test1);
        assertEquals(6,testOrderedList.size());
        assertEquals(false,testOrderedList.contains(test1));
    }

}