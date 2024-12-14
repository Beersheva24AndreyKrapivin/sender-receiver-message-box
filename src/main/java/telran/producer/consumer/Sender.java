package telran.producer.consumer;

public class Sender extends Thread{
    private int nMessages;
    private MessageBox messageBoxEven;
    private MessageBox messageBoxOdd;

    public Sender(int nMessages, MessageBox messageBoxEven, MessageBox messageBoxOdd) {
        this.nMessages = nMessages;
        this.messageBoxEven = messageBoxEven;
        this.messageBoxOdd = messageBoxOdd;
    }
    
    @Override
    public void run() {
        for (int i = 0; i < nMessages; i++) {
            try {
                if (i % 2 == 0) {
                    messageBoxEven.put("Message" + (i + 1));
                } else {
                    messageBoxOdd.put("Message" + (i + 1));
                }
            } catch (InterruptedException e) {
                
            }
        }
    }
}
