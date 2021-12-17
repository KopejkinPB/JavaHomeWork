package com.pb.kopejkin.hw11;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

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

    public String getFioBD() {
        return String.format("%0$-30s | %s", (fio.length()>30)?fio.substring(0, 30):fio, birth.toString());
    }

    public void addPhone(String ph) {
        this.phones.add("+38(0" + ph.substring(0, 2) + ")" + ph.substring(2, 5) + "-" + ph.substring(5, 7) + "-" + ph.substring(7, 9));
    }

    public void removePhones() {
        this.phones.clear();
    }

    public String getInfo() {
        return  "ФИО:           " + fio + ";\n" +
                "Дата рождения: " + birth + ";\n" +
                "Телефоны:      " + phones + ";\n" +
                "Адрес:         " + address + ";\n" +
                "Посл.правка:   " + dtEdit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(fio, person.fio) || Objects.equals(birth, person.birth) || Objects.equals(address, person.address);
    }
}
