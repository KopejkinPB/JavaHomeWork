package com.pb.kopejkin.hw7;

public class Tie extends Clothes implements MenClothes {
    public Tie(Size size, String color, int price) {
        super(size, color, price);
    }

    @Override
    public void dressMan() {
        System.out.println("Галстук, " + this);
    }
}
