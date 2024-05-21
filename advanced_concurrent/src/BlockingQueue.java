import java.util.concurrent.ArrayBlockingQueue;

public class BlockingQueue {
    ArrayBlockingQueue<String> blockingQueue = new ArrayBlockingQueue<String>(50);

    public void add() {
        try {
            blockingQueue.add("first");
            blockingQueue.add("second");
            blockingQueue.add("third");
            System.out.println("Adding items completed");
        }
        catch (Exception e) {
            Thread.currentThread().interrupt();
        }
    }

    public void remove() {
        try {
            System.out.println(blockingQueue.take());
            System.out.println(blockingQueue.take());
            System.out.println(blockingQueue.take());
            System.out.println("Removing items completed");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static void blockingCollectionExample(){
        BlockingQueue example = new BlockingQueue();
        new Thread(() -> {example.remove();}).start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        new Thread(() -> {example.add();}).start();
    }

    public static void main(String[] args) {
        blockingCollectionExample();
    }
}
