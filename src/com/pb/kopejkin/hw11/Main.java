package com.pb.kopejkin.hw11;


import java.io.*;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Person> persons = new ArrayList<>();
    private static String mainMenu = "MAIN MENU \n v - more info; a - add; s - search; f - sort by fio; b - sort by birth; w - write to file; r - read from file; q - quit";
    private static String recordMenu = " PERSON MENU \n r - remove; e - edit; a - add phone; d - delete all phones; q - back to main manu";

    public static void printRecords() {
        for (int i = 1; i <= persons.size(); i++)
        {
            System.out.println(i + ": " + persons.get(i - 1).getFioBD());
        }
    }

    public static void toFile() throws Exception {
        File file = Paths.get("person.data").toFile();
        FileOutputStream outputStream = new FileOutputStream(file);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

        objectOutputStream.writeObject(persons);

        objectOutputStream.close();
    }

    public static void fromFile() throws Exception {
        File file = Paths.get("person.data").toFile();
        FileInputStream fileInputStream = new FileInputStream(file);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        persons.clear();
        persons = (List<Person>) objectInputStream.readObject();
    }

    public static void main(String[] args) {

        persons.add(new Person("Кириченок Василий Федорович", LocalDate.of(1993, 1, 18), "Магнитогорская, 14"));
        persons.add(new Person("Павлов Павел Иванович", LocalDate.of(1987, 8, 27), "Васильевская 5, 22"));
        persons.add(new Person("Елисеев Петр Семенович", LocalDate.of(1976, 6, 22), "Сташкова, 36"));
        persons.add(new Person("Илизар Макар Иванович", LocalDate.of(1998, 4, 18), "Кировская, 997"));
        persons.add(new Person("Радионов Радион Радионович", LocalDate.of(1974, 7, 14), "Александровская, 4"));

        System.out.println();
        Scanner in = new Scanner(System.in);
        String value, fio, adr;
        LocalDate bd;
        char ch;
        int num;
        Person person = new Person();

        printRecords();
        System.out.println(mainMenu);
        while (true) {
            ch = in.next().charAt(0);
            if (ch == 'q' || ch == 'Q') break;
            switch (ch) {
                case 'S':
                case 's':
                case 'V':
                case 'v': {
                    num = -1;
                    if (ch == 'V' || ch == 'v') {
                        System.out.print("Enter a rec number: ");
                        value = in.next();
                        try {
                            num = Integer.parseInt(value);
                            if (num > persons.size()) {
                                System.out.println("Out of bound.");
                                break;
                            }
                        } catch (NumberFormatException ex) {
                            System.out.println("Not a number!");
                            break;
                        }
                    };
                    if (ch == 'S' || ch == 's') {
                        System.out.print("Search by: 1 - fio, 2 - birthdate, 3 - address: ");
                        ch = in.next().charAt(0);
                        in.nextLine();
                        System.out.print("Enter search line: ");
                        value = in.nextLine();
                        if (ch == '1')  person = new Person(value, LocalDate.of(1970, 1, 1), "");
                        else if (ch == '2')  person = new Person("", LocalDate.parse(value), "");
                        else if (ch == '3')  person = new Person("", LocalDate.of(1970, 1, 1), value);
                        num = persons.indexOf(person) + 1;
                    }
                    if (num == -1) break;
                    System.out.println(persons.get(num - 1).getInfo());
                    System.out.println(recordMenu);
                    while (true) {
                        ch = in.next().charAt(0);
                        if (ch == 'q' || ch == 'Q') break;
                        if (ch == 'r' || ch == 'R') {
                            persons.remove(num - 1);
                            break;
                        }
                        switch (ch) {
                            case 'A':
                            case 'a': {
                                System.out.print("Enter a phone number (9 digits): ");
                                value = in.next();
                                if (value.length() == 9) persons.get(num - 1).addPhone(value);
                                else System.out.println("Not 9 digits");
                                break;
                            }
                            case 'D':
                            case 'd': {
                                persons.get(num - 1).removePhones();
                                break;
                            }
                            case 'E':
                            case 'e': {
                                in.nextLine();
                                fio = persons.get(num -1).getFio();
                                bd = persons.get(num -1).getBirth();
                                adr = persons.get(num -1).getAddress();
                                System.out.println("Enter new values, or empty if not change");
                                System.out.println("Fio (old value): " + fio);
                                System.out.print("Enter new fio: ");
                                value = in.nextLine();
                                fio = (value.isEmpty())?fio:value;
                                System.out.println("Birthdate (old value): " + bd);
                                System.out.print("Enter new birthdate (in format \"yyyy-mm-dd\"): ");
                                value = in.nextLine();
                                bd = (value.isEmpty())?bd:LocalDate.parse(value);
                                System.out.println("Adress (old value): " + adr);
                                System.out.print("Enter new address: ");
                                value = in.nextLine();
                                adr = (value.isEmpty())?adr:value;
                                persons.get(num -1).edit(fio, bd, adr);
                                break;
                            }
                        }
                        System.out.println(persons.get(num - 1).getInfo());
                        System.out.println(recordMenu);
                    }
                    break;
                }
                case 'A':
                case 'a': {
                    in.nextLine();
                    System.out.print("Enter Fio: ");
                    fio = in.nextLine();
                    System.out.print("Enter Birthdate (in format \"yyyy-mm-dd\"): ");
                    value = in.nextLine();
                    bd = LocalDate.parse(value);
                    System.out.print("Enter an adress: ");
                    adr = in.nextLine();
                    persons.add(new Person(fio, bd, adr));
                    break;
                }
                case 'F':
                case 'f': {
                    persons.sort(new Comparator<Person>() {
                        @Override
                        public int compare(Person o1, Person o2) {
                            return o1.getFio().compareTo(o2.getFio());
                        }
                    });
                    break;
                }
                case 'B':
                case 'b': {
                    persons.sort(new Comparator<Person>() {
                        @Override
                        public int compare(Person o1, Person o2) {
                            return o1.getBirth().compareTo(o2.getBirth());
                        }
                    });
                    break;
                }
                case 'W':
                case 'w': {
                    try {
                        toFile();
                    }  catch (Exception ex) {}
                }
                case 'R':
                case 'r': {
                    try {
                        fromFile();
                    } catch (Exception ex) {}
                }
            }
            printRecords();
            System.out.println(mainMenu);
        }

    }
}