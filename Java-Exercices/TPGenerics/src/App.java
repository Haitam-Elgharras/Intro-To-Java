import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        MetierProduitImpl metierProduit = new MetierProduitImpl();
        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.println("\n");
            System.out.println("###### Menu ######");
            System.out.println("1. Afficher les produits");
            System.out.println("2. Ajouter un produit");
            System.out.println("3. Supprimer un produit");
            System.out.println("4. Rechercher un produit");
            System.out.println("5. Quitter");
            System.out.println("##################");
            System.out.print("Votre choix: ");

            int choix = scanner.nextInt();
            long id;

            switch (choix) {
                case 1:
                    metierProduit.getAll().forEach(System.out::println);
                    break;

                case 2:
                    Produit produit = new Produit(0, "", "", "", 0, 0);
                    produit.scannerProduit();
                    if (metierProduit.add(produit))
                        System.out.println("Produit ajoute avec succes");
                    break;

                case 3:
                    System.out.print("Donner l'id du produit a supprimer: ");
                    id = scanner.nextLong();
                    metierProduit.delete(id);
                    System.out.println("Produit supprime avec succes");
                    break;

                case 4:
                    System.out.print("Donner l'id du produit a rechercher: ");
                    id = scanner.nextLong();
                    System.out.println(metierProduit.findById(id));
                    break;
                case 5:
                    System.exit(0);
                    break;
            }
        }
    }
}
