package com.example.demo.evenodd;

public class ReactiveNumber {

    private long number;
    private EvenOdd evenOdd;

    public ReactiveNumber(long number) {
        this.number = number;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
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
