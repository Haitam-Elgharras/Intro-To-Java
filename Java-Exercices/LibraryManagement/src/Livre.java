public class Livre {
    private Auteur auteur;
    //International Standard Book Number
    private String ISBN;
    private String titre;

    public Livre(Auteur auteur, String ISBN, String titre) {
        this.auteur = auteur;
        this.ISBN = ISBN;
        this.titre = titre;
    }

    @Override
    public String toString() {
        return "Description du livre: \n" +
                "titre: " + titre + "\n" +
                "ISBN: " + ISBN + "\n" +
                auteur + "\n";
    }
}
