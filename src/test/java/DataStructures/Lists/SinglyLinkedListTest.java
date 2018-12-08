package DataStructures.Lists;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SinglyLinkedListTest {

    private SinglyLinkedList emptyList;
    private SinglyLinkedList singleItemList;
    private SinglyLinkedList nonEmptyList;

    @Before
    public void setUp() throws Exception {
        emptyList = new SinglyLinkedList();
        singleItemList = new SinglyLinkedList(1);
        nonEmptyList = new SinglyLinkedList();

        nonEmptyList.add(1);
        nonEmptyList.add(2);
        nonEmptyList.add(3);
    }

    @Test
    public void add() {
        emptyList.add(1);
        assertEquals(1, emptyList.getSize());
        emptyList.add(Integer.MIN_VALUE);
        assertEquals(2, emptyList.getSize());

        assertEquals(1, singleItemList.getSize());
        singleItemList.add(2);
        assertEquals(2, singleItemList.getSize());
        singleItemList.add(Integer.MAX_VALUE);
        assertEquals(3, singleItemList.getSize());

        assertEquals(3, nonEmptyList.getSize());
        nonEmptyList.add(4);
        assertEquals(4, nonEmptyList.getSize());
    }

    @Test
    public void clear() {
        assertEquals(0, emptyList.getSize());
        emptyList.clear();
        assertEquals(0, emptyList.getSize());

        assertEquals(1, singleItemList.getSize());
        singleItemList.clear();
        assertEquals(0, singleItemList.getSize());

        assertEquals(3, nonEmptyList.getSize());
        nonEmptyList.clear();
        assertEquals(0, nonEmptyList.getSize());
    }

    @Test
    public void contains() {
        assertFalse(emptyList.contains(0));
        assertFalse(emptyList.contains(100));

        assertTrue(singleItemList.contains(1));
        assertFalse(singleItemList.contains(0));
        assertFalse(singleItemList.contains(Integer.MAX_VALUE));
        assertFalse(singleItemList.contains(Integer.MIN_VALUE));

        assertTrue(nonEmptyList.contains(1));
        assertTrue(nonEmptyList.contains(2));
        assertTrue(nonEmptyList.contains(3));
    }

    @Test
    public void get() {
        try{
            emptyList.get(0);
            fail("IndexOutOfBoundsException not thrown");
        } catch (IndexOutOfBoundsException e){}
        try{
            emptyList.get(-1);
            fail("IndexOutOfBoundsException not thrown");
        } catch (IndexOutOfBoundsException e){}
        try{
            singleItemList.get(3);
            fail("IndexOutOfBoundsException not thrown");
        } catch (IndexOutOfBoundsException e){}

        assertEquals(1, singleItemList.get(0));
        assertEquals(3, nonEmptyList.get(2));
    }

    @Test
    public void remove() {
        try{
            emptyList.remove(0);
            fail("IndexOutOfBoundsException not thrown");
        } catch (IndexOutOfBoundsException e){}
        try{
            emptyList.remove(-1);
            fail("IndexOutOfBoundsException not thrown");
        } catch (IndexOutOfBoundsException e){}
        try{
            singleItemList.remove(3);
            fail("IndexOutOfBoundsException not thrown");
        } catch (IndexOutOfBoundsException e){}

        assertEquals(1, singleItemList.getSize());
        singleItemList.remove(0);
        assertEquals(0, singleItemList.getSize());
        assertEquals(3, nonEmptyList.getSize());
        nonEmptyList.remove(2);
        assertEquals(2, nonEmptyList.getSize());
    }
}