package ru.geekbrains.lesson1;

public class MainApp {
    // 1
    private static float arith(int a, int b, int c, int d) {
        float result = a * (b + (c / d));
        return (result);
    }
    // 2
    private static boolean checkLogic(int e, int f) {
        int sum = e + f;
        if (sum >= 10 && sum <= 20) {
            return(true);
        } return(false);
    }
    // 3
    private static String checkModule(int g) {
        if (g < 0) {return("отрицательное");
        } else {return("положительное");}
    }
    // 4
    private static String helloName(String name) {
        return("Привет, " + name + "!");
    }
    // 5
    private static String checkYear(int y) {
        int k = y % 400;
        int l = y % 4;
        int m = y % 100;
        if (k == 0) { return(y + "-й - високосный.");
        } else if (l == 0 && m != 0) { return(y + "-й - високосный.");
        } else { return(y + "-й - не високосный.");}
    }

    public static void main(String[] args) {
        // 1
        float r = arith(2, 3, 8, 2);
        // 2
        boolean boo = checkLogic(7 , 8);
        // 3
        System.out.println("Введённое число " + checkModule(8));
        // 4
        System.out.println(helloName("Yuriy"));
        // 5
        System.out.println("Год " + checkYear(400));


    }
}
