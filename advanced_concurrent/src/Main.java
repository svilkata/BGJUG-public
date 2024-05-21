import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        ConcurrentHashMap<Integer, Integer> map = new ConcurrentHashMap<>();
        map.put(1, 0);
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                map.compute(1, (key, value) -> {
                    return value + 1;
                });
            }).start();
        }

        Thread.sleep(1000);
        System.out.println(map.getOrDefault(1, -1));
    }

    private static void syncronizedCollectionExample() {
        List<String> items  = new ArrayList<>();
        List<String> synchronizedItems = Collections.synchronizedList(items);
    }
}