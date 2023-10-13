package Refuerzo;
/**
 * clase que representa un libro
 * @author Ultimate-Truth-Seeker
 */
public class Book extends Documento  {
    private String editorial;
    private String author;
    public Book(int id, String title, String subject, int amount, boolean status, String editorial, String author) {
        super(id, title, subject, amount, status);
        this.editorial = editorial;
        this.author = author;
    }
    public String getEditorial() {
        return editorial;
    }
    public String getAuthor() {
        return author;
    }
    
    
}
