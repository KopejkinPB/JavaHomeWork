package com.pb.kopejkin.hw7;

public class Pants extends Clothes implements MenClothes, WomenClothes {
    public Pants(Size size, String color, int price) {
        super(size, color, price);
    }

    @Override
    public void dressWoman() {
        System.out.println("Женские штаны, " + this);
    }

    @Override
    public void dressMan() {
        System.out.println("Мужские штаны, " + this);
    }
}