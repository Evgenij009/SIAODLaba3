package com.company;

import java.util.ArrayList;

public class TaskQueue<T> {
    private Queue<T> priorQueue;
    private ArrayList<WeightedQueue<T>> weightedQueues;
    private int currentQueue = 0;
    private int amountOfQueues;
    private int currentWeight = 0;

    public TaskQueue(Queue<T> prior, ArrayList<WeightedQueue<T>> queues) {
        priorQueue = prior;
        weightedQueues = queues;
        amountOfQueues = queues.size();
    }

    public boolean isEmpty() {
        return isPriorEmpty() && isWeightedEmpty();
    }

    private boolean isWeightedEmpty() {
        for (WeightedQueue<T> wq : weightedQueues) {
            if (!wq.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    private boolean isPriorEmpty() {
        return priorQueue.isEmpty();
    }

    public Node<T> dequeue() {
        if (isEmpty()) {
            return null;
        }
        Node<T> toReturn;
        if (isPriorEmpty()) {
            if (weightedQueues.get(currentQueue).isEmpty()) {
                currentWeight = 0;
            }
            while (weightedQueues.get(currentQueue).isEmpty()) {
                currentQueue = (currentQueue + 1) % amountOfQueues;
            }
            toReturn = weightedQueues.get(currentQueue).dequeue();
            currentWeight++;
            if (weightedQueues.get(currentQueue).weight == currentWeight) {
                currentWeight = 0;
                currentQueue = (currentQueue + 1) % amountOfQueues;
            }
        } else {
            return priorQueue.dequeue();
        }
        return toReturn;
    }

    public void enqueuePrior(T value) {
        priorQueue.enqueue(value);
    }

    public void enqueueWeighted(int index, T value) {
        weightedQueues.get(index).enqueue(value);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("");
        sb.append("prior queue: ").append(priorQueue).append("\n");
        int index = 0;
        for (WeightedQueue<T> wq : weightedQueues) {
            sb.append(index++).append(") ").append(wq).append("\n");
        }
        return sb.toString();
    }
}
