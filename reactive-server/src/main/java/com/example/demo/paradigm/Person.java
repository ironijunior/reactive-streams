package com.example.demo.paradigm;

public class Person {

    private String name;
    private int age;

    Person(String name, int age)
    {
        this.name = name;
        this.age = age;
    }

    int getAge()
    {
        return age;
    }

    @Override
    public String toString()
    {
        return name + ": " + age;
    }

}
