package com.example.demo.paradigm;

import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PlayerParadigm {

    private static final int RETIREMENT_AGE = 35;
    private static List<Player> players = new ArrayList<>();
    private static Flux<Player> playersReactive;

    static {
        initialize();
    }

    public static void main(String[] args) {
        System.out.println("Imperative: ");
        playersToRetireImperative();
        System.out.println("-------------");
        System.out.println("Functional: ");
        playersToRetireFunctional();
        System.out.println("-------------");
        System.out.println("Reactive: ");
        playersToRetireReactive();
    }

    /**
     * Imperative = HOW
     */
    private static void playersToRetireImperative() {
        for (int i = 0; i < players.size(); i++) {
            Player player = players.get(i);

            if (player.getAge() > RETIREMENT_AGE) {
                if (CountryCode.BR.equals(player.getCountry())) {
                    PlayerToRetire toRetire = new PlayerToRetire(player);
                    toRetire.setRetired(true);

                    System.out.println(toRetire);
                }
            }
        }
    }

    /**
     * Imperative = WHAT
     */
    private static void playersToRetireFunctional() {
        players.stream()
            .filter(player -> player.getAge() > RETIREMENT_AGE)
            .filter(player -> CountryCode.BR.equals(player.getCountry()))
            .map(player -> {
                PlayerToRetire toRetire = new PlayerToRetire(player);
                toRetire.setRetired(true);
                return toRetire;
            })
            .forEach(System.out::println);
    }

    /**
     * Imperative = WHEN + WHAT
     */
    private static void playersToRetireReactive() {
        Flux<PlayerToRetire> toRetirePublisher = playersReactive
            .filter(player -> player.getAge() > RETIREMENT_AGE)
            .filter(player -> CountryCode.BR.equals(player.getCountry()))
            .map(player -> {
                PlayerToRetire toRetire = new PlayerToRetire(player);
                toRetire.setRetired(true);
                return toRetire;
            });

        toRetirePublisher.subscribe(System.out::println);
    }

    private static void initialize() {
        players.add(new Player("Arrascaeta", 25, CountryCode.BR));
        players.add(new Player("Pogba", 26, CountryCode.GB));
        players.add(new Player("Ibrahimovic", 38, CountryCode.SE));
        players.add(new Player("Douglas", 37, CountryCode.BR));
        players.add(new Player("Diego Souza", 34, CountryCode.BR));
        players.add(new Player("Tinga", 41, CountryCode.BR));
        players.add(new Player("Túlio Maravilha", 50, CountryCode.BR));
        players.add(new Player("Guiñazu", RETIREMENT_AGE, CountryCode.AR));
        players.add(new Player("Leo Moura", RETIREMENT_AGE, CountryCode.BR));

        playersReactive = Flux.create(playerFluxSink -> {
            Iterator<Player> it = players.iterator();
            while (it.hasNext()) {
                playerFluxSink.next(it.next());
                it.remove();
                sleep(1000);
            }
            playerFluxSink.complete();
        });
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
