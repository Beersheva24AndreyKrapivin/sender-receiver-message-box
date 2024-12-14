package telran.producer.consumer;

public class Main {
    private static final int N_MESSAGES = 20;
    private static final int N_RECEIVERS = 10;

    public static void main(String[] args) throws InterruptedException {
        MessageBox messageBoxEven = new SimpleMessageBox();
        MessageBox messageBoxOdd = new SimpleMessageBox();
        Sender sender = new Sender(N_MESSAGES, messageBoxEven, messageBoxOdd);
        for (int i = 0; i < N_RECEIVERS; i++) {
            if (i % 2 == 0) {
                new Receiver(messageBoxEven).start();
            } else {
                new Receiver(messageBoxOdd).start();
            }
        }
        sender.start();
        sender.join();

        Thread.sleep(100);

    }
}