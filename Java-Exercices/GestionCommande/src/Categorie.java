import java.util.List;

public class Categorie {
    private long id;
    private String nom;
    private String description;
    private List<Article> articles;
    private static List<Long> ids;

    private static long generateUniqueId(){
        // based on timestamp
        long id = System.currentTimeMillis();
        while (ids.contains(id)) {
            id = System.currentTimeMillis();
        }
        ids.add(id);
        return id;
    }

    public Categorie( String nom, String description, List<Article> articles) {
        this.id = generateUniqueId();
        this.nom = nom;
        this.description = description;
        this.articles = articles;
    }

    public void addArticle(Article article) {
        this.articles.add(article);
    }
    public void removeArticle(Article article) {
        this.articles.remove(article);
    }
    public List<Article> getArticlesByPrice(double min, double max) {
        List<Article> articles = this.articles;
        articles.removeIf(article -> article.getPrix() < min || article.getPrix() > max);
        return articles;
    }

    @Override
    public String toString() {
        return "Categorie: "
                + this.nom
                + ", "
                + this.description;
    }
}
