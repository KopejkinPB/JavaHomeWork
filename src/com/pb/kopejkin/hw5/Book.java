package com.pb.kopejkin.hw5;

public class Book {

    private static int bookCount = 0;

    public static int getBookCount(){
        return bookCount;
    }

    private String name;
    private String author;
    private int year;

    public Book(String name, String author, int yearPublication) {
        this.name = name;
        this.author = author;
        this.year = yearPublication;
        bookCount++;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getYearPublication() {
        return year;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setYearPublication(int yearPublication) {
        if (yearPublication > 0) {
            this.year = yearPublication;
        } else {
            this.year = 0;
        }
    }

    String getInfo() {
        return "Название: " + name + ", автор: " + author + ", год издания: " + year + " г.";
    }
}