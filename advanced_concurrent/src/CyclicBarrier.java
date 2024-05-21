import java.util.concurrent.BrokenBarrierException;

public class CyclicBarrier {

    public static void main(String[] args) {
        java.util.concurrent.CyclicBarrier barrier = new java.util.concurrent.CyclicBarrier(3, () -> {
            System.out.println("Workers have finished!");
        });

        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                System.out.println("Starting worker: " + Thread.currentThread().getName());
                try {
                    barrier.await();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } catch (BrokenBarrierException e) {
                    System.out.println("Ending worker: " + Thread.currentThread().getName());
                }
            }).start();
        } //barrier can be reset with barrier.reset()
    }
}
