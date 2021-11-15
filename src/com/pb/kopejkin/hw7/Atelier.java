package com.pb.kopejkin.hw7;

public class Atelier {
    public static void main(String[] args) {
        Clothes[] clothesToDress = new Clothes[4];
        clothesToDress[0] = new Tshirt(Size.L, "белый", 1200);
        clothesToDress[1] = new Pants(Size.M, "розовый", 900);
        clothesToDress[2] = new Skirt(Size.M, "зеленый", 700);
        clothesToDress[3] = new Tie(Size.L, "красный", 400);

        dressWoman(clothesToDress);
        System.out.println();
        dressMan(clothesToDress);
    }

    public static void dressMan(Clothes[] clothes) {
        System.out.println("Мужская одежда в наличии:");

        for (Clothes nextPiece: clothes) {
            if (nextPiece instanceof MenClothes) {
                ((MenClothes)nextPiece).dressMan();
            }
        }
    }

    public static void dressWoman(Clothes[] clothes) {
        System.out.println("Женская одежда в наличии:");

        for (Clothes nextPiece: clothes) {
            if (nextPiece instanceof WomenClothes) {
                ((WomenClothes)nextPiece).dressWoman();
            }
        }
    }
}