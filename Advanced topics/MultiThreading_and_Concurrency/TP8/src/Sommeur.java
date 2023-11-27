public class Sommeur implements Runnable {
    private int[] tab;
    private int debut;
    private int fin;
    private int somme;

    public Sommeur(int[] tab,int debut, int fin ) {
        this.tab = tab;
        this.debut = debut;
        this.fin = fin;
    }

    @Override
    public void run() {
        somme = 0;
        for (int i = debut; i < fin; i++)
            somme += tab[i];

    }

    public int getSomme() {
        return somme;
    }
}
