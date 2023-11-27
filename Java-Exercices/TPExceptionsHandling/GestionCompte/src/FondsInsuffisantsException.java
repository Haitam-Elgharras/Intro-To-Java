public class FondsInsuffisantsException extends CompteException{
    public FondsInsuffisantsException() {
        super("Solde insuffisant pour effectuer cette operation");
    }

    public FondsInsuffisantsException(String message) {
        super(message);
    }
}
