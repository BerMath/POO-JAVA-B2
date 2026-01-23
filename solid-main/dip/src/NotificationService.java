public class NotificationService {
    private MessageSender messageSender;

    public NotificationService(MessageSender messageSender) {
        this.messageSender = messageSender;
    }

    public void envoyer(String message) {
        messageSender.send(message);
    }

    public void setMessageSender(MessageSender messageSender) {
        this.messageSender = messageSender;
    }
}