package ProducerConsumerProblem;

public class ProducerConsumerExample {
    public static void main(String[] arge) {
        SharedBuffer buffer = new SharedBuffer(5);

        Producer producer = new Producer(buffer);
        Consumer consumer = new Consumer(buffer);

        Thread producerThread = new Thread(producer);
        Thread consumerThread = new Thread(consumer);
        
        // Start the threads
        producerThread.start();
        consumerThread.start();

    }
}

// Produced: 1
// Consumed: 1
// Produced: 2
// Produced: 3
// Consumed: 2
// Produced: 4
// Produced: 5
// Produced: 6
// Consumed: 3
// Produced: 7
// Produced: 8
// Buffer is full, producer is waiting...
// Consumed: 4
// Produced: 9
// Buffer is full, producer is waiting...
// Consumed: 5
// Produced: 10
// Buffer is full, producer is waiting...
// Consumed: 6
// Produced: 11
// Buffer is full, producer is waiting...
// Consumed: 7
// Produced: 12
// Buffer is full, producer is waiting...
// Consumed: 8
// Produced: 13
// Buffer is full, producer is waiting...
// Consumed: 9
// Produced: 14
// Buffer is full, producer is waiting...