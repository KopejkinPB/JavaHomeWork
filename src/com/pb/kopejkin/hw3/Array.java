package com.pb.kopejkin.hw3;

import java.util.Scanner;

public class Array {
    public static void main(String[] args) {
        int[] array = new int[10];
        System.out.println("Поочередно введите значения массива(положительные и отрицательные числа) ");
        Scanner console = new Scanner(System.in);
        for (int i = 0; i < array.length; i++) {
            System.out.print(i+1 + ": ");
            array[i] = console.nextInt();
        }

        System.out.println("Наш массив:");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
        int sum = 0;
        for(int i = 0; i < array.length; i++){
            sum = sum + array[i];
        }

        System.out.println("\nСумма чисел массива: " + sum);


        for (int i = 0; i < (array.length-1); i++){
            for (int j =0; j<(array.length-1-i); j++){
                if (array[j] > array[j+1]){
                    int tmp = array[j];
                    array[j]=array[j+1];
                    array[j+1]=tmp;
                }
            }
        }

        System.out.println(" \nНаш массив после сортировки:");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");

        }
        int count = 0;
        for(int i = 0; i <array.length; i++){
            if(array[i] >= 0){
                count++;
            }
        }
        System.out.println("\nКоличество положительных элементов: " + count);

    }

}