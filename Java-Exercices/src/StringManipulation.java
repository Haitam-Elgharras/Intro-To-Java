import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// ce class est pour manipuler les chaines de caractères
public class StringManipulation {
    private String text;
    // un scanner pour lire les entrées de l'utilisateur
    private Scanner scanner;

    // on fait le constructeur pour initialiser le scanner
    public StringManipulation() {
        this.scanner = new Scanner(System.in);
    }
// on fait une méthode intégrée pour lire les entrées de l'utilisateur
    public void Scanner() {
        System.out.println("Enter a text:");
        this.text = scanner.nextLine();
    }

    public void printText() {
        System.out.println(this.text);
    }
    // on fait une méthode pour inverser le texte
    public void printInverse(){
        text = new StringBuilder(text).reverse().toString();
    }
    // on fait une méthode pour compter les mots avec split
    public int countWords(){
        return text.split(" ").length;
    }

    public void nbrOccurence(){
        // on se base sur le code ascii pour compter les occurences
        int [] occurence = new int[26];
           for (int i = 0; i < text.length(); i++) {
                char c = text.charAt(i);
                if (c >= 'a' && c <= 'z') {
                    occurence[c - 'a']++;
                }
        }
           // on fait une boucle pour afficher les occurences
        for (int i = 0; i < occurence.length; i++) {
            if (occurence[i] > 0) {
                System.out.println((char) (i + 'a') + " : " + occurence[i]);
            }
        }
    }

}
