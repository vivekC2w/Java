package MultithreadingConcepts;

public class Main {
    
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();

        System.out.println("Main thread started");

        Thread thread1 = new Thread(() -> {
            System.out.println("Thread1 calling produce method");
            sharedResource.safeProduce();
        });

        Thread thread2 = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                // TODO: handle exception
            }
            sharedResource.safeProduce();
            System.out.println("Thread2 calling produce method");
        }, "Thread2");

        // 1 means low priority
        // 10 means high priority
        thread1.setPriority(Thread.MAX_PRIORITY);
        thread1.setDaemon(true);

        thread1.start();
        thread2.start();

        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            // TODO: handle exception
        }

        System.out.println("suspending thread1");
        sharedResource.resumeThread();

        try {
            thread1.join();
        } catch (Exception e) {
            // TODO: handle exception
        }

        System.out.println("Main thread is finished");
    }
}

// Main thread started
// Thread1 calling produce method
// Thread-0 acquired lock and started producing.
// suspending thread1
// Thread-0 released lock.
// Main thread is finished
// Thread2 acquired lock and started producing.
// Thread2 released lock.
// Thread2 calling produce method