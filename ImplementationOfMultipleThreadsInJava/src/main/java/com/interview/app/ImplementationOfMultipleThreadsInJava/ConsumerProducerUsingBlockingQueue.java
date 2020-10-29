package com.interview.app.ImplementationOfMultipleThreadsInJava;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConsumerProducerUsingBlockingQueue {

    private static ArrayBlockingQueue<Integer> buffer = new ArrayBlockingQueue<Integer>(2);

    public static void main(String[] args) {

        ProducerTask producerTask_1 = new ProducerTask();
        ProducerTask producerTask_2 = new ProducerTask();
        ConsumerTask consumerTask_1 = new ConsumerTask();
        ConsumerTask consumerTask_2 = new ConsumerTask();

        ExecutorService executor = Executors.newFixedThreadPool(4);
        executor.execute(producerTask_1);
        executor.execute(consumerTask_1);
        executor.execute(producerTask_2);
        executor.execute(consumerTask_2);
        executor.shutdown();
    }

    // A task for adding an int to the buffer
    private static class ProducerTask implements Runnable {

        @Override
        public void run() {
            try {
                int i = 1;
                while (true) {
                    System.out.println("Producer writes " + i);
                    buffer.put(i++); // Add any value to the buffer, say, 1
                    // Put the thread into sleep
                    Thread.sleep((int) (Math.random() * 10000));
                }
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    // A task for reading and deleting an int from the buffer
    private static class ConsumerTask implements Runnable {

        @Override
        public void run() {
            try {
                while (true) {
                    System.out.println("\t\t\tConsumer reads " + buffer.take());
                    // Put the thread into sleep
                    Thread.sleep((int) (Math.random() * 10000));
                }
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}
