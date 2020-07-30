import java.util.Arrays;

public class lesson2 {

/* Author - Dubtsev Yuriy */

    /* 1 Задать целочисленный массив, состоящий из элементов 0 и 1.
    Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. Написать метод,
    заменяющий в принятом массиве 0 на 1, 1 на 0; */

    private static void checkAr1(int[] ar1) {
        int i;
        int j = ar1.length;
        // System.out.println(Arrays.toString(ar1)); //для проверки работы метода
        for (i = 0; i < j; i++) {
            if (ar1[i] == 0) {
                ar1[i] = 1;
            } else { ar1[i] = 0;}
        }
        // System.out.print(Arrays.toString(ar1)); // для проверки работы метода
    }

    /* 2 Задать пустой целочисленный массив размером 8. Написать метод,
    который помощью цикла заполнит его значениями 1 4 7 10 13 16 19 22; */

    private static void checkAr2(int[] ar2) {
        int i = 0;
        int j = 1;
        int k = ar2.length;
        for (i = 0; i < k; i++) {
            ar2[i] = j + i * 3;
        }
        // System.out.println(Arrays.toString(ar2)); // для проверки работы метода
    }

    /* 3 Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ], написать метод,
     принимающий на вход массив и умножающий числа меньше 6 на 2; */

    private static void checkAr3(int[] ar3) {
        int i = 0;
        for (i = 0; i < ar3.length; i++) {
            if (ar3[i] < 6) {
                ar3[i] *= 2;
            }
        }
        // System.out.println(Arrays.toString(ar3)); // для проверки работы метода
    }

    /* 4 Задать одномерный массив. Написать методы поиска в нём
    минимального и максимального элемента; */

    private static void minAr4(int[] ar4) {
        Arrays.sort(ar4);
        int minNumb = ar4[0];
        // System.out.println(minNumb); // для проверки работы метода
    }

    private static void maxAr4(int[] ar4) {
        Arrays.sort(ar4);
        int i = ar4.length;
        int maxNumb = ar4[i - 1];
        // System.out.println(maxNumb); // для проверки работы метода
    }

    /* 5 * Создать квадратный целочисленный массив
    (количество строк и столбцов одинаковое), заполнить его
    диагональные элементы единицами, используя цикл(ы); */

    private static void fillTable(int[][] table) {
        int counter = 0;
        int i = 0;
        int rev = table[i].length - 1;
        for (i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                if (i == j) {
                    table[i][j] = 1;
                } else if (j == rev) {
                    table[i][rev] = 1;
                    rev--;
                } else {table[i][j] = counter;}
                // System.out.print(table[i][j] + "  "); // для проверки работы метода
            } if (i == rev) {
                table[i][rev] = 1;
                rev--;
            }
            // System.out.println(); // для проверки работы метода
        }
    }

    /* 6 ** Написать метод, в который передается не пустой одномерный целочисленный массив,
     метод должен вернуть true если в массиве есть место, в котором сумма левой и правой
     части массива равны. Примеры: checkBalance([1, 1, 1, 2, 1]) → true,
     checkBalance ([2, 1, 1, 2, 1]) → false, checkBalance ([10, 1, 2, 3, 4]) → true. */

    private static boolean checkBalance(int[] ar6) {
        int i = 0;
        int j = 0;
        int sumL = 0;
        int sumR = 0;
        for (i = 0; i < ar6.length; i++) {
                sumL += ar6[i];
        }
        for (j = i - 1; j >=0; j--) {
            sumL -= ar6[j];
            sumR += ar6[j];
            if (sumL == sumR) {
                return((sumL == sumR));
            }
        }
        return((sumL == sumR));
    }

    /* 7. **** Написать метод, которому на вход подается одномерный
    массив и число n (может быть положительным, или отрицательным),
    при этом метод должен сместить все элементымассива на n позиций.
    Для усложнения задачи нельзя пользоваться вспомогательными массивами. */

    private static void changePosition(int[] ar7, int n) {
        int l = ar7.length - 1;
        if (n > 0) {
            for (int j = 0; j < n; j++) {
                int temp = ar7[l];
                for (int i = l; i > 0; i--) {
                    ar7[i] = ar7[i - 1];
                } ar7[0] = temp;
            }
        } else {
            n *= -1;
            for (int i = 0; i < n; i++) {
                int temp = ar7[0];
                for (int j = 0; j < l; j++) {
                    ar7[j] = ar7[j + 1];
                } ar7[l] = temp;
            }
        }
        // System.out.println("New array");          // для проверки работы метода
        // System.out.println(Arrays.toString(ar7)); // для проверки работы метода
    }





    public static void main(String[] args) {

        // 1
        int[] ar1 = {1, 1, 0, 0, 1, 0, 1, 0, 0, 1, 1};
        checkAr1(ar1);

        // 2
        int[] ar2 = new int[8];
        checkAr2(ar2);

        // 3
        int[] ar3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        checkAr3(ar3);

        // 4
        int[] ar4 = {12, 5, 3, 2, 11, 4, 5, 23, 4, 8, 9, 1};
        minAr4(ar4);
        maxAr4(ar4);

        // 5
        int[][] table = new int[9][9];
        fillTable(table);

        // 6
        int[] ar6 = {9, 1, 4, 3 , 2, 1};
        checkBalance(ar6);

        // 7
        int[] ar7 = {1, 2, 3, 4, 5};
        int n = -2;
        // System.out.println(Arrays.toString(ar7)); // для проверки работы метода
        changePosition(ar7, n);
    }




}
