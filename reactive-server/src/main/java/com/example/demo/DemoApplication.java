package com.example.demo;

import com.example.demo.evenodd.EvenOdd;
import com.example.demo.evenodd.ReactiveNumber;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;
import reactor.core.scheduler.Schedulers;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
//        SpringApplication.run(DemoApplication.class, args);

        Flux.<Integer>create(DemoApplication::emitNumber, FluxSink.OverflowStrategy.BUFFER)
                .map(i -> {
                    ReactiveNumber rn = new ReactiveNumber(i);
                    rn.setEvenOdd(
                            i % 2 == 0 ? EvenOdd.EVEN : EvenOdd.ODD
                    );
                    return rn;
                })
                .publishOn(Schedulers.elastic(), true, 1)
                .subscribe(
                        DemoApplication::consume,
                        err -> System.out.println("Error " + err),
                        () -> System.out.println("Done"));

    }

    private static void consume(ReactiveNumber reactiveNumber) {
        System.out.println(reactiveNumber);
        sleep(1000);
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
