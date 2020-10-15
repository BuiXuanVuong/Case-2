package service;

import model.Book;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BookService {
   public  static List<Book> bookList = new ArrayList<>();
   int positionPhone;
   static {
       bookList.add(new Book(123,"Company","Peter","Male","USA","peter@mail.com"));
       bookList.add(new Book(456,"Company","John","Male","USA","John@mail.com"));
       bookList.add(new Book(789,"Company","Kenvin","Male","USA","peter@mail.com"));
   }


   public List<Book> findAllBook() {
       List<Book> list = new ArrayList<>();
       Iterator<Book> iterator = bookList.iterator();
       while (iterator.hasNext()) {
           list.add(iterator.next());
       }
       return list;
   }

   public void addBook(Book book) {
       if(!checkPhone(book.getPhone())) {
           bookList.add(book);
       }
   }

   public void editBook(int phone, Book newBook) {
       if(checkPhone(phone)) {
           bookList.set(positionPhone,newBook);
       }
   }

   public Book deleteBook(int phone) {
       if(checkPhone(phone)) {
           Book book;
           book = bookList.get(positionPhone);
           bookList.remove(positionPhone);
           return book;
       }
       return null;
   }

   public Book findByPhone(int phone) {
       if(checkPhone(phone)) {
           return bookList.get(positionPhone);
       }
       return null;
   }

//   public List<Book> findByName(String name) {
//       List<Book> nameList = new ArrayList<>();
//       for (int i = 0; i < bookList.size(); i++) {
//           if(bookList.get(i).getName().equalsIgnoreCase(name)) {
//               nameList.add(bookList.get(i));
//           }
//       }
//       return nameList;
//   }

    public void readFile() throws FileNotFoundException {
       String csvFile = "contacts1.csv";
       String line = "";
       String cvsSplitBy = ",";
       FileReader fr = null;
       BufferedReader br = null;

       fr = new FileReader(csvFile);
       br = new BufferedReader(fr);

        try {
            fr = new FileReader(csvFile);
            br = new BufferedReader(fr);
            while ((line = br.readLine()) != null) {
                String[] book = line.split(cvsSplitBy);
                System.out.println("Book [phone= " + book[0] + " group = " + book[1]+  " , name=" + book[2] + " , gender=" + book[3] + " , address=" + book[4] + " , email=" + book[5] +"]");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void writeFile() throws IOException {
       File file = new File("contacts1.csv");
       FileWriter fw = new FileWriter(file);

       String[] arrStr = new String[bookList.size()];

        for (int i = 0; i < bookList.size(); i++) {
            arrStr[i] =  bookList.get(i).getPhone()+ "," + bookList.get(i).getName()  + "," + bookList.get(i).getGroup() + "," + bookList.get(i).getGender() + "," + bookList.get(i).getAddress() + "," + bookList.get(i).getEmail() + "\n";
            fw.write(arrStr[i]);
        }
        fw.close();
    }


   public boolean checkPhone(int phone) {
       List<Integer> phoneList = new ArrayList<>();

       for (int i = 0; i < bookList.size(); i++) {
           phoneList.add(bookList.get(i).getPhone());
       }

       if(phoneList.contains(phone)) {
           positionPhone = phoneList.indexOf(phone);
           return true;
       } else {
           return false;
       }
   }

//    public static void main(String[] args) {
//        BookService bookService = new BookService();
//        System.out.println(bookService.checkPhone(789));
//        System.out.println(bookService.positionPhone);
//
//    }

}
