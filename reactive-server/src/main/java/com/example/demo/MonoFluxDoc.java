package com.example.demo;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.function.Function;

public class MonoFluxDoc {

    public static void main(String[] args) {
        Mono<String> monoString = Mono.just("TDC POA");

        Flux<String> fluxString = Flux.just("TDC BH",
                "TDC Floripa",
                "TDC SP",
                "TDC Recife").map(Function.identity());


    }
}
