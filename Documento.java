package Refuerzo;

public abstract class Documento {
    private int id;
    private String title;
    private String subject;
    private int amount;
    private boolean status;
    public Documento(int id, String title, String subject, int amount, boolean status) {
        this.id = id;
        this.title = title;
        this.subject = subject;
        this.amount = amount;
        this.status = status;
    }
    public int getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getSubject() {
        return subject;
    }
    public int getAmount() {
        return amount;
    }
    public boolean isStatus() {
        return status;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }
    
    

}
