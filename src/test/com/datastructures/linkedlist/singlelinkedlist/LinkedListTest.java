package com.datastructures.linkedlist.singlelinkedlist;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
// import test

/**
 * Tester class for Singly Linked List.
 */
class LinkedListTest {
    LinkedList<Integer> list;
    LinkedList<Integer> emptyList;
    Integer[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    Integer[] emptyArr = {};

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        list = new LinkedList<>(arr);
        emptyList = new LinkedList<>(emptyArr);
    }

    @Test
    @DisplayName("Test for isEmpty()")
    void isEmpty() {
        assertFalse(list.isEmpty());
    }

    @Test
    @DisplayName("Test for getSize()")
    void getSize() {
        assertEquals(10, list.getSize());
    }

    @Test
    @DisplayName("Test for addLast()")
    void addLast() {
        list.addLast(11);
        assertEquals(11, list.getSize());
        assertEquals(11, list.getTail().getData());

        emptyList.addLast(11);
        assertEquals(1, emptyList.getSize());
        assertEquals(11, emptyList.getHead().getData());
        assertEquals(11, emptyList.getTail().getData());
    }

    @Test
    @DisplayName("Test for addFirst()")
    void addFirst() {
        list.addFirst(11);
        assertEquals(11, list.getSize());
        assertEquals(11, list.getHead().getData());

        emptyList.addFirst(11);
        assertEquals(1, emptyList.getSize());
        assertEquals(11, emptyList.getHead().getData());
        assertEquals(11, emptyList.getTail().getData());
    }

    @Test
    @DisplayName("Test for addAt()")
    void addAt() {
        list.addAt(11, 0);
        assertEquals(11, list.getSize());
        assertEquals(11, list.getHead().getData());

        list.addAt(15, 1);
        assertEquals(15, list.getHead().getNext().getData());
        assertEquals(11, list.getHead().getData());

        list.addAt(20, list.getSize());
        assertEquals(20, list.getTail().getData());

        assertEquals(13, list.getSize());
    }

    @Test
    @DisplayName("Test for addAfter()")
    void AddAfter() {
        list.addAfter(11, 1);
        assertEquals(1, list.getData(0));
        assertEquals(11, list.getData(1));
        assertEquals(2, list.getData(2));
        assertEquals(11, list.getSize());
    }


    @Test
    @DisplayName("Test for deleteFirst()")
    void deleteFirst() {
        list.deleteFirst();
        assertEquals(9, list.getSize());
        assertEquals(2, list.getHead().getData());

        assertThrows(IllegalStateException.class, () -> emptyList.deleteFirst());
    }

    @Test
    @DisplayName("Test for deleteLast()")
    void deleteLast() {
        list.deleteLast();
        assertEquals(9, list.getSize());
        assertEquals(9, list.getTail().getData());

        assertThrows(IllegalStateException.class, () -> emptyList.deleteLast());
    }

    @Test
    @DisplayName("Test for deleteAt()")
    void deleteAt() {
        list.deleteAt(1);
        assertEquals(9, list.getSize());
        assertEquals(3, list.getData(1));

        assertThrows(IndexOutOfBoundsException.class, () -> list.deleteAt(10));
    }

    @Test
    @DisplayName("Test for getData()")
    void getData() {
        assertEquals(1, list.getData(0));
        assertEquals(2, list.getData(1));
        assertEquals(3, list.getData(2));
        assertEquals(4, list.getData(3));
        assertEquals(5, list.getData(4));
        assertEquals(6, list.getData(5));
        assertEquals(7, list.getData(6));
        assertEquals(8, list.getData(7));
        assertEquals(9, list.getData(8));
        assertEquals(10, list.getData(9));

        assertThrows(IndexOutOfBoundsException.class, () -> list.getData(10));
    }

    @Test
    @DisplayName("Test for setData()")
    void setData() {
        list.setData(0, 11);
        assertEquals(11, list.getData(0));

        assertThrows(IndexOutOfBoundsException.class, () -> list.setData(10, 11));
    }

    @Test
    @DisplayName("Test for getIndex()")
    void getIndex() {
        assertEquals(0, list.getIndex(1));
        assertEquals(1, list.getIndex(2));
        assertEquals(2, list.getIndex(3));
        assertEquals(7, list.getIndex(8));
        assertEquals(9, list.getIndex(10));

        assertEquals(-1, list.getIndex(0));
        assertEquals(-1, list.getIndex(11));
    }

    @Test
    @DisplayName("Test for the overloaded iterator()")
    void iterator() {
        int i = 0;
        for (Integer j : list) {
            assertEquals(arr[i++], j);
        }
    }

    @Test
    @DisplayName("Test for the toString()")
    void testToString() {
        assertEquals("[1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9 -> 10]", list.toString());

        emptyList.addLast(11);
        assertEquals("[11]", emptyList.toString());
    }

    @Test
    @DisplayName("Test for the equals()")
    void testEquals() {
        LinkedList<Integer> list2 = new LinkedList<>(arr);
        assertTrue(list.equals(list2));
        assertFalse(list.equals(emptyList));

        Integer [] arr2 = {1, 2, 3, 4, 5, 45, 7, 8, 9, 10};
        LinkedList<Integer> list3 = new LinkedList<>(arr2);
        assertFalse(list.equals(list3));
    }

    @Test
    @DisplayName("Test for the reverse methods, both iterative and recursive")
    void testReverse() {
        list.reverseIterative();
        assertEquals("[10 -> 9 -> 8 -> 7 -> 6 -> 5 -> 4 -> 3 -> 2 -> 1]", list.toString());

        list.reverseRecursive();
        assertEquals("[1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9 -> 10]", list.toString());
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        list = null;
    }
}