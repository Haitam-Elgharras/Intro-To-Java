


public class Reponse {
   private String titre;
    private boolean estCorrecte;
    public Reponse(String titre, boolean estCorrecte) {
        this.titre = titre;
        this.estCorrecte = estCorrecte;
    }

    public String getTitre() {
        return titre;
    }
    public boolean isEstCorrecte() {
        return estCorrecte;
    }
    public void setEstCorrecte(boolean estCorrecte) {
        this.estCorrecte = estCorrecte;
    }

    @Override
    public String toString() {
        return "Reponse{" +
                "titre='" + titre + '\'' +
                ", estCorrecte=" + estCorrecte +
                '}';
    }
}
