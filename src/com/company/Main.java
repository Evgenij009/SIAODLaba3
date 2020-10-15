package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static TaskQueue<String> queue = null;

    public static void main(String[] args) {
        menu();
    }

    private static void menu() {
    	printItems();
    	int item = inputItem();
        switch (item) {
            case 1:
                initialize();
                break;
            case 2:
                enqueuePrior();
                break;
            case 3:
                enqueueWeighted();
                break;
            case 4:
                dequeue();
                break;
            case 5:
                display();
                break;
            default:
                return;
        }
        menu();
    }

    private static void printItems() {
		System.out.println("----------------------------------");
		System.out.println("1) Initialize queue");
		System.out.println("2) Enqueue prior");
		System.out.println("3) Enqueue weighted");
		System.out.println("4) Dequeue");
		System.out.println("5) Display queue");
		System.out.println("----------------------------------");
	}

	private static int inputItem() {
        System.out.print("Input item: ");
        return Integer.parseInt(scanner.nextLine());
    }

    private static void initialize() {
        Queue<String> priorityQueue = new Queue<>();
        queue = new TaskQueue<>(priorityQueue, initializeWeightedQueues());
        System.out.println("Queue initialized successfully.");
    }

    private static ArrayList<WeightedQueue<String>> initializeWeightedQueues() {
        System.out.print("Input amount of weighted queues: ");
        int amount = Integer.parseInt(scanner.nextLine());
        ArrayList<WeightedQueue<String>> wqs = new ArrayList<>(amount);
        for (int i = 0; i < amount; i++) {
            Queue<String> queue = new Queue<>();
            System.out.printf("Input weight of queue: %d: ", i + 1);
            int weight = Integer.parseInt(scanner.nextLine());
            wqs.add(new WeightedQueue<>(queue, weight));
        }
        return wqs;
    }

    private static void enqueuePrior() {
        if (queue == null) {
            System.out.println("Queue is not initialized");
        } else {
            System.out.print("Input value to enqueue: ");
            queue.enqueuePrior(scanner.nextLine());
            System.out.println("Value successfully enqueued.");
        }
    }

    private static void enqueueWeighted() {
        if (queue == null) {
            System.out.println("Queue is not initialized");
        } else {
            System.out.print("Input index of weighted queue: ");
            int index = Integer.parseInt(scanner.nextLine());
            System.out.print("Input value to enqueue: ");
            queue.enqueueWeighted(index, scanner.nextLine());
            System.out.println("Value successfully enqueued.");
        }
    }

    private static void dequeue() {
        if (queue == null) {
            System.out.println("Queue is not initialized");
        } else if (queue.isEmpty()) {
            System.out.println("Queue is empty");
        } else {
            Node<String> n = queue.dequeue();
            System.out.printf("{%s} successfully dequeued\n", n);
        }
    }

    private static void display() {
        if (queue == null) {
            System.out.println("Queue is not initialized");
        } else {
            System.out.println(queue);
        }
    }
}
