package com.company;

public class WeightedQueue<T> {
    public int weight;
    public Queue<T> q;

    public WeightedQueue(Queue<T> q, int weight) {
        this.weight = weight;
        this.q = q;
    }

    public boolean isEmpty() {
        return q.isEmpty();
    }

    public void enqueue(T value) {
        q.enqueue(value);
    }

    public Node<T> dequeue() {
        return q.dequeue();
    }

    public String toString() {
        return "weight: " + weight + ", " + q.toString();
    }
}
