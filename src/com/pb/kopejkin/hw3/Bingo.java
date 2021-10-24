package com.pb.kopejkin.hw3;

import java.util.Scanner;


public class Bingo {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int randNum = (int) (Math.random()*100);
        int userNum;
        int counter = 1;

        System.out.println("Отгадайте число от 0 до 100. Для выхода укажите число вне этого диапазона.");

        while (counter > 0) {
            userNum = scan.nextInt();
            if(randNum == userNum) {
                if (counter==3){
                    System.out.println("Вы угадали c " + counter + "-ей попытки");
                } else {
                    System.out.println("Вы угадали c " + counter + "-ой попытки");
                }
                break;
            } else if (randNum < userNum && userNum <= 100) {
                System.out.println("Ваше число больше загаданного");
            } else if (randNum > userNum && userNum >= 0) {
                System.out.println("Ваше число меньше загаданного");
            } else {
                System.out.println("Завершение программы");
                break;
            }
            counter++;
        }

    }

}