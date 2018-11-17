package DataStructures.Lists;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayListTest {

    private ArrayList emptyList;
    private ArrayList singleItemList;
    private ArrayList nonEmptyList;

    @Before
    public void setUp() throws Exception {
        emptyList = new ArrayList(0);
        singleItemList = new ArrayList(1);
        nonEmptyList = new ArrayList();

        singleItemList.add(1);
        nonEmptyList.add(1);
        nonEmptyList.add(2);
        nonEmptyList.add(3);
        nonEmptyList.add(4);

    }

    @Test
    public void add() {
        assertEquals(0, emptyList.size());
        emptyList.add(1);
        assertEquals(1, emptyList.size());
        emptyList.add(2);
        assertEquals(2, emptyList.size());
        emptyList.add(3);
        assertEquals(3, emptyList.size());
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

        assertEquals(1, singleItemList.size());
        singleItemList.remove(0);
        assertEquals(0, singleItemList.size());
        assertEquals(4, nonEmptyList.size());
        nonEmptyList.remove(3);
        assertEquals(3, nonEmptyList.size());
    }

    @Test()
    public void get() {
        try {
            emptyList.get(-1);
            fail("IndexOutOfBoundsException not thrown");
        } catch(IndexOutOfBoundsException e){}
        try {
            emptyList.get(0);
            fail("IndexOutOfBoundsException not thrown");
        } catch(IndexOutOfBoundsException e){}

        try{
            singleItemList.get(3);
            fail("IndexOutOfBoundsException not thrown");
        } catch (IndexOutOfBoundsException e){}

        assertEquals(1, singleItemList.get(0));
        assertEquals(4, nonEmptyList.get(3));
    }

    @Test
    public void clear() {
        assertEquals(0, emptyList.size());
        emptyList.clear();
        assertEquals(0, emptyList.size());
        assertEquals(1, singleItemList.size());
        singleItemList.clear();
        assertEquals(0, singleItemList.size());
        assertEquals(4, nonEmptyList.size());
        nonEmptyList.clear();
        assertEquals(0, nonEmptyList.size());
    }

    @Test
    public void size() {
        assertEquals(0, emptyList.size());
        assertEquals(1, singleItemList.size());
        assertEquals(4, nonEmptyList.size());
    }
}