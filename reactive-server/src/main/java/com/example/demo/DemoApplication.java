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
        var count = 0;

        while (count < 10) {
            count++;
            System.out.println("Emitting... " + count);
            integerFluxSink.next(count);
            sleep(500);
        }

        integerFluxSink.complete();
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
