package Refuerzo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Refuerzo {
    public static void main(String[] args) {
        List<Documento> documentos = new ArrayList<>();
        List<Client> clients = new ArrayList<>();
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
                    if (id <1 || id > 999999) {
                        out = false;
                    }
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
                boolean status = true;
                
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
                id = s.nextInt();
                int clindex = -1; boolean found = false;
                for (Client c : clients) {
                    if (c.getIdentity() == id) {
                        clindex = clients.indexOf(c); found = true;
                        break;
                    }
                }
                if (!found) {
                    s.nextLine();
                    String name = s.nextLine();
                    String address = s.nextLine();
                    clients.add(new Client(id, name, address, 0));
                    for (Client c : clients) {
                    if (c.getIdentity() == id) {
                        clindex = clients.indexOf(c); found = true;
                        break;
                    }
                }  
                }
                if (clients.get(clindex).getAmountBorrowed() == 5) {
                    break;
                }
                id =s.nextInt(); found = false; int dindex = -1;
                for (Documento d : documentos) {
                    if (d.getId() == id) {
                        found = true;
                        dindex = documentos.indexOf(d);
                        break;
                    }
                }
                if (found){
                    if (documentos.get(dindex).isStatus() == false) {
                        break;
                    }
                    int from = s.nextInt();
                    int due = s.nextInt();
                    clients.get(clindex).setBorrowing(id, from, due);
                    clients.get(clindex).setAmount(clients.get(clindex).getAmountBorrowed() + 1);
                    documentos.get(dindex).setAmount(documentos.get(dindex).getAmount() - 1);
                    if (documentos.get(dindex).getAmount() == 0) {
                        documentos.get(dindex).setStatus(false);
                    }

                }

                break;
                case 7:
                id = s.nextInt(); found =false;
                for (Client c : clients) {
                    if (c.getIdentity() == id) {
                        found = true;
                        int index = s.nextInt();
                        int idd = c.getBorrowing(index - 1)[0];
                        if (idd == 0) {
                            break;
                        }
                        int due = s.nextInt();
                        int from = c.getBorrowing(index - 1)[1];
               //         int[][] narray = {c.getBorrowing(0), c.getBorrowing(1), c.getBorrowing(2), c.getBorrowing(3), c.getBorrowing(4)};
                 //       narray[index][2] = due;
                        clients.get(clients.indexOf(c)).setBorrowing(idd, from, due);
                        break;
                    }
                }

                break;
                case 8:
                id = s.nextInt(); found = false;
                for (Client c : clients) {
                    if (c.getIdentity() == id) {
                        int index = s.nextInt();
                        int idd = c.getBorrowing(index - 1)[0];
                        if (idd == 0) {
                            break;
                        }
                        clients.get(clients.indexOf(c)).setBorrowing(-idd, c.getBorrowing(index-1)[1], c.getBorrowing(index-1)[2]);
                        for (Documento d: documentos) {
                            if (d.getId() == idd) {
                                documentos.get(documentos.indexOf(d)).setAmount(d.getAmount() + 1);
                                if (d.isStatus() == false){
                                    documentos.get(documentos.indexOf(d)).setStatus(true);
                                }
                                break;
                            }
                        }
                        break;
                    }
                }
                break;
                case 9:
                menu = false;
                break;
            }
        }
        s.close();
    }    
}
