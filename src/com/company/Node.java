package com.company;

public class Node<T> {
    public T value;
    public Node<T> next;

    public Node(T value) {
        this.value = value;
        next = null;
    }

    public String toString() {
        return value.toString();
    }
}
