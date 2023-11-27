import java.util.Scanner;

public class Produit {
    private long id;
    private String nom;
    private String marque;
    private String description;
    private double prix;
    private int quantiteStock;
    private Scanner scanner = new Scanner(System.in);

    public Produit(long id, String nom, String marque,
                   String description, double prix,
                   int quantiteStock)
    {
        this.id = id;
        this.nom = nom;
        this.marque = marque;
        this.description = description;
        this.prix = prix;
        this.quantiteStock = quantiteStock;
    }

    @Override
    public String toString() {
        return "Produit: "
                + "Id: " + this.id
                + ", Nom: " + this.nom
                + ", Marque: " + this.marque
                + ", Description: " + this.description
                + ", Prix: " + this.prix
                + ", QuantiteStock: " + this.quantiteStock;
    }

    void scannerProduit() {
        System.out.println("Donner l'id du produit: ");
        this.id = scanner.nextLong();

        // Consume the newline character
        scanner.nextLine();

        System.out.println("Donner le nom du produit: ");
        this.nom = scanner.nextLine();
        System.out.println("Donner la marque du produit: ");
        this.marque = scanner.nextLine();
        System.out.println("Donner la description du produit: ");
        this.description = scanner.nextLine();
        System.out.println("Donner le prix du produit: ");
        this.prix = scanner.nextDouble();

        // Consume the newline character
        scanner.nextLine();

        System.out.println("Donner la quantite du produit: ");
        this.quantiteStock = scanner.nextInt();
    }

    public long getId() {
        return id;
    }
}
