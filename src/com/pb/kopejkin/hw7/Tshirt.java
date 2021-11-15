package com.pb.kopejkin.hw7;

public class Tshirt extends Clothes implements MenClothes, WomenClothes {
    public Tshirt(Size size, String color, int price) {
        super(size, color, price);
    }

    @Override
    public void dressWoman() {
        System.out.println("Женская футболка, " + this);
    }

    @Override
    public void dressMan() {
        System.out.println("Мужская футболка, " + this);
    }
}
