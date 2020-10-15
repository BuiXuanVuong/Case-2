package model;

import java.util.Scanner;

public class Book {
   private int phone;
   private String group;
   private String name;
   private String gender;
   private String address;
   private String email;


   public Book() {

   }
    public Book(int phone, String group, String name, String gender, String address, String email) {
        this.phone = phone;
        this.group = group;
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.email = email;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Book inputBook(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Input phone");
        phone = sc.nextInt();
        sc.nextLine();
        System.out.println("Input group");
        group = sc.nextLine();
        System.out.println("Input name");
        name = sc.nextLine();
        System.out.println("Input gender");
        gender = sc.nextLine();
        System.out.println("Input address");
        address = sc.nextLine();
        System.out.println("Input email");
        email = sc.nextLine();

        Book book = new Book(phone, group, name, gender, address, email);
        return book;

    }

    @Override
    public String toString() {
        return "model.Book{" +
                "phone=" + phone +
                ", group='" + group + '\'' +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                '}';
    }


}
