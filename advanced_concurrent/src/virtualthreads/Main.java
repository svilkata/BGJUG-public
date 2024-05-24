package virtualthreads;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) {

    }

    private static void createSimpleVirtualThread() throws InterruptedException {
        Thread thread = Thread.ofVirtual().start(() -> {...});
        thread.join();
    }

    private static void createVirtualThreadPool() throws InterruptedException, ExecutionException {
        ExecutorService virtualThreadPool = Executors.newVirtualThreadPerTaskExecutor();
        Future<?> task = virtualThreadPool.submit(() -> {...});
        task.get();
    }
}
