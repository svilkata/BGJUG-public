public class Phaser {

    public static void main(String[] args) {
        java.util.concurrent.Phaser phaser = new java.util.concurrent.Phaser(1);
        phaser.bulkRegister(3); //още два пъти да се извика метода, преди да продължи приложението

        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + " arriving at phaser");
                phaser.arriveAndAwaitAdvance();
                System.out.println(Thread.currentThread().getName() + " leaving the phaser");
            }).start();
        }
    }
}
