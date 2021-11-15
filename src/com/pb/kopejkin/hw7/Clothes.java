package com.pb.kopejkin.hw7;

public abstract class Clothes {
    protected Size size;
    protected String color;
    protected int price;

    protected Clothes(Size size, String color, int price) {
        this.size = size;
        this.color = color;
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("размер: %s (%d), цвет: %s, цена: %d",
                size, size.getEuroSize(), color, price);
    }
}
