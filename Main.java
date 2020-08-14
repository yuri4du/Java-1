package ru.geekbrains.java_one.lesson_6;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
       // System.out.println(st1.equals(st2)); сравнение строки st1 со строкой st 2

        try {
            FileOutputStream fos0 = new FileOutputStream("text00.txt");
            FileOutputStream fos1 = new FileOutputStream("text00.txt", true);
            fos0.write("I".getBytes());
            fos1.write(" .".getBytes());
//            fos0.write("I have always believed that a man must be honest. Never ask for money you have not earned, I always said. Now I shall tell you a story which will show you how honest I have always been all my life.".getBytes());
//            fos1.write("I went into the hall of the hotel and sat down on a sofa. I was sitting there when a beautiful small dog ran into the hall. It was looking for somebody. The dog was nice and I had nothing to do, so I called it and began to play with it.".getBytes());
            fos0.flush();
            fos1.flush();
            fos0.close();
            fos1.close();

            StringBuilder sb = new StringBuilder("");


//            Scanner scanner = new Scanner(new FileInputStream("text00.txt"));
//            while (scanner.hasNext())
//                System.out.println(scanner.nextLine());


        } catch (IOException e) {
                e.printStackTrace();
        }

        Scanner scanner = new Scanner(System.in);
        String in = scanner.toString();
        checkWord(in);

    }
    private static boolean checkWord (String str){

        try {
            FileInputStream fis = new FileInputStream("text00.txt");
            int b;
            while ( (b = fis.read()) != -1 )
                if
                System.out.print((char)b);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }
}
