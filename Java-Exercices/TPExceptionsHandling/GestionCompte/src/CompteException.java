public class CompteException extends Exception {

    public CompteException( Throwable cause) {
        super(cause);
    }
    public CompteException() {
        super("an unexpected error occurred");
    }

    public CompteException(String message) {
        super(message);
    }
}
