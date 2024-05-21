import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWrite {
    public static void main(String[] args) {
        copyOnWriteExample();
    }

    private static void copyOnWriteExample() {
        CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        copyOnWriteArrayList.add("first");
        copyOnWriteArrayList.add("second");
        copyOnWriteArrayList.add("third");
    }
}
