public class Main {
    public static void main(String[] args) {
        Auteur auteur = new Auteur("Abdellah", "Laroui", "abdllah.laroui@gmail.com", "0666666666", 70, 1);
        Livre livre = new Livre(auteur, "978-2-253-13140-1", "L'histoire du Maroc");
        Adherent adherent = new Adherent("Mohamed", "Ali", "mohamed.ali@gmail.com", "0666666666", 20, 1);

        System.out.println(livre);
        System.out.println(adherent);

    }
}