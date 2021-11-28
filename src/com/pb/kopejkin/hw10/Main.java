package com.pb.kopejkin.hw10;


public class Main {
    public static void main(String[] args) {
        System.out.println("Integer: ");
        NumBox<Integer> intArr = new NumBox<>(3);
        intArr.add(4);
        intArr.add(18);
        intArr.add(15);
        intArr.add(40);
        System.out.println("Размер массива: " + intArr.length());
        System.out.println("Сумма элементов: " + intArr.sum());
        System.out.println("Среднее значение: " + intArr.average());
        System.out.println("Максимальное значение: " + intArr.max()+"\n");

        System.out.println("Float: ");
        NumBox<Float> floatArr = new NumBox<>(4);
        floatArr.add(1.35f);
        floatArr.add(2.8f);
        floatArr.add(5.1f);
        floatArr.add(9.57f);
        System.out.println("Размер массива: " + floatArr.length());
        System.out.println("Сумма элементов: " + floatArr.sum());
        System.out.println("Среднее значение: " + floatArr.average());
        System.out.println("Максимальное значение: " + floatArr.max());
    }
}
