package com.example.demo.paradigm;


import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Paradigm {

    private static final int FORTY = 40;
    private static List<Person> people = new ArrayList<>();
    private static Flux<Person> reactivePeople;
    static {
        initializePeople();
    }

    public static void main(String[] args) {
        /**
         * Imperative: how
          */
        for(Person p : people) {
            if(p.getAge() < FORTY) {
                System.out.println(p);
            }
        }

        /**
         * Functional: what
         */
        people.stream()
                .filter(p -> p.getAge() < FORTY)
                .forEach(System.out::println);

        /**
         * Reactive: when + what
         */
        reactivePeople
                .filter(p -> p.getAge() < FORTY)
                .subscribe(System.out::println);

        sleep(10000);
    }

    private static void initializePeople() {
        people.add(new Person("Ironi", 25));
        people.add(new Person("Roggia", 26));
        people.add(new Person("Pedro", 45));
        people.add(new Person("João", 50));

        reactivePeople = Flux.interval(Duration.ofSeconds(1))
                .map(l -> l * 10)
                .map(l -> new Person("name "+l, l.intValue()));
    }

    public static boolean sleep(long millis) {
        try {
            Thread.sleep(millis);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
