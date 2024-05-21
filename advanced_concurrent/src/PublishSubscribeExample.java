public class PublishSubscribeExample {
    private String message;

    public static void main(String[] args) {
        PublishSubscribeExample example = new PublishSubscribeExample();

        for (int i = 0; i < 100; i++) {
            new Thread(() -> {example.subscribe();}).start();
        }

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); //interrupt flag is being cleared, so if we want the layers above to know if the thread was interrupted, we make like this
        }

        new Thread(() -> {example.publish("Hello threads!");}).start();
    }

    public synchronized void publish(String message){
        this.message = message;
        System.out.println("Notifying all threads ...");
        notifyAll();
    }

    public synchronized void subscribe(){
        while (message == null){
            try {
                wait();
            } catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }
        }

        System.out.println("Message received: " + message);
    }
}
