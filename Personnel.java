package ru.geekbrains.com;

public class Personnel {
    private String fullName;
    private int salary;
    private int age;



    Personnel(String fullName, int salary, int age) {
        this.fullName = fullName;
        this.salary = salary;
        this.age = age;
    }

   /* Personnel(String fullName, int age) {
        this.fullName = fullName;
        this.age = age;
    }*/

    public String getFullName() {
        return this.fullName;
    }

    public int getSalary() {
        return this.salary;
    }

    public int getAge() {
        return this.age;
    }


    public void setSalary(int grow) {
        if (this.getAge() > 45) this.salary = salary + grow;

    }
}
