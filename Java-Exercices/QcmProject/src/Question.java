

public class Question {
    private String titre;
    private String description;
    private Reponse[] reponses;
    private int score;

    public Question(String titre, String description, Reponse[] reponses, int score) {
        this.titre = titre;
        this.description = description;
        this.reponses = reponses;
        this.score = score;
    }

    public String getTitre() {
        return titre;
    }

    public String getDescription() {
        return description;
    }

    public Reponse[] getReponses() {
        return reponses;
    }

    public int getScore() {
        return score;
    }
}
