
// Cette classe permet de conjuguer un verbe au présent pour les pronoms personnels français.
public class Conjugueur {
    // Le verbe à conjuguer
    private String verbe;

    /**
      Constructeur de la classe Conjugueur.
     */
    public Conjugueur(String verb) {
        this.verbe = verb;
    }

    /**
       Conjugue le verbe au présent pour les pronoms personnels français et affiche le résultat.
     */
    public void ConjuguerPresent() {
        // Extraire la racine du verbe (en enlevant les deux dernières lettres)
        String root = verbe.substring(0, verbe.length() - 2);

        // Les pronoms personnels sujets en français
        String[] pronoms = {"Je", "Tu", "Il/Elle", "Nous", "Vous", "Ils/Elles"};

        // Les terminaisons au présent
        String[] terminaisons = {"e", "es", "e", "ons", "ez", "ent"};

        // Boucle pour conjuguer le verbe pour chaque pronom
        for (int i = 0; i < pronoms.length; i++) {
            // Afficher la conjugaison pour le pronom actuel
            System.out.println(pronoms[i] + " " + root + terminaisons[i]);
        }
    }
}
