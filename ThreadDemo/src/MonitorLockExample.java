public class MonitorLockExample {
    public static MonitorLockExample obj;

    public synchronized void task1() {
        try {
            System.out.println("Inside task1");
            Thread.sleep(10000);
            System.out.println("task1 completed");
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Exception in task1: " + e.getMessage());
        }
    }

    public void task2() {
        System.out.println("task2, but before synchronized method");
        synchronized (this) {
            System.out.println("task2, Inside synchronized method");
        }
    }

    public void task3() {
        System.out.println("task3");
    }
}
