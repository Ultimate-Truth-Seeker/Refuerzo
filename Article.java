package Refuerzo;
/**
 * clase que representa un artículo
 * @author Ultimate-Truth-Seeker
 */
public class Article extends Documento {
    private String author;
    private String referee;
    public Article(int id, String title, String subject, int amount, boolean status, String author, String referee) {
        super(id, title, subject, amount, status);
        this.author = author;
        this.referee = referee;
    }
    public String getAuthor() {
        return author;
    }
    public String getReferee() {
        return referee;
    }
    
}
