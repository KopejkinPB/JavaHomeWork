package com.pb.kopejkin.hw5;

public class Library {
    public static void main(String[] args) {
        Book[] books = new Book[3];
        books[0] = new Book("Сияние", "Стивен Кинг",1980);
        books[1] = new Book("Робинзон крузо", "Даниель Дефо", 1719);
        books[2] = new Book("Словарь", "В.Даль", 1996);

        Reader[] readers = new Reader[3];
        readers[0] = new Reader("Иванов В.В.", 2, "Физико-технический", "16.12.2000", "0993799921");
        readers[1] = new Reader("Петров П.П.", 1, "Экономический","12.12.2000","0501111111");
        readers[2] = new Reader("Сидоров Я.И.", 3, "Журналистика","04.05.1998","0502222222");

        for (int i = 0; i < books.length; ++i){
            System.out.println(books[i].getInfo());
        }
        System.out.println();

        for (int i = 0; i < readers.length; ++i){
            System.out.println(readers[i].getInfo());
        }
        System.out.println();

        readers[1].takeBook(Book.getBookCount());
        readers[2].takeBook(books[1].getName(), books[2].getName(), books[0].getName());
        readers[0].takeBook(books[1], books[2], books[0]);
        System.out.println();

        readers[0].returnBook(Book.getBookCount());
        readers[1].returnBook(books[1].getName(), books[2].getName(), books[0].getName());
        readers[2].returnBook(books[1], books[2], books[0]);
    }
}
