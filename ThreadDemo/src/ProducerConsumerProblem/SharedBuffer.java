package ProducerConsumerProblem;

import java.util.LinkedList;
import java.util.Queue;

public class SharedBuffer {
    private final Queue<Integer> buffer = new LinkedList<>();
    private final int capacity;

    public SharedBuffer(int capacity) {
        this.capacity = capacity;
    }

    //Producer method
    public synchronized void produce(int value) throws InterruptedException {
        while (buffer.size() == capacity) {
            System.out.println("Buffer is full, producer is waiting...");
            wait(); // Wait until space is available
        }
        buffer.offer(value);
        System.out.println("Produced: " + value);
        notifyAll(); // Notify consumers that an item has been produced
    }

    //Consumer method
    public synchronized int consume() throws InterruptedException {
        while (buffer.isEmpty()) {
            System.out.println("Buffer is empty, consumer is waiting...");
            wait(); // Wait until an item is available
        }
        int value = buffer.poll();
        System.out.println("Consumed: " + value);
        notifyAll(); // Notify producers that space is available
        return value;
    }
}
