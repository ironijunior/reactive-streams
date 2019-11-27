package com.example.demo.paradigm;

public class PlayerToRetire {

    private String name;
    private int age;
    private CountryCode country;
    private boolean isRetired;

    PlayerToRetire() {

    }
    PlayerToRetire(Player player) {
        this.name = player.getName();
        this.age = player.getAge();
        this.country = player.getCountry();
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

    public void setRetired(boolean isRetired) {
        this.isRetired = isRetired;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PlayerToRetire{");
        sb.append("name='").append(name).append('\'');
        sb.append(", age=").append(age);
        sb.append(", country=").append(country);
        sb.append('}');
        return sb.toString();
    }
}
