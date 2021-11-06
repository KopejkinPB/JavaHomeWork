package com.pb.kopejkin.hw6;

import java.util.Objects;

public class Horse extends Animal {
    private String nameAnimal;
    private String noise;

    public Horse(String name, String noise, String food, String location) {
        this.nameAnimal = name;
        this.noise = noise;
        setFood(food);
        setLocation(location);
    }

    public String getNameAnimal() {
        return nameAnimal;
    }

    @Override
    public void makeNoise() {
        System.out.println(nameAnimal + " издает " + noise + ".");
    }

    @Override
    public void eat() {
        System.out.println(nameAnimal + " ест " + getFood() + ".");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Horse horse = (Horse) o;
        return Objects.equals(nameAnimal, horse.nameAnimal) && Objects.equals(noise, horse.noise);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameAnimal, noise);
    }

    @Override
    public String toString() {
        return "Horse{" +
                "nameAnimal='" + nameAnimal + '\'' +
                ", noise='" + noise + '\'' +
                '}';
    }
}
