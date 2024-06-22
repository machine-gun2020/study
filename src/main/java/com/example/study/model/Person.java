package com.example.study.model;

public class Person {
    public String name;
    public int age;
    public char sex;

    public Person(String charly, int i, char m) {
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public char getSex() {
        return sex;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }

}
