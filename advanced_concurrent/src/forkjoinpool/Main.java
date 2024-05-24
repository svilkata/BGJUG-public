package forkjoinpool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

public class Main {
    public static void main(String[] args) {
        NumberFormatAction action = new NumberFormatAction(1, 50);
        ForkJoinPool.commonPool().invoke(action);

        List list = new ArrayList();
        list.parallelStream();
    }
}
