public class Main {
    public static void main(String[] args) throws Exception {
        SharedResource sharedResourceObj = new SharedResource();
        Thread ProducerThread = new Thread(() -> {
            try {
                Thread.sleep(2000);    
            } catch (Exception e) {
                // TODO: handle exception
            }
            
            sharedResourceObj.addItem();
        });

        Thread ConsumerThread = new Thread(() -> {
            sharedResourceObj.consumeItem();
        });

        ProducerThread.start();
        ConsumerThread.start();
    }
}
