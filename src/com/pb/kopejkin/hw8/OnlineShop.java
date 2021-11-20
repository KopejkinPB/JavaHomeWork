package com.pb.kopejkin.hw8;

import java.util.Scanner;

public class OnlineShop {
    public static void main(String[] args) {
        Auth auth = new Auth();

        try {

            Scanner scan = new Scanner(System.in);
            System.out.print("Для регистрации введите логин\n");
            String login = scan.nextLine();
            System.out.print("Введите пароль\n");
            String password = scan.nextLine();
            System.out.print("подтвердите введенный пароль\n");
            String confirmPassword = scan.nextLine();

            auth.signUp(login, password, confirmPassword);

            System.out.print("Спасибо. Регистрация прошла успешно. \n Для входа в кабинет введите логин\n");
            String loginUp = scan.nextLine();
            System.out.print("Введите пароль\n");
            String passwordUp = scan.nextLine();

            auth.signIn(loginUp, passwordUp);
            System.out.printf("Вы вошли в кабинет. Ваш логин = %s", loginUp);
        } catch (WrongLoginException e) {
            e.printStackTrace();
        } catch (WrongPasswordException e) {
            e.printStackTrace();
        }

    }
}
