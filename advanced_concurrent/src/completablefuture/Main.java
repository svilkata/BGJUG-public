package completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        CompletableFuture<Integer> task1 = new CompletableFuture<>();
//
//        // forcing completing of future by specifying result
//        boolean complete = task1.complete(10);

//        CompletableFuture<Integer> task1 = CompletableFuture.supplyAsync(() -> {
//            //some code logic here
//            return 10;
//        });
//
//        //executed on completion of the future
//        CompletableFuture<Integer> integerCompletableFuture = task1.thenApply((x) -> x * x);
//        System.out.println(integerCompletableFuture.get()); //100
//
//        //executed in case of exception or completion of the future
//        task1.handle((x, y) -> {
//            return ............
//        });
//        System.err.println(task1.get());
//
//        //can be completed prematurely with a result
//        task1.complete(20);

        CompletableFuture<Object> prev = null;
        Supplier<Object> supplier = () -> {};

        for (int i = 0; i < count; i++) {
            CompletableFuture<Object> task;
            if (prev != null) {
                task = prev.thenCompose(x -> {
                    return CompletableFuture.supplyAsync(supplier);
                });
            } else {
                task = CompletableFuture.supplyAsync(supplier);
            }

            prev = task;
        }

        prev.get();
    }
}
