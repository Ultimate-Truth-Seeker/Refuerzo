package Refuerzo;

public class Magazine extends Documento {
    private int number;
    private int year;
    public Magazine(int id, String title, String subject, int amount, boolean status, int number, int year) {
        super(id, title, subject, amount, status);
        this.number = number;
        this.year = year;
    }
    public int getNumber() {
        return number;
    }
    public int getYear() {
        return year;
    }
    
}
