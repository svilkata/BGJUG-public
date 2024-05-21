import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class PublishSubscribeWithConditionExample {
    private String message;
    private ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public static void main(String[] args) {
        PublishSubscribeWithConditionExample example = new PublishSubscribeWithConditionExample();

        for (int i = 0; i < 100; i++) {
            new Thread(() -> {example.subscribe();}).start();
        }

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); //interrupt flag is being cleared, so if we want the layers above to know if the thread was interrupted, we make like this
        }

        new Thread(() -> {example.publish("Hello threads!");}).start();
    }

    public synchronized void subscribe() {
        try {
            lock.lock();
            while (this.message == null){
                try {
                    condition.await();
                } catch (InterruptedException e){
                    Thread.currentThread().interrupt();
                }
            }
            System.out.println("Message received: " + this.message);
        } finally {
            lock.unlock();
        }
    }

    public synchronized void publish(String message) {
        try {
            lock.lock();
            this.message = message;
            System.out.println("Notifying all threads ...");
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }
}
