package ru.geekbrains.java_one.lesson_5.homework;

public class Main {

    public static void main(String[] args) {

        Cat c0 = new Cat("Барсик", "белый", 200, 0, 2.2);
        Cat c1 = new Cat("Мурзик", "черный", 160, 0, 1.8);
        Cat c2 = new Cat("Пушок", "серый", 100, 0, 1.95);
        Cat c3 = new Cat("Рыжик", "рыжий", 130, 0, 1.65);
        Dog d0 = new Dog("Тузик", "серый", 400, 10, 0.65);
        Dog d1 = new Dog("Бобик", "бело-серый", 500, 8, 0.55);
        Dog d2 = new Dog("Полкан", "черно-белый", 450, 6, 0.4);
        Dog d3 = new Dog("Черныш", "черный", 350, 5, 0.45);

        Animal[] zoo = {c0, c1, c2, c3, d0, d1, d2, d3};
        System.out.println();
        System.out.println("ДОБРО ПОЖАЛОВАТЬ НА СОРЕВНОВАНИЯ!");
        System.out.println("Приветствуем всех участников!");
        System.out.println();
        System.out.println("В соревнованиях принимают участие следующие животные:");
        System.out.println();

        for (int i = 0; i < zoo.length; i++) {
            System.out.println(zoo[i].name + " окрас " + zoo[i].color);
        }

        System.out.println("-------------------------------------------------------");
        System.out.println("Результаты соревнований по бегу:");
        for (int i = 0; i < zoo.length; i++) {
            zoo[i].run(150);
        }

        System.out.println("-------------------------------------------------------");
        System.out.println("Результаты соревнований по плаванию:");
        for (int i = 0; i < zoo.length; i++) {
            zoo[i].swim(7);
        }

        System.out.println("-------------------------------------------------------");
        System.out.println("Результаты соревнований по запрыгиванию на препятствие:");
        for (int i = 0; i < zoo.length; i++) {
            zoo[i].jump(0.6);
        }

        System.out.println("-------------------------------------------------------");
        System.out.println("Поздравляем участников с завершением соревнований!");
    }

}
