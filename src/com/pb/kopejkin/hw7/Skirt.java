package com.pb.kopejkin.hw7;

public class Skirt extends Clothes implements WomenClothes {
    public Skirt(Size size, String color, int price) {
        super(size, color, price);
    }

    @Override
    public void dressWoman() {
        System.out.println("Юбка, " + this);
    }
}
