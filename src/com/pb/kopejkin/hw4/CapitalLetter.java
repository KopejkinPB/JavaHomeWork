package com.pb.kopejkin.hw4;

import java.util.Scanner;
public class CapitalLetter {

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите фразу");
        String s = sc.nextLine();
        System.out.println(toUp(s));

    }
    public static String toUp(String s)
    {
        char[] result = s.toCharArray();
        if(Character.isAlphabetic(result[0]))result[0]=Character.toUpperCase(result[0]);
        String res=""+result[0];
        for(int i=1;i<result.length;i++)
        {
            if(Character.isAlphabetic(result[i]) && !Character.isAlphabetic(result[i-1]))result[i]=Character.toUpperCase(result[i]);
            res+=result[i];
        }
        return res;
    }
}

