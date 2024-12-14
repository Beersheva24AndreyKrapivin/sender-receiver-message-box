package telran.producer.consumer;

public class Receiver extends Thread{
    MessageBox messageBox;
    private boolean running = true;

    public Receiver(MessageBox messageBox) {
        this.messageBox = messageBox;
    }
    
    public Receiver() {

    }

    public void stopReceiver() {
        running = false;
        interrupt();
    }

    public void setMessageBox(MessageBox messageBox) {
        this.messageBox = messageBox;
    }
    
    @Override
    public void run() {
        while (running) {
            try {
                String message = messageBox.take();
                System.out.printf("Thread: %s, message: %s\n", getName(), message);
            } catch (InterruptedException e) {

            }
        }
    }
}
