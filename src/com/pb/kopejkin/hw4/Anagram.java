package com.pb.kopejkin.hw4;

import java.util.Arrays;
import java.util.Scanner;


public class Anagram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите первую строку:");

        String str = scanner.nextLine();
        System.out.println("Введите вторую строку:");
        String Anagram = scanner.nextLine();;

        isAnagram(str, Anagram);


    }

    static void isAnagram(String s1, String s2) {
        String str = cleaningText(s1);
        String str1 = cleaningText(s2);

        if (str.length() != str1.length()) {
            System.out.println("Данные строки не являются аннограмой");
        }

        char[] c1 = str.toCharArray();
        char[] c2 = str1.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        String sc1 = new String(c1);
        String sc2 = new String(c2);

        if (sc1.equals(sc2)) {
            System.out.println("Данные строки являются аннограмой");
        } else
            System.out.println("Данные строки не являются аннограмой");
    }

    static String cleaningText(String s) {
        String str = "";
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            if (c1 != ' ' && c1 != ',' && c1 != '.' && c1 != '-') {
                str = str + s.substring(i, i + 1).toLowerCase();
            } else {
                continue;
            }
        }
        return str;
    }
}
