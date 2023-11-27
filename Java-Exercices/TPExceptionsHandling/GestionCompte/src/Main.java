import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Créer des comptes pour les tests
        CompteBancaire compte1 = new CompteBancaire(1, 1000, "Titulaire1");
        CompteBancaire compte2 = new CompteBancaire(2, 500, "Titulaire2");

        // Effectuer des opérations et gérer les exceptions
        try {
            // Test de dépôt
            compte1.depot(500);
            System.out.println(compte1);

            // Test de retrait
            compte1.retraitArgent(300);
            System.out.println(compte1);

            // Test de transfert
            compte1.transfertArgent(compte2, 200);
            System.out.println(compte1);
            System.out.println(compte2);

            // Test d'une exception de solde insuffisant
            compte1.retraitArgent(2000);

            // Test d'une exception de compte inexistant
            compte1.transfertArgent(null, 200);
        } catch (CompteException e) {
            System.out.println(e.getMessage());
        }
    }
}
