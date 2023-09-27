public class EmailService implements CanNotify {
    @Override
    public void notify(User user) {
        System.out.println("Sending an email to " + user.getMail());
    }
}
