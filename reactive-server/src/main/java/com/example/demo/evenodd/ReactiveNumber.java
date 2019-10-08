package com.example.demo.evenodd;

public class ReactiveNumber {

    private int number;
    private EvenOdd evenOdd;

    public ReactiveNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public EvenOdd getEvenOdd() {
        return evenOdd;
    }

    public void setEvenOdd(EvenOdd evenOdd) {
        this.evenOdd = evenOdd;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Number ").
            append(this.number)
            .append(" is ")
            .append(this.evenOdd);

        return sb.toString();
    }
}
