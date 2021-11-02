package com.pb.kopejkin.hw5;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Reader {

    private String name;
    private int number;
    private String faculty;
    private String dateBirth;
    private String phone;

    public Reader(String name, int number, String faculty, String dateBirth, String phone) {
        this.name = name;
        this.number = number;
        this.faculty = faculty;
        this.dateBirth = dateBirth;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public String getFaculty() {
        return faculty;
    }

    public String getDateBirth() {
        return dateBirth;
    }

    public String getPhone() {
        return phone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public void setDateBirth(String dateBirth) {
        this.dateBirth = dateBirth;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    String getInfo() {
        return "ФИО: " + name + ", номер читательского билета " + number + ", факультет: " + faculty + ", год рождения: "
                + dateBirth + ", тел: +38" + phone;
    }

    public void takeBook(int bookCounter) {
        System.out.println(name + " взял " + bookCounter + " книги.");
    }

    public void takeBook(String... names) {
        String nameList = String.join(", ", names);
        System.out.println(name + " взял книги: " + nameList + ".");
    }

    public void takeBook(Book... books) {
        String[] bookList = new String[books.length];
        int i = 0;
        for (Book book : books) {
            bookList[i] = book.getName() + "(" + book.getAuthor() + " " + book.getYearPublication() + " г.)";
            i++;
        }
        System.out.print(name + " взял книги: ");
        System.out.println(String.join(", ", bookList) + ".");
    }

    public void returnBook(int bookCounter) {
        System.out.println(name + " вернул " + bookCounter + " книги.");
    }

    public void returnBook(String... names) {
        System.out.print(name + " вернул книги: ");
        for (String name : names) {
            System.out.print(name + ", ");
        }
        System.out.println("\b\b.");
    }

    public void returnBook(Book... books) {
        System.out.print(name + " вернул книги: ");
        for (Book book : books) {
            System.out.print(book.getName() + "(" + book.getAuthor() + " " + book.getYearPublication() + "), ");
        }
        System.out.println("\b\b.");
    }


}
