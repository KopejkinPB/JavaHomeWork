package com.pb.kopejkin.hw12;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

public class Person implements Serializable {

    private String fio;
    private LocalDate birth;
    private List<String> phones = new ArrayList<>();
    private String address;
    private Date dtEdit;

    public Person() {

    }

    public Person(String fio, LocalDate birth, String address) {
        this.fio = fio;
        this.birth = birth;
        this.address = address;
        this.dtEdit = new Date();
    }

    public Person(String fio, String phone, LocalDate birth, String address) {
        this.fio = fio;
        this.phones.add("+38(0" + phone.substring(0, 2) + ")" + phone.substring(2, 5) + "-" + phone.substring(5, 7) + "-" + phone.substring(7, 9));
        this.birth = birth;
        this.address = address;
        this.dtEdit = new Date();
    }

    public String getFio() {
        return fio;
    }

    public LocalDate getBirth() {
        return this.birth;
    }

    public String getAddress() {
        return address;
    }

    public void edit(String fio, LocalDate bd, String adr) {
        this.fio = fio;
        this.birth = bd;
        this.address = adr;
        this.dtEdit = new Date();
    }

    public void addPhone(String ph) {
        this.phones.add("+38(0" + ph.substring(0, 2) + ")" + ph.substring(2, 5) + "-" + ph.substring(5, 7) + "-" + ph.substring(7, 9));
    }

    public String getPhone() {
        return this.phones.isEmpty()?"(no phones)":this.phones.get(0);
    }

    private String getPhones() {
        // stream!!!
        Optional<String> tmp = this.phones.stream().sorted().reduce((acc, x) -> acc + ", " + x);
        return (this.phones.isEmpty()?"(no phones)":tmp.get());
    }

    public Boolean phoneCheck(String ph) {
        String value = "+38(0" + ph.substring(0, 2) + ")" + ph.substring(2, 5) + "-" + ph.substring(5, 7) + "-" + ph.substring(7, 9);
        return this.phones.contains(value);
    }

    public void removePhones() {
        this.phones.clear();
    }

    public String getInfo() {
        return  "ФИО:           " + fio + ";\n" +
                "Дата рождения: " + birth + ";\n" +
                "Телефоны:      " + getPhones() + ";\n" +
                "Адрес:         " + address + ";\n" +
                "Посл.правка:   " + dtEdit;
    }
}
