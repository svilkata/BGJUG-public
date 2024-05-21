public class CountDownLatch {
    public static void main(String[] args) {
        java.util.concurrent.CountDownLatch latch = new java.util.concurrent.CountDownLatch(3);
        new Thread(() -> {
            try {
                latch.await();
                System.out.println("Workers have finished !");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }).start();

        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                System.out.println("Starting worker: " + Thread.currentThread().getName());
                latch.countDown();
            }).start();
        }
    }
}
