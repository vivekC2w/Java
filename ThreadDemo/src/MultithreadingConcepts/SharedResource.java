package MultithreadingConcepts;

public class SharedResource {
    boolean isAvailable = false;
    private boolean suspended = false;

    public synchronized void produce() {
        System.out.println(Thread.currentThread().getName() + " acquired lock and started producing.");
        isAvailable = true;

        try {
            Thread.sleep(8000);
        } catch (Exception e) {
            // handle some exception here
        }
        System.out.println(Thread.currentThread().getName() + " released lock.");
    }

    //resume the suspended thread
    public void resumeThread() {
        suspended = false;
        synchronized (this) {
            notify();       //it will wake up the waiting thread
        }
    }

    // safe execution with suspension handling
    public synchronized void safeProduce() {
        while (suspended) {
            try {
                wait(); // wait until resumed
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // restore interrupted status
            }
        }
        produce();
    }
}
