package forkjoinpool;

import java.util.concurrent.RecursiveAction;

public class NumberFormatAction extends RecursiveAction {
    int start;
    int end;

    public NumberFormatAction(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected void compute() {
        if (end - start <= 2) {
            System.out.println(start + " " + end);
        } else {
            int mid = start + (end - start) / 2;
            NumberFormatAction left = new NumberFormatAction(start, mid);
            NumberFormatAction right = new NumberFormatAction(mid + 1, end);
            java.util.concurrent.ForkJoinTask.invokeAll(left, right);
        }
    }
}
