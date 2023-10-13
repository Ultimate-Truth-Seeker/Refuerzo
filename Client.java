package Refuerzo;
/**
 * clase que representa un cliente
 * @author Ultimate-Truth-Seeker
 */
public class Client {
    private int identity;
    private String name;
    private String address;
    private int amountBorrowed;
    private int[][] borrowed = new int[5][3];
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
    public int[] getBorrowing(int index) {
        return this.borrowed[index];
    }
    public void setBorrowing(int id, int from, int due) {
        for (int x = 0; x < 5; x++) {
            int[] a = this.borrowed[x];
            if (a[0] == 0 && a[1] == 0 && a[2] == 0 && id > 0) {
                this.borrowed[x][0] = id;
                this.borrowed[x][1] = from;
                this.borrowed[x][2] = due;
                break;
            } else if (a[0] == id && a[1] == from) {
                this.borrowed[x][0] = id;
                this.borrowed[x][1] = from;
                this.borrowed[x][2] = due;
                break;
            } else if (id == -a[0] && from == a[1] && due == a[2]) {
                this.borrowed[x][0] = 0;
                this.borrowed[x][1] = 0;
                this.borrowed[x][2] = 0;
            }
        }
    }
    public void setAmount(int amount) {
        this.amountBorrowed = amount;
    }
    
}
