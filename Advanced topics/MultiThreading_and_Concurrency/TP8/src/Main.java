import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {

    int [] tab = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21}; // 231
    int nbThreads = 4;
    int taille = tab.length;
    int tailleBloc = taille / nbThreads;
    int reste = taille % nbThreads;
    int debut = 0;
    int fin = 0;

        ExecutorService executor= Executors.newFixedThreadPool(nbThreads);

        var sommeurs = new ArrayList<Sommeur>();

        try {
            for (int i = 0; i < nbThreads; i++) {
                debut = fin;
                fin = debut + tailleBloc;
                if (reste > 0) {
                    fin++;
                    reste--;
                }
                System.out.println("debut = " + debut + " fin = " + fin);

                sommeurs.add(new Sommeur(tab, debut, fin));
                executor.execute(sommeurs.get(i));
            }
        } finally {
            System.out.println("shutdown");
            executor.shutdown();
        }

        // while the executor is not terminated, we wait
        while (!executor.isTerminated()) {
        }

        System.out.println("Tous les threads sont terminés");
        int somme = 0;
        for (Sommeur sommeur : sommeurs) {
            somme += sommeur.getSomme();
        }

        System.out.println("Somme = " + somme);
    }
}