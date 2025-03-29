public class MonitorLockMain {
    public static void main(String[] args) {
        MonitorLockExample obj = new MonitorLockExample();

        MonitorThread1Runnable runnable1 = new MonitorThread1Runnable(obj);
        Thread t1 = new Thread(runnable1);

        Thread t2 = new Thread(() -> {obj.task2();});
        Thread t3 = new Thread(() -> {obj.task3();});

        t1.start();
        t2.start();
        t3.start();
    }
}

//Output:
// Inside task1
// task2, but before synchronized method
// task3
// task1 completed
// task2, Inside synchronized method