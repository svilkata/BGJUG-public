public class Semaphore {

    public static void main(String[] args) throws InterruptedException {
        java.util.concurrent.Semaphore semaphore = new java.util.concurrent.Semaphore(3);
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                try {
                    System.out.println("Starting worker: " + Thread.currentThread().getName());

                    //Acquires a permit from this semaphore, blocking until one is available, or the thread is interrupted.
                    //Acquires a permit, if one is available and returns immediately, reducing the number of available permits by one.
                    semaphore.acquire();

                    System.out.println("Ending worker: " + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }).start();
        }

        Thread.sleep(2000);
        semaphore.release();
        semaphore.release();
    }
}
