package ru.geekbrains.com;

public class Main {
    public static void main(String[] args) {


        Personnel p0 = new Personnel("Иванов И.И.", 1000, 25);
        Personnel p1 = new Personnel("Петров П.П.", 2000, 30);
        Personnel p2 = new Personnel("Сидоров С.С.", 5000, 50);
        Personnel p3 = new Personnel("Бобров Б.Б.", 4000, 46);
        Personnel p4 = new Personnel("Кроликов К.К.", 3000, 35);
        //System.out.printf("Personnel: %s has %d at age %d\n",
        //        p0.getFullName(), p0.getSalary(), p0.getAge());

        System.out.printf("Personnel: %s at age %d\n", p0.getFullName(), p0.getAge());
        System.out.printf("Personnel: %s at age %d\n", p1.getFullName(), p1.getAge());
        System.out.printf("Personnel: %s at age %d\n", p2.getFullName(), p2.getAge());
        System.out.printf("Personnel: %s at age %d\n", p3.getFullName(), p3.getAge());
        System.out.printf("Personnel: %s at age %d\n", p4.getFullName(), p4.getAge());

        System.out.println();
        // не уверен, что правильно выполнил задание 5 (ниже код)
        String[] arrPers = {"Иванов И.И.", "Петров П.П.", "Сидоров С.С.", "Бобров Б.Б.", "Кроликов К.К."};
        int[] arrSalary = {1000, 2000, 5000, 4000, 3000};
        int[] arrAge = {25, 30, 50, 45, 35};

        for (int i = 0; i < arrAge.length - 1; i++) {
            if (arrAge[i] > 40) {
                System.out.println("Personnel: " + arrPers[i] + " has " + arrSalary[i] + " at his age " + arrAge[i]);
            }

        }

        System.out.println();

        p0.setSalary(5000);
        p1.setSalary(5000);
        p2.setSalary(5000);
        p3.setSalary(5000);
        p4.setSalary(5000);

        // System.out.printf("Personnel: %s has %d at age %d\n", p2.getFullName(), p2.getSalary(), p2.getAge());

        // System.out.printf("Personnel: %s has %d at age %d\n", p3.getFullName(), p3.getSalary(), p3.getAge());
        int sum = 0;
        for (int i = 0; i < arrSalary.length; i++) {
            sum += arrSalary[i];
        }
        int arithSalary = sum / arrSalary.length;
        System.out.println("Средняя зарплата " + arithSalary);

        sum = 0;
        for (int i = 0; i < arrAge.length; i++) {
            sum += arrAge[i];
        }
        int arithAge = sum / arrAge.length;
        System.out.println("Средний возраст " + arithAge);

    }

}
