package com.datastructures.linkedlist.singlelinkedlist;

import java.util.Iterator;
import java.util.Stack;

/**
 * Generic Singly Linked List class.
 * @param <T> Generic type.
 */
public class LinkedList <T> implements Iterable<T> {
    private Node<T> head = null;
    private Node<T> tail = null;
    private int size = 0;

    /**
     * Constructor for LinkedList.
     */
    public LinkedList() {

    }

    /**
     * Parameterized constructor for LinkedList class.
     * @param arr Array of elements to be added to the list.
     */
    public LinkedList(T[] arr) {
        for (T element : arr) {
            addLast(element);
        }
        size = arr.length;
    }

    /**
     * Getter for head.
     * @return head node.
     */
    public Node<T> getHead() {
        return head;
    }

    /**
     * Getter for tail.
     * @return tail node.
     */
    public Node<T> getTail() {
        return tail;
    }

    /**
     * Check if the list is empty.
     * @return true if list is empty, false otherwise.
     */
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * Getter for size.
     * @return size of the list.
     */
    public int getSize() {
        return size;
    }

    /**
     * Get the data at the given index.
     * @param index index of the data.
     *              valid index is 1-size to size - 1.
     *              if the index is negative then it is considered as size + index.
     * @return data at the given index.
     */
    public T getData(int index) {
        if (index <= -size || index >= size) throw new IndexOutOfBoundsException();
        if (index < 0 && index > -size) index = size + index;
        Node<T> current = head;
        for (int i = 0; i < index; i++) current = current.getNext();
        return current.getData();
    }

    /**
     * Get the index of the first occurrence of the given data.
     * @param data Data of the required node.
     * @return Index of the first occurrence of the given data.
     */
    public int getIndex(T data) {
        Node<T> current = head;
        for (int i = 0; i < size; i++) {
            if (current.getData().equals(data)) return i;
            current = current.getNext();
        }
        return -1;
    }

    /**
     * Set the data at the given index.
     * @param index index of the node to be returned.
     *              Valid indices are 0 to size.
     * @param data data to be stored in the node.
     */
    public void setData(int index, T data) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        Node<T> current = head;
        for (int i = 0; i < index; i++) current = current.getNext();
        current.setData(data);
    }

    /**
     * Add a new node to the end of the list.
     * @param data data to be stored in the node.
     */
    public void addLast(T data) {
        Node<T> newNode = new Node<>(data);
        if (isEmpty()) head = newNode;
        else tail.setNext(newNode);
        tail = newNode;
        size++;
    }

    /**
     * Add a new node to the beginning of the list.
     * @param data data to be stored in the node.
     */
    public void addFirst(T data) {
        Node<T> newNode = new Node<>(data);
        if (isEmpty()) tail = newNode;
        newNode.setNext(head);
        head = newNode;
        size++;
    }

    /**
     * Add a new node at a given index.
     *     Valid indices are 0 to size.
     * @param data data to be stored in the node.
     * @param index index at which the node is to be added.
     */
    public void addAt(T data, int index) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();
        if (index == 0) addFirst(data);
        else if (index == size) addLast(data);
        else
        {
            Node<T> newNode = new Node<>(data);
            Node<T> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.getNext();
            }
            newNode.setNext(current.getNext());
            current.setNext(newNode);
            size++;
        }
    }

    /**
     * Add a new node after a given node.
     * @param data data to be stored in the node.
     * @param dataAfter data after which the new node is to be added.
     */
    public void addAfter(T data, T dataAfter) {
        int index = getIndex(dataAfter);
        if (index == -1) throw new IllegalArgumentException();
        addAt(data, index + 1);
    }

    /**
     * Remove the first node from the list.
     */
    public void deleteFirst() {
        if (isEmpty()) throw new IllegalStateException();
        if (head == tail) {
            head = null;
            tail = null;
        }
        else head = head.getNext();
        size--;
    }

    /**
     * Delete the last node in the list.
     */
    public void deleteLast() {
        if (isEmpty()) throw new IllegalStateException();
        if (head == tail)
        {
            head = null;
            tail = null;
        }
        else
        {
            Node<T> current = head;
            while (current.getNext() != tail) {
                current = current.getNext();
            }
            current.setNext(null);
            tail = current;
        }
        size--;
    }

    /**
     * Delete a node at a given index.
     * @param index index of the node to be deleted.
     */
    public void deleteAt(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        if (index == 0) deleteFirst();
        else if (index == size - 1) deleteLast();
        else
        {
            Node<T> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.getNext();
            }
            current.setNext(current.getNext().getNext());
            size--;
        }
    }

    /**
     * Deletes
     * @param data data of the node to be deleted.
     */
    public void delete(T data) {
        int index = getIndex(data);
        if (index == -1) throw new IllegalArgumentException();
        deleteAt(index);
    }

    /**
     * Get the iterator for the list.
     * @return an iterator for the list.
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            Node<T> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            public T next() {
                if (!hasNext()) throw new IllegalStateException();
                T data = current.getData();
                current = current.getNext();
                return data;
            }
        };
    }

    /**
     * Convert the list to a string.
     * @return a string representation of the list.
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node<T> current = head;
        while (current != null) {
            sb.append(current.getData());
            current = current.getNext();
            if (current != null) sb.append(" -> ");
        }
        sb.append("]");
        return sb.toString();
    }

    /**
     * Check if the list is equal to another list.
     * @param list list to be compared.
     * @return true if the lists are equal, false otherwise.
     */
    public boolean equals(LinkedList<T> list){
        if (list == null && head == null) return true;
        if (list == null || head == null) return false;
        if (list.getSize() != size) return false;
        Node<T> current = head;
        Node<T> current2 = list.head;
        while (current != null) {
            if (!current.equals(current2)) return false;
            current = current.getNext();
            current2 = current2.getNext();
        }
        return true;
    }

    /**
     * Iteratively reverse the linked list.
     */
    public void reverseIterative() {
        Node<T> current = head;
        Node<T> previous = null;
        Node<T> next;

        tail = head;
        while (current != null) {
            next = current.getNext();
            current.setNext(previous);
            previous = current;
            current = next;
        }
        head = previous;
    }

    private void reverseRecursive(Node<T> current, Node<T> previous) {
        if (current == null) return;
        Node<T> next = current.getNext();
        current.setNext(previous);
        if (next == null) head = current;
        reverseRecursive(next, current);
    }

    /**
     * Recursively reverse the linked list.
     */
    public void reverseRecursive() {
        tail = head;
        reverseRecursive(head, null);
    }

    private void calculateSizeRecursive(Node<T> current, int sum) {
        if (current == null) size = sum;
        else calculateSizeRecursive(current.getNext(), sum + 1);
    }

    /**
     * Recursively calculate the size of the list.
     */
    public void calculateSizeRecursive() {
        calculateSizeRecursive(head, 0);
    }

    /**
     * Check if the list is a palindrome. Inserts the list into a stack and then checks if the stack is a palindrome.
     * This algorithm assumes that we don't know the size of the list.
     * @return true if the list is a palindrome, false otherwise.
     */
    public boolean isPalindrome() {
        if (isEmpty()) return false;
        if (head == tail) return true;
        Node<T> current = head;
        Stack<T> stack = new Stack<>();
        while (current != null) {
            stack.push(current.getData());
            current = current.getNext();
        }
        current = head;
        while (current != null) {
            if (!stack.pop().equals(current.getData())) return false;
            current = current.getNext();
        }
        return true;
    }




}
