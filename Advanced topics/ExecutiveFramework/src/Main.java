import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) {


        int [] tab = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21};
        int nbThreads = 4;
        int taille = tab.length;
        int tailleBloc = taille / nbThreads;
        int reste = taille % nbThreads;
        int debut = 0;
        int fin = 0;

        ExecutorService executor= Executors.newFixedThreadPool(nbThreads);

        var futures = new ArrayList<Future<Integer>>();
        try {
            for (int i = 0; i < nbThreads; i++) {
                debut = fin;
                fin = debut + tailleBloc;
                if (reste > 0) {
                    fin++;
                    reste--;
                }
                int finalDebut = debut;
                int finalFin = fin;
                var future= executor.submit(() -> {
                    int somme = 0;
                    for (int j = finalDebut; j < finalFin; j++)
                        somme += tab[j];

                    return somme;
                });
                futures.add(future);
            }
        } finally {
            System.out.println("shutdown");
            executor.shutdown();
        }

        // sum
        int somme = 0;
        for (var future : futures) {
            try {
                // get() is a blocking method
                somme += future.get();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.printf("Somme = %d\n", somme);// 231

    }
}