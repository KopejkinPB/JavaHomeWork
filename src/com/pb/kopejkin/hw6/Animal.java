package com.pb.kopejkin.hw6;

public class Animal {
    private String food = "еду";
    private String location = "где-то";

    public void setFood(String food) {
        this.food = food;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getFood() {
        return food;
    }

    public String getLocation() {
        return location;
    }

    public void makeNoise() {
        System.out.println("Животное издает звук.");
    }

    public void eat() {
        System.out.println("Животное ест " + food + ".");
    }

    public void sleep(String animal) {
        System.out.println(animal + " спит " + location + ".");
    }
}