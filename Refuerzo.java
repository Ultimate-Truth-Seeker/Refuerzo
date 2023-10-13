package Refuerzo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Refuerzo {
    public static void main(String[] args) {
        List<Documento> documentos = new ArrayList<>();
        Scanner s = new Scanner(System.in);
        boolean menu = true;
        while (menu) {
            int op = s.nextInt();
            switch (op) {
                default:
                break;
                case 1:
                int type = s.nextInt();
                int id = 0;
                while (true) {
                    boolean out = true;
                    id = s.nextInt();
                    for (Documento d : documentos) {
                        if (d.getId() == id) {
                            out =false;
                            break;
                        }
                    }
                    if (out) {
                        break;
                    }
                }
                s.nextLine();
                String title = s.nextLine();
                String subject = s.nextLine();
                int amount = s.nextInt();
                boolean status = false;
                int st = s.nextInt();
                while (st != 1 && st != 0) {
                    st = s.nextInt();
                }
                if (st == 1) {
                    status = true;
                }
                switch (type) {
                    case 1:
                    s.nextLine();
                    String editorial = s.nextLine();
                    String author = s.nextLine();
                    Book b = new Book(id, title, subject, amount, status, editorial, author);
                    documentos.add(b);
                    break;
                    case 2:
                    int year = s.nextInt();
                    int number = s.nextInt();
                    Magazine m = new Magazine(id, title, subject, amount, status, number, year);
                    documentos.add(m);
                    break;
                    case 3:
                    s.nextLine();
                    author = s.nextLine();
                    String referee = s.nextLine();
                    Article a = new Article(id, title, subject, amount, status, author, referee);
                    documentos.add(a);
                    break;
                }
                break;
                case 2:
                int query = s.nextInt();
                for (Documento d : documentos) {
                    if (d.getId() == query) {
                        System.out.println(d.getTitle());
                        break;
                    }
                }
                break;
                case 3:
                s.nextLine();
                String Query = s.nextLine();
                int total = 0;
                for (Documento d : documentos) {
                    if (d.getSubject().equals(Query)) {
                        total ++;
                    }
                }
                System.out.println(""+total);
                break;
                case 4:
                s.nextLine();
                Query = s.nextLine();
                total = 0;
                for (Documento d : documentos) {
                    if (d.getSubject().equals(Query)) {
                        total ++;
                    }
                }
                System.out.println(""+total);
                break;
                case 5:
                break;
                case 6:
                menu = false;
                break;
            }
        }
        s.close();
    }    
}
