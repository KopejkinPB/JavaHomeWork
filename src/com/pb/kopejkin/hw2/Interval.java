package com.pb.kopejkin.hw2;

import java.util.Scanner;

public class Interval {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int x;
        System.out.print("Введите число от 0 до 100");
        x = scan.nextInt();

        if (x >= 0 && x <= 14) {
            System.out.print("Диапазон [0-14]");
        }
        if (x >= 15 && x <= 35) {
            System.out.print("Диапазон [15-35]");
        }
        if (x >= 36 && x <= 50) {
            System.out.print("Диапазон [36-50]");
        }

        if (x >= 51 && x <= 100) {
            System.out.print("Диапазон [51-100]");
        }
        else if (x<=0 || x > 100){
            System.out.print("Ошибка. Введите число от 1 до 100");
        }

    }
    }