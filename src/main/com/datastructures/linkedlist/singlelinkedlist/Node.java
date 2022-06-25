package com.datastructures.linkedlist.singlelinkedlist;

/**
 * Generic Node class for Single Linked List.
 */
public class Node<T> {
        private T data;
        private Node<T> next;

    /**
     * Constructor for Node.
     * @param data data to be stored in the node.
     */
    public Node(T data) {
        this.data = data;
    }

    /**
     * Getter for data.
     * @return data stored in the node.
     */
    public T getData() {
        return data;
    }

    /**
     * Setter for data.
     * @param data data to be stored in the node.
     */
    public void setData(T data) {
        this.data = data;
    }

    /**
     * Getter for next.
     * @return next node.
     */
    public Node<T> getNext() {
        return next;
    }

    /**
     * Setter for next.
     * @param next next node.
     */
    public void setNext(Node<T> next) {
        this.next = next;
    }

    /**
     * Overriding toString method.
     * @return string representation of the node.
     */
    @Override
    public String toString() {
        return data.toString();
    }

    /**
     * Overriding equals method.
     * @param obj object to be compared.
     * @return true if the objects are equal.
     */
    public boolean equals(Node<T> obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        if (obj.getData() == null && data == null) return true;
        if (obj.getData() == null || data == null) return false;
        return obj.getData().equals(data);
    }
}
