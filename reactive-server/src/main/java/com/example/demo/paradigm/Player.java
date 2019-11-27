package com.example.demo.paradigm;

import java.util.Locale;

public class Player {

    private String name;
    private int age;
    private CountryCode country;

    Player(String name, int age, CountryCode country) {
        this.name = name;
        this.age = age;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public CountryCode getCountry() {
        return country;
    }

    public void setCountry(CountryCode country) {
        this.country = country;
    }
}
