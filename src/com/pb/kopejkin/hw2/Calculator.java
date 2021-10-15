package com.pb.kopejkin.hw2;

import java.util.Scanner;
public class Calculator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int operand1;
        int operand2;
        String sign;

        System.out.print("введите первое число");
        operand1 = scan.nextInt();
        System.out.print("введите второе число");
        operand2 = scan.nextInt();
        System.out.print("введите операцию + - * /");
        sign = scan.next();

        switch (sign) {
            case "+":
                System.out.println(+(operand1 + operand2));
                break;
            case "-":
                System.out.println(+(operand1 - operand2));
                break;
            case "*":
                System.out.println(+(operand1 * operand2));
                break;
            case "/":
                if (operand2 == 0)
            {
                System.out.println("На ноль делить нелья");
            }
                else {
                    System.out.println(+(operand1 / operand2));
                }
                break;

        }
    }
}
