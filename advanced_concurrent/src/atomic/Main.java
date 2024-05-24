package atomic;


import jdk.internal.misc.Unsafe;
import java.lang.invoke.VarHandle;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.DoubleAccumulator;

public class Main {
    public static void main(String[] args) {
//        Unsafe.compareAndSetInt();
//        VarHandle.compareAndSet();

//        AtomicInteger value = new AtomicInteger();
//        Thread thread = new Thread(() -> {
//            value.getAndIncrement();
//        });
//
//        thread.start();
//        value.getAndAdd(10);
//        try {
//            thread.join();
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        System.out.println(value.get());

//        DoubleAccumulator accumulator = new DoubleAccumulator((x, y) -> x + y, 0);
//        Thread thread = new Thread(() -> {
//            accumulator.accumulate(0.9);
//        });
//
//        thread.start();
//        accumulator.accumulate(10.1);
//        try {
//            thread.join();
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        System.out.println(accumulator.get());

        AtomicReference<String> reference = new AtomicReference<String>("first");
        Thread thread = new Thread(() -> {
            reference.getAndAccumulate(" some text", (x, y) -> x + y);
        });

        thread.start();
        reference.getAndAccumulate(" otherText", (x, y) -> x + y);
        try {
            thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(reference.get());
    }
}
