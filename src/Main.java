import com.sun.org.apache.xpath.internal.res.XPATHErrorResources_sv;
import model.Book;
import service.BookService;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {


    static void display(List<Book> books) {
        Iterator<Book> iterator = books.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public static void main(String[] args) throws IOException {
        BookService bookService = new BookService();
        Scanner sc = new Scanner(System.in);
        System.out.println("1.Find all book");
        System.out.println("2.Add book");
        System.out.println("3.Edit book");
        System.out.println("4.Delete book");
        System.out.println("5.Find by phone");
        System.out.println("6.Read file");
        System.out.println("7.Write file");
        System.out.println("8.Exit");
        Book book = new Book();

        do {
            System.out.println("Your choice");
            int choose = sc.nextInt();
            switch (choose) {
                case 1:
                    System.out.println("-----All book list--------");
                    display(bookService.findAllBook());
                    break;
                case 2:
                    System.out.println("-------Add new book--------");
                    Book book1 = book.inputBook();
                    if(bookService.checkPhone(book1.getPhone())) {
                        System.out.println("Phone is exists!");
                        break;
                    }
                    bookService.addBook(book1);

                    break;
                case 3:
                    System.out.println("-------Edit book-----------");
                    System.out.println("Input phone for update!");
                    int phone = sc.nextInt();
                    sc.nextLine();
                    Book book2 = book.inputBook();
                    bookService.editBook(phone,book2);
                    if(!bookService.checkPhone(phone)) {
                        System.out.println("No phone in book");
                        break;
                    }
                    bookService.writeFile();
                    break;
                case 4:
                    System.out.println("----------Delete book-------");
                    System.out.println("Input product in list");
                    phone = sc.nextInt();
                    if(!bookService.checkPhone(phone)) {
                        System.out.println("No found book");
                        break;
                    }
                    System.out.println(bookService.deleteBook(phone));
                    bookService.writeFile();
                    break;
                case 5:
                    System.out.println("--------Find book by phone----------");
                    System.out.println("Input phone for look");
                    phone = sc.nextInt();
                    sc.nextLine();
                    if(bookService.findByPhone(phone)!= null) {
                        System.out.println("Information book has phone " + phone);
                        System.out.println(bookService.findByPhone(phone));
                    } else {
                        System.out.println("No found book");
                        break;
                    }
                    break;
                case 6:
                    System.out.println("-------------Read File---------------");
                    try {
                        bookService.readFile();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    break;

                case 7:
                    System.out.println("--------------------Write File--------");
                    try {
                        bookService.writeFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;

                case 8:
                    System.out.println("-----------Exit--------------------");
                    System.exit(0);
            }
        } while (true);

    }
}
