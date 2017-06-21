package Util.MyDataStructures.Tests;

import Util.MyDataStructures.Exceptions.ListIndexOutOfBounds;
import Util.MyDataStructures.Implementations.List.ListIndexed;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

/**
 * Created by Matt on 6/20/2017.
 */
public class ListIndexedTest {

    ListIndexed<String> testListIndexed = new ListIndexed<>();

    String test1 = "test1";
    String test2 = "test2";
    String test3 = "test3";
    String test4 = "test4";
    String test5 = "test5";
    String test6 = "test6";
    String test7 = "test7";
    String test8 = "test8";
    String test9 = "test9";

    public void insertTestListItems() throws Exception{
        testListIndexed.add(test1);
        testListIndexed.add(test2);
        testListIndexed.add(test3);
        testListIndexed.add(test4);
        testListIndexed.add(test5);
        testListIndexed.add(test6);
        testListIndexed.add(test7);
        testListIndexed.add(test8);
        testListIndexed.add(test9);
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void addTest() throws Exception {
        insertTestListItems();
        System.out.println(testListIndexed.toString());
        String front = testListIndexed.getFront();
        String back = testListIndexed.getBack();

        assertEquals("test1",front);
        assertEquals("test9",back);

    }

    @Test
    public void addWithIndexTest() throws Exception {
        insertTestListItems();

        System.out.println("Inserting at index: 0");
        String insertElement0 = "index0";
        testListIndexed.add(0,insertElement0);
        System.out.println(testListIndexed.toString());
        System.out.println();
        assertEquals("index0",testListIndexed.get(0));
        assertEquals(10,testListIndexed.size());
        assertEquals("index0",testListIndexed.getFront());
        assertEquals("test9",testListIndexed.getBack());

        System.out.println("Inserting at index: 1");
        String insertElement1 = "index1";
        testListIndexed.add(1,insertElement1);
        System.out.println(testListIndexed.toString());
        System.out.println();
        assertEquals("index1",testListIndexed.get(1));
        assertEquals(11,testListIndexed.size());
        assertEquals("index0",testListIndexed.getFront());
        assertEquals("test9",testListIndexed.getBack());

        System.out.println("Inserting at index: 3");
        String insertElement3 = "index3";
        testListIndexed.add(3,insertElement3);
        System.out.println(testListIndexed.toString());
        System.out.println();
        assertEquals("index3",testListIndexed.get(3));
        assertEquals(12,testListIndexed.size());
        assertEquals("index0",testListIndexed.getFront());
        assertEquals("test9",testListIndexed.getBack());

        System.out.println("Inserting at index: 8");
        String insertElement8 = "index8";
        testListIndexed.add(8,insertElement8);
        System.out.println(testListIndexed.toString());
        System.out.println();
        assertEquals("index8",testListIndexed.get(8));
        assertEquals(13,testListIndexed.size());
        assertEquals("index0",testListIndexed.getFront());
        assertEquals("test9",testListIndexed.getBack());

        System.out.println("Inserting at index: 12");
        String insertElement12 = "index12";
        testListIndexed.add(12,insertElement12);
        System.out.println(testListIndexed.toString());
        System.out.println();
        assertEquals("index12",testListIndexed.get(12));
        assertEquals(14,testListIndexed.size());
        assertEquals("index0",testListIndexed.getFront());
        assertEquals("test9",testListIndexed.getBack());

        System.out.println("Inserting at index: 14");
        String insertElement14 = "index14";
        testListIndexed.add(14,insertElement14);
        System.out.println(testListIndexed.toString());
        System.out.println();
        assertEquals("index14",testListIndexed.get(14));
        assertEquals(15,testListIndexed.size());
        assertEquals("index0",testListIndexed.getFront());
        assertEquals("index14",testListIndexed.getBack());
    }

    @Test
    public void setTest() throws Exception {
        insertTestListItems();
        String test0 = "set0";
        String test1 = "set1";
        String test5 = "set5";
        String test8 = "set8";
        String output0 = testListIndexed.set(0,test0);
        String output1 = testListIndexed.set(1,test1);
        String output5 = testListIndexed.set(5,test5);
        String output8 = testListIndexed.set(8,test8);

        assertEquals(test0,testListIndexed.get(0));
        assertEquals(test1,testListIndexed.get(1));
        assertEquals(test5,testListIndexed.get(5));
        assertEquals(test8,testListIndexed.get(8));

        assertEquals("test1",output0);
        assertEquals("test2",output1);
        assertEquals("test6",output5);
        assertEquals("test9",output8);

        System.out.println(testListIndexed.toString());
    }

    @Test
    public void getExceptionTest() throws ListIndexOutOfBounds, Exception{
        insertTestListItems();
        thrown.expect(ListIndexOutOfBounds.class);
        testListIndexed.get(-1); //try index that is out of bounds

    }

    @Test
    public void getTest() throws Exception {
        insertTestListItems();
        String testReturn1 = testListIndexed.get(0); //get item at front of list
        String testReturn2 = testListIndexed.get(8); //get item at end of list
        String testReturn3 = testListIndexed.get(4); //get item at 4 index

        System.out.println();
        System.out.println("At index 0: " + testReturn1);
        System.out.println("At index 8: " + testReturn2);
        System.out.println("At index 4: " + testReturn3);

        assertEquals("test1",testReturn1);
        assertEquals("test9",testReturn2);
        assertEquals("test5",testReturn3);
    }

    @Test
    public void indexOfTest() throws Exception {
        insertTestListItems();

        int indexOut0 = testListIndexed.indexOf(test1);
        int indexOut4 = testListIndexed.indexOf(test5);
        int indexOut5 = testListIndexed.indexOf(test6);
        int indexOut8 = testListIndexed.indexOf(test9);

        assertEquals(0,indexOut0);
        assertEquals(4,indexOut4);
        assertEquals(5,indexOut5);
        assertEquals(8,indexOut8);
    }

    @Test
    public void removeIndexTest() throws Exception {
        insertTestListItems();
        System.out.println("original");
        System.out.println(testListIndexed.toString());

        String out0 = testListIndexed.remove(0);
        System.out.println("remove at index 0: ");
        System.out.println(testListIndexed.toString());

        String out1 = testListIndexed.remove(1);
        System.out.println("remove at index 1: ");
        System.out.println(testListIndexed.toString());

        String out4 = testListIndexed.remove(4);
        System.out.println("remove at index 4: ");
        System.out.println(testListIndexed.toString());

        String out5 = testListIndexed.remove(5);
        System.out.println("remove at last index: ");
        System.out.println(testListIndexed.toString());

        assertEquals("test1",out0);
        assertEquals("test3",out1);
        assertEquals("test7",out4);
        assertEquals("test9",out5);
    }

    @Test
    public void removeElementTest() throws Exception {
        insertTestListItems();

        boolean t1 = testListIndexed.remove("test1");
        System.out.println(testListIndexed.toString());

        boolean t2 = testListIndexed.remove("test3");
        System.out.println(testListIndexed.toString());

        boolean t3 = testListIndexed.remove("test7");
        System.out.println(testListIndexed.toString());

        boolean t4 = testListIndexed.remove("test9");
        System.out.println(testListIndexed.toString());

        assertEquals("test2",testListIndexed.get(0));
        assertEquals("test4",testListIndexed.get(1));
        assertEquals("test5",testListIndexed.get(2));
        assertEquals("test6",testListIndexed.get(3));
        assertEquals("test8",testListIndexed.get(4));

        assertEquals(true,t1);
        assertEquals(true,t2);
        assertEquals(true,t3);
        assertEquals(true,t4);

        System.out.println(testListIndexed.toString());
    }

    @Test
    public void containsTest() throws Exception {
        insertTestListItems();
        assertEquals(true,testListIndexed.contains("test1"));
        assertEquals(true,testListIndexed.contains("test4"));
        assertEquals(true,testListIndexed.contains("test9"));
        assertEquals(false,testListIndexed.contains("test12"));
    }

    @Test
    public void isEmptyTest() throws Exception {
        assertEquals(true,testListIndexed.isEmpty());

        testListIndexed.add("testtest");
        assertEquals(false,testListIndexed.isEmpty());
    }

    @Test
    public void sizeTest() throws Exception {
        insertTestListItems();
        testListIndexed.add("testAdd");
        assertEquals(10,testListIndexed.size());

        testListIndexed.add(3,"testIndexAdd");
        assertEquals(11,testListIndexed.size());

        testListIndexed.remove("testAdd");
        assertEquals(10,testListIndexed.size());

        testListIndexed.remove(3);
        assertEquals(9,testListIndexed.size());
    }

    @Test
    public void resetTest() throws Exception {
        insertTestListItems();

        testListIndexed.reset();
        assertEquals("test1",testListIndexed.getFront());
    }

    @Test
    public void getNextTest() throws Exception {
        insertTestListItems();
        System.out.println(testListIndexed.getPointerNode().toString());

        System.out.println(testListIndexed.toString());

        assertEquals("test2",testListIndexed.getNext());
        assertEquals("test3",testListIndexed.getNext());
    }
}