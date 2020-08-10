package ru.geekbrains.java_one.lesson_5.homework;

public class Animal {
    protected String name;
    protected String color;
    protected int runSize;
    protected int swimSize;
    protected double jumpSize;

    protected Animal(String name, String color, int runSize, int swimSize, double jumpSize) {
        this.name = name;
        this.color = color;
        this.runSize = runSize;
        this.swimSize = swimSize;
        this.jumpSize = jumpSize;
    }

    public void run(int runSize) {
        if (this.runSize > runSize) {
            System.out.println(this.name + " пробежал " + runSize + " метров");
        } else {System.out.println(this.name + " не смог пробежать " + runSize + " метров");}
    }

    public void swim(int swimSize) {
        if (this.swimSize > swimSize) {
            System.out.println(this.name + " проплыл " + swimSize + " метров");
        } else if (this.swimSize == 0) {
            System.out.println(this.name + " отказался участвовать в этом соревновании, так как не умеет плавать");
        } else { System.out.println(this.name + " не смог проплыть " + swimSize + " метров");}
    }

    public void jump(double jumpSize) {
        if (this.jumpSize > jumpSize) {
            System.out.println(this.name + " запрыгнул на препятствие высотой " + jumpSize + " м");
        } else {System.out.println(this.name + " не смог запрыгнуть на препятствие высотой " + jumpSize + " м");}
    }
}
