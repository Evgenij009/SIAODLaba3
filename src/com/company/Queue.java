package com.company;

public class Queue<T> {
    private Node<T> head;
    private Node<T> tail;

    public Queue() {
        head = null;
        tail = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void enqueue(T value) {
        Node<T> n = new Node<>(value);
        if (isEmpty()) {
            head = n;
            tail = head;
        } else {
            tail.next = n;
            tail = n;
        }
    }

    public Node<T> dequeue() {
        if (isEmpty()) {
            return null;
        }
        if (head == tail) {
            Node<T> temp = head;
            head = null;
            tail = null;
            return temp;
        }

        Node<T> temp = head;
        head = head.next;
        return temp;
    }

    public String toString() {
        StringBuilder sb;
        if (isEmpty()) {
			sb = new StringBuilder("Queue is empty");
		} else {
            sb = new StringBuilder("{ ");
            Node<T> temp = head;
            while (temp != tail) {
                sb.append(temp.value).append(" -> ");
                temp = temp.next;
            }
            sb.append(temp.value).append(" }");
        }
        return sb.toString();
    }
}
