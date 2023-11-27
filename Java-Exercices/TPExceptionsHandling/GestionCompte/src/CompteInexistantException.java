public class CompteInexistantException extends CompteException{
    public CompteInexistantException() {
        super("Compte introuvable");
    }
    public CompteInexistantException(String message) {
        super(message);
    }
}
