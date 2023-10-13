package Refuerzo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Driver program
 * @author Ultimate-Truth-Seeker
 * @version 12-10-2023
 */
public class Refuerzo {
    public static void main(String[] args) {
        List<Documento> documentos = new ArrayList<>();
        List<Client> clients = new ArrayList<>();
        Scanner s = new Scanner(System.in);
        boolean menu = true;
        while (menu) {
            System.out.println("Bienvenido, seleccione una opción:\n1.Añadir documento\n2.Encontrar título por id\n3.Total de documentos por materia\n4.Total de revistas por materia\n5.Información de todos los libros\n6.Prestar un documento\n7.Aplazar entrega\n8.Devolver un documento\n9.Salir");
            int op = s.nextInt();
            switch (op) {
                default:
                break;
                case 1:
                System.out.println("Ingrese 1 si es un libro, 2 si es una revista, o 3 si es un artículo");
                int type = s.nextInt();
                while (type < 1 || type > 3){
                    type = s.nextInt();
                }
                int id = 0;
                while (true) {
                    boolean out = true;
                    System.out.println("Ingrese su id de 6 dígitos entre 1 y 999999");
                    id = s.nextInt();
                    if (id <1 || id > 999999) {
                        System.out.println("El id no está en el rango");
                        out = false;
                    }
                    for (Documento d : documentos) {
                        if (d.getId() == id) {
                            System.out.println("Este id está repetido, elija otro");
                            out =false;
                            break;
                        }
                    }
                    if (out) {
                        break;
                    }
                }
                s.nextLine();
                System.out.println("Ingrese el título");
                String title = s.nextLine();
                System.out.println("Ingrese la materia");
                String subject = s.nextLine();
                System.out.println("Ingrese la cantidad disponible");
                int amount = s.nextInt();
                boolean status = true;
                
                switch (type) {
                    case 1:
                    s.nextLine();
                    System.out.println("Ingrese la editorial");
                    String editorial = s.nextLine();
                    System.out.println("Ingrese el autor");
                    String author = s.nextLine();
                    Book b = new Book(id, title, subject, amount, status, editorial, author);
                    documentos.add(b);
                    break;
                    case 2:
                    System.out.println("Ingrese el año");
                    int year = s.nextInt();
                    System.out.println("Ingrese el número");
                    int number = s.nextInt();
                    Magazine m = new Magazine(id, title, subject, amount, status, number, year);
                    documentos.add(m);
                    break;
                    case 3:
                    s.nextLine();
                    System.out.println("Ingrese el autor");
                    author = s.nextLine();
                    System.out.println("Ingrese el árbitro");
                    String referee = s.nextLine();
                    Article a = new Article(id, title, subject, amount, status, author, referee);
                    documentos.add(a);
                    break;
                }
                break;
                case 2:
                System.out.println("Ingrese el id del documento que busca");
                int query = s.nextInt();
                for (Documento d : documentos) {
                    if (d.getId() == query) {
                        System.out.println("Título: "+ d.getTitle());
                        break;
                    }
                }
                break;
                case 3:
                s.nextLine();
                System.out.println("Ingrese la materia que busca");
                String Query = s.nextLine();
                int total = 0;
                for (Documento d : documentos) {
                    if (d.getSubject().equals(Query)) {
                        total ++;
                    }
                }
                System.out.println("Total de documentos de materia " + Query+ ": "+total);
                break;
                case 4:
                s.nextLine();
                System.out.println("Ingrese la materia que busca");
                Query = s.nextLine();
                total = 0;
                for (Documento d : documentos) {
                    
                    if (d.getSubject().equals(Query) && d.getClass() == Magazine.class) {
                        total ++;
                    }
                }
                System.out.println("otal de revistas de materia "+ Query + ": " + total);
                break;
                case 5:
                for (Documento d: documentos) {
                    if (d.getClass() == Book.class) {
                        Book bk = (Book) d;
                        System.out.println("Título: " + d.getTitle() + ", Autor: " + bk.getAuthor() + ", Materia: " + d.getSubject());
                    }
                }
                break;
                case 6:
                System.out.println("Ingrese el id del cliente");
                id = s.nextInt();
                int clindex = -1; boolean found = false;
                for (Client c : clients) {
                    if (c.getIdentity() == id) {
                        System.out.println("Cliente encontrado");
                        clindex = clients.indexOf(c); found = true;
                        break;
                    }
                }
                if (!found) {
                    s.nextLine();
                    System.out.println("Cliente no encontrado, ingrese sus datos");
                    System.out.println("Ingrese su nombre");
                    String name = s.nextLine();
                    System.out.println("Ingrese su dirección");
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
                    System.out.println("Este cliente ya tiene cinco documentos, no puede prestar más");
                    break;
                }
                System.out.println("Ingrese el id del documento que va a prestar");
                id =s.nextInt(); found = false; int dindex = -1;
                for (Documento d : documentos) {
                    if (d.getId() == id) {
                        found = true;
                        System.out.println("Documento encontrado");
                        dindex = documentos.indexOf(d);
                        break;
                    }
                }
                if (found){
                    if (documentos.get(dindex).isStatus() == false) {
                        System.out.println("Este documento no está disponible ahora");
                        break;
                    }
                    System.out.println("Ingrese en un solo número la fecha en que presta");
                    int from = s.nextInt();
                    System.out.println("Ingrese en un solo número la fecha en que devuelve");
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
                System.out.println("Ingrese el id del cliente");
                id = s.nextInt(); found =false;
                for (Client c : clients) {
                    if (c.getIdentity() == id) {
                        System.out.println("Cliente encontrado");
                        found = true;
                        System.out.println("Estos son los préstamos del cliente. Las filas de ceros significan un espacio dispnible para prestar. Ingrese el número de fila que represente el préstamo a aplazar");
                        System.out.println("1 "  + c.getBorrowing(0)[0] + " " + c.getBorrowing(0)[1]+ " " + c.getBorrowing(0)[2] + "\n2 "+ c.getBorrowing(1)[0] + " " + c.getBorrowing(1)[1]+ " " + c.getBorrowing(1)[2] + "\n3 " + c.getBorrowing(2)[0] + " " + c.getBorrowing(2)[1]+ " " + c.getBorrowing(2)[2]+ "\n4 " + c.getBorrowing(3)[0] + " " + c.getBorrowing(3)[1]+ " " + c.getBorrowing(3)[2]+ "\n5 "+c.getBorrowing(4)[0] + " " + c.getBorrowing(4)[1]+ " " + c.getBorrowing(4)[2]);
                        int index = s.nextInt();
                        int idd = c.getBorrowing(index - 1)[0];
                        if (idd == 0) {
                            System.out.println("Esta fila está vacía");
                            break;
                        }
                        System.out.println("Ingrese en un solo número la nueva fecha de devolución");
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
                System.out.println("Ingrese el id del cliente");
                id = s.nextInt(); found = false;
                for (Client c : clients) {
                    if (c.getIdentity() == id) {
                        System.out.println("Cliente encontrado");
                        System.out.println("Estos son los préstamos del cliente. Las filas de ceros significan un espacio dispnible para prestar. Ingrese el número de fila que represente el préstamo a devolver");
                        System.out.println("1 "  + c.getBorrowing(0)[0] + " " + c.getBorrowing(0)[1]+ " " + c.getBorrowing(0)[2] + "\n2 "+ c.getBorrowing(1)[0] + " " + c.getBorrowing(1)[1]+ " " + c.getBorrowing(1)[2] + "\n3 " + c.getBorrowing(2)[0] + " " + c.getBorrowing(2)[1]+ " " + c.getBorrowing(2)[2]+ "\n4 " + c.getBorrowing(3)[0] + " " + c.getBorrowing(3)[1]+ " " + c.getBorrowing(3)[2]+ "\n5 "+c.getBorrowing(4)[0] + " " + c.getBorrowing(4)[1]+ " " + c.getBorrowing(4)[2]);
                        int index = s.nextInt();
                        int idd = c.getBorrowing(index - 1)[0];
                        if (idd == 0) {
                            System.out.println("Esta fila edtá vacía");
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
