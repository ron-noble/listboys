package com.deliveryninja;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.*;

public class CustomListTest {

    @Test
    public void givenEmptyList_whenIsEmpty_thenTrueIsReturned() {
        List<Object> list = new CustomList<>();

        assertTrue(list.isEmpty());
    }

    @Test
    public void givenNonEmptyList_whenIsEmpty_thenFalseIsReturned() {
        List<Object> list = new CustomList<>();
        list.add(null);

        assertFalse(list.isEmpty());
    }

    @Test
    public void givenListWithAnElement_whenSize_thenOneIsReturned() {
        List<Object> list = new CustomList<>();
        list.add(null);

        assertEquals(1, list.size());
    }

    @Test
    public void givenListWithAnElement_whenGet_thenThatElementIsReturned() {
        List<Object> list = new CustomList<>();
        list.add("icon4life");
        Object element = list.get(0);

        assertEquals("icon4life", element);
    }

    @Test
    public void givenEmptyList_whenElementIsAdded_thenGetReturnsThatElement() {
        List<Object> list = new CustomList<>();
        boolean succeeded = list.add(null);

        assertTrue(succeeded);
    }

    @Test
    public void givenListWithAnElement_whenAnotherIsAdded_thenGetReturnsBoth() {
        List<Object> list = new CustomList<>();
        list.add("icon4life");
        list.add(".com");
        Object element1 = list.get(0);
        Object element2 = list.get(1);

        assertEquals("icon4life", element1);
        assertEquals(".com", element2);
    }

    @Test
    public void whenAddToSpecifiedIndex_thenExceptionIsThrown() {
        CustomList<Object> objects = new CustomList<>();
        objects.add(0, null);
        assertFalse(objects.isEmpty());
        assertEquals(objects.size(), 1);
        assertEquals(objects.get(0), null);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void whenAddAllToTheEnd_thenExceptionIsThrown() {
        Collection<Object> collection = new ArrayList<>();
        List<Object> list = new CustomList<>();
        list.addAll(collection);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void whenAddAllToSpecifiedIndex_thenExceptionIsThrown() {
        Collection<Object> collection = new ArrayList<>();
        List<Object> list = new CustomList<>();
        list.addAll(0, collection);
    }

    @Test
    public void whenRemoveAtSpecifiedIndex_thenExceptionIsThrown() {
        List<Object> list = new CustomList<>();
        list.add("icon4life");
        list.remove(0);
        assertTrue(list.isEmpty());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void whenRemoveSpecifiedElement_thenExceptionIsThrown() {
        List<Object> list = new CustomList<>();
        list.add("icon4life");
        list.remove("icon4life");
    }

    @Test
    public void whenRemoveAll_thenExceptionIsThrown() {
        Collection<Object> collection = new ArrayList<>();
        collection.add("icon4life");
        List<Object> list = new CustomList<>();
        list.add("icon4life");
        list.add("yes!");
        boolean removed = list.removeAll(collection);
        assertTrue(removed);
        assertArrayEquals(list.toArray(), collection.toArray());
        assertEquals(1, list.size());
        assertEquals("yes!", list.get(0));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void whenRetainAll_thenExceptionIsThrown() {
        Collection<Object> collection = new ArrayList<>();
        collection.add("icon4life");
        List<Object> list = new CustomList<>();
        list.add("icon4life");
        list.retainAll(collection);
    }

    @Test
    public void givenEmptyList_whenContains_thenFalseIsReturned() {
        List<Object> list = new CustomList<>();

        assertFalse(list.contains(null));
    }

    @Test
    public void givenListWithAnElement_whenContains_thenTrueIsReturned() {
        List<Object> list = new CustomList<>();
        list.add("icon4life");

        assertTrue(list.contains("icon4life"));
    }

    @Test
    public void givenListWithAnElement_whenContainsAll_thenTrueIsReturned() {
        Collection<Object> collection = new ArrayList<>();
        collection.add("icon4life");
        List<Object> list = new CustomList<>();
        list.add("icon4life");

        assertTrue(list.containsAll(collection));
    }

    @Test
    public void givenList_whenContainsAll_thenEitherTrueOrFalseIsReturned() {
        Collection<Object> collection1 = new ArrayList<>();
        collection1.add("icon4life");
        collection1.add(".com");
        Collection<Object> collection2 = new ArrayList<>();
        collection2.add("icon4life");

        List<Object> list = new CustomList<>();
        list.add("icon4life");

        assertFalse(list.containsAll(collection1));
        assertTrue(list.containsAll(collection2));
    }

    @Test
    public void givenList_whenSet_thenOldElementIsReturned() {
        List<Object> list = new CustomList<>();
        list.add("icon4life");
        Object element = list.set(0, null);

        assertEquals("icon4life", element);
        assertNull(list.get(0));
    }

    @Test
    public void givenList_whenClear_thenAllElementsAreRemoved() {
        List<Object> list = new CustomList<>();
        list.add("icon4life");
        list.clear();

        assertTrue(list.isEmpty());
    }

    @Test
    public void givenList_whenIndexOf_thenIndexZeroIsReturned() {
        List<Object> list = new CustomList<>();
        list.add("icon4life");

        assertEquals(0, list.indexOf("icon4life"));
    }

    @Test
    public void givenList_whenIndexOf_thenPositiveIndexOrMinusOneIsReturned() {
        List<Object> list = new CustomList<>();
        list.add("icon4life");
        list.add(".com");
        list.add(".com");

        assertEquals(1, list.indexOf(".com"));
        assertEquals(-1, list.indexOf("com"));
    }

    @Test
    public void whenLastIndexOf_thenIndexZeroIsReturned() {
        List<Object> list = new CustomList<>();
        list.add("icon4life");

        assertEquals(0, list.lastIndexOf("icon4life"));
    }

    @Test
    public void whenLastIndexOf_thenPositiveIndexOrMinusOneIsReturned() {
        List<Object> list = new CustomList<>();
        list.add("icon4life");
        list.add("icon4life");
        list.add(".com");

        assertEquals(1, list.lastIndexOf("icon4life"));
        assertEquals(-1, list.indexOf("com"));
    }

    @Test
    public void whenSubListZeroToOne_thenListContainingFirstElementIsReturned() {
        List<Object> list = new CustomList<>();
        list.add("icon4life");
        List<Object> subList = list.subList(0, 1);

        assertEquals("icon4life", subList.get(0));
    }

    @Test
    public void whenSubListOneToTwo_thenListContainingSecondElementIsReturned() {
        List<Object> list = new CustomList<>();
        list.add("icon4life");
        list.add(".");
        list.add("com");
        List<Object> subList = list.subList(1, 2);

        assertEquals(1, subList.size());
        assertEquals(".", subList.get(0));
    }

    @Test
    public void givenListWithElements_whenToArray_thenArrayContainsThose() {
        List<Object> list = new CustomList<>();
        list.add("icon4life");
        list.add(".com");
        Object[] array = list.toArray();

        assertArrayEquals(new Object[] { "icon4life", ".com" }, array);
    }

    @Test
    public void givenListWithAnElement_whenToArray_thenInputArrayIsReturned() {
        List<Object> list = new CustomList<>();
        list.add("icon4life");
        String[] input = new String[1];
        String[] output = list.toArray(input);

        assertArrayEquals(new String[] { "icon4life" }, input);
    }

    @Test
    public void whenToArrayIsCalledWithEmptyInputArray_thenNewArrayIsReturned() {
        List<Object> list = new CustomList<>();
        list.add("icon4life");
        String[] input = {};
        String[] output = list.toArray(input);

        assertArrayEquals(new String[] { "icon4life" }, output);
    }

    @Test
    public void whenToArrayIsCalledWithLargerInput_thenOutputHasTrailingNull() {
        List<Object> list = new CustomList<>();
        list.add("icon4life");
        String[] input = new String[2];
        String[] output = list.toArray(input);

        assertArrayEquals(new String[] { "icon4life", null }, output);
    }

    @Test
    public void givenListWithOneElement_whenIterator_thenThisElementIsNext() {
        List<Object> list = new CustomList<>();
        list.add("icon4life");
        Iterator<Object> iterator = list.iterator();

        assertTrue(iterator.hasNext());
        assertEquals("icon4life", iterator.next());
    }

    @Test
    public void whenIteratorHasNextIsCalledTwice_thenTheSecondReturnsFalse() {
        List<Object> list = new CustomList<>();
        list.add("icon4life");
        Iterator<Object> iterator = list.iterator();

        iterator.next();
        assertFalse(iterator.hasNext());
    }
}
