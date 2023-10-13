package Refuerzo;

public class Client {
    private int identity;
    private String name;
    private String address;
    private int amountBorrowed;
    public Client(int identity, String name, String address, int amountBorrowed) {
        this.identity = identity;
        this.name = name;
        this.address = address;
        this.amountBorrowed = amountBorrowed;
    }
    public int getIdentity() {
        return identity;
    }
    public String getName() {
        return name;
    }
    public String getAddress() {
        return address;
    }
    public int getAmountBorrowed() {
        return amountBorrowed;
    }
    
}
