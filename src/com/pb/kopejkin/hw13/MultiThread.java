package com.pb.kopejkin.hw13;

import java.util.ArrayList;

public class MultiThread {
    public static void main(String[] args) {
        final int maxListSize = 10;
        final int maxProducerDelay = 5000;
        final int maxConsumerDelay = 5000;
        ArrayList<Integer> list = new ArrayList<>();
        Producer producer = new Producer(list, maxProducerDelay, maxListSize);
        Consumer consumer = new Consumer(list, maxConsumerDelay);
        Thread producerThread = new Thread(producer);
        Thread consumerThread = new Thread(consumer);

        producerThread.start();
        consumerThread.start();
    }
}
