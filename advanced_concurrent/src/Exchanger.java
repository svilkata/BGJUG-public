import java.util.Random;

public class Exchanger {

    public static void main(String[] args) {
        java.util.concurrent.Exchanger exchanger = new java.util.concurrent.Exchanger();

        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                try{
                    Random random = new Random();
                    Integer value = random.nextInt();
                    Integer exchanged = (Integer) exchanger.exchange(value);
                    System.out.println("Exchanged value " + value + " for " + exchanged);
                } catch (InterruptedException e){
                    Thread.currentThread().interrupt();
                }
            }).start();
        }
    }
}
