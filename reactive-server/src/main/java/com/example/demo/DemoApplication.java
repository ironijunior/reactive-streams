package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
//        SpringApplication.run(DemoApplication.class, args);

        Flux.<Integer>create(DemoApplication::emitNumber, FluxSink.OverflowStrategy.BUFFER);

    }

    private static void emitNumber(FluxSink<Integer> integerFluxSink) {
    }
}
