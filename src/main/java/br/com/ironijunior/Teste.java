package br.com.ironijunior;

import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;
import reactor.core.scheduler.Schedulers;

public class Teste {

    public static void main(String[] args) {
        Flux.<Integer>create(Teste::emitNumbers, FluxSink.OverflowStrategy.DROP)
                .publishOn(Schedulers.parallel(), true, 1)
                .map(v -> v * 1)
                .subscribe(
                        Teste::process,
                        err -> System.out.println("ERROR: " + err),
                        () -> System.out.println("DONE")
                );
        sleep(20000);
    }

    private static void process(Integer integer) {
        System.out.println(integer);
        sleep(1000);
    }

    private static void emitNumbers(FluxSink<Integer> emitter) {
        int count = 0;

        while (count < 20) {
            count++;

            System.out.println("Emitting..." + count);
            emitter.next(count);
            sleep(400);
        }
        emitter.complete();
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
