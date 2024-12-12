package telran.producer.consumer;

public class Receiver extends Thread{
    MessageBox messageBox;

    public Receiver(MessageBox messageBox) {
        this.messageBox = messageBox;
        //FIXME update to user thread with some logic of finishing
        setDaemon(true);
    }
    
    public Receiver() {

    }

    public void setMessageBox(MessageBox messageBox) {
        this.messageBox = messageBox;
    }
    
    @Override
    public void run() {
        while (true) {
            try {
                String message = messageBox.take();
                System.out.printf("Thread: %s, message: %s\n", getName(), message);
            } catch (InterruptedException e) {
                
            }
        }
    }
}
