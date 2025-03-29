public class SharedResource {
    boolean itemAvailable = false;

    //synchronized put the monitor lock
    public synchronized void addItem() {
        itemAvailable = true;
        System.out.println("Item added by: " + Thread.currentThread().getName() + " and invoking notifyAll");
        notifyAll(); //notifyAll wakes up all the threads that are waiting on this object's monitor
        //notify() wakes up a single thread that is waiting on this object's monitor
        //notifyAll is more efficient than notify because it wakes up all waiting threads
    }

    public synchronized void consumeItem() {
        System.out.println("ConsumeItem method invoked by: " + Thread.currentThread().getName());

        //using while loop to avoid spurious wakeup sometimes because of system noise
        while (!itemAvailable) {
            try {
                System.out.println("Thread " + Thread.currentThread().getName() + " is waiting for item to be available");
                wait(); //wait releases the monitor lock and puts the thread in waiting state
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Item consumed by: " + Thread.currentThread().getName());
        itemAvailable = false;
    }
}

// ConsumeItem method invoked by: Thread-1
// Thread Thread-1 is waiting for item to be available
// Item added by: Thread-0 and invoking notifyAll
// Item consumed by: Thread-1