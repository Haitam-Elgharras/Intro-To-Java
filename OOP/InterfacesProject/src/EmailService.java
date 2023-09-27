public class EmailService implements NotificationService {
    @Override
    public void notify(User user) {
        System.out.println("Sending an email to " + user.getMail());
    }
}
