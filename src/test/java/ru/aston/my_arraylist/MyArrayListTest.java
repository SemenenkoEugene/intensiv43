package ru.aston.my_arraylist;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

class MyArrayListTest {

    MyArrayList<Integer> testList = new MyArrayList<>();

    @Test
    void testConstructorWithNegativeCapacity() {
        assertThrows(IllegalArgumentException.class, () -> new MyArrayList<>(-1));
    }

    @Test
    void testAdd_allValid() {
        testList.add(0, 1);
        testList.add(1, 2);
        assertEquals(2, testList.size());
    }

    @Test
    void testAdd_indexNegative() {
        assertThrows(IndexOutOfBoundsException.class, () -> testList.add(-1, 0));
    }

    @Test
    void testAdd_indexOutSize() {
        assertThrows(IndexOutOfBoundsException.class, () -> testList.add(999, 1));
    }

    @Test
    void testAddAll_allValid() {
        testList.add(0, 1);
        Collection<Integer> collection = new ArrayList<>();
        collection.add(1);
        collection.add(2);
        testList.addAll(collection);
        assertEquals(3, testList.size());
    }

    @Test
    void testClear() {
        testList.add(0, 1);
        assertEquals(1, testList.size());

        testList.clear();
        assertEquals(0, testList.size());
    }

    @Test
    void testGet_allValid() {
        testList.add(0, 1);
        testList.add(1, 2);

        int actual1 = testList.get(0);
        int actual2 = testList.get(1);

        assertEquals(1, actual1);
        assertEquals(2, actual2);
    }

    @Test
    void testGet_indexNegative() {
        assertThrows(IndexOutOfBoundsException.class, () -> testList.get(-1));
    }

    @Test
    void testGet_indexOutSize() {
        assertThrows(IndexOutOfBoundsException.class, () -> testList.get(999));
    }

    @Test
    void testIsEmptyTrue() {
        assertTrue(testList.isEmpty());
    }

    @Test
    void testIsEmptyFalse() {
        testList.add(0, 1);
        assertFalse(testList.isEmpty());
    }

    @Test
    void testRemoveIndex_allValid() {
        testList.add(0, 0);
        testList.add(1, 1);
        assertEquals(2, testList.size());

        testList.remove(0);
        assertEquals(1, testList.size());

        int actual = testList.get(0);
        assertEquals(1, actual);
    }

    @Test
    void testRemoveIndex_indexNegative() {
        testList.add(0, 0);
        testList.add(1, 1);
        assertEquals(2, testList.size());

        assertThrows(IndexOutOfBoundsException.class, () -> testList.remove(-1));
    }

    @Test
    void testRemoveIndex_indexOutSize() {
        testList.add(0, 0);
        testList.add(1, 1);
        assertEquals(2, testList.size());

        assertThrows(IndexOutOfBoundsException.class, () -> testList.remove(2));
        assertThrows(IndexOutOfBoundsException.class, () -> testList.remove(999));
    }

    @Test
    void testRemoveElement_allValid() {
        testList.add(0, 0);
        testList.add(1, 4);
        assertEquals(2, testList.size());

        int removeElement = 4;
        testList.removeElement(removeElement);
        assertEquals(1, testList.size());
        assertNull(testList.get(1));
    }

    @Test
    void testRemoveElement_ifElementNotFound() {
        testList.add(0, 0);
        testList.add(1, 4);
        assertEquals(2, testList.size());

        int removeElement = 3;
        testList.removeElement(removeElement);
        assertEquals(2, testList.size());
    }

    @Test
    void testSize() {
        testList.add(0, 0);
        testList.add(1, 4);
        assertEquals(2, testList.size());
    }
}