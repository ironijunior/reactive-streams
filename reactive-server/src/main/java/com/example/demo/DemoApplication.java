package com.example.demo;

import com.example.demo.producer.VehiclePlateProducer;
import org.apache.commons.lang3.StringUtils;
import reactor.core.publisher.Flux;

public class DemoApplication {

    public static void main(String[] args) {
        Flux<String> publisher = Flux.create(VehiclePlateProducer::generate);

        Flux<Integer> integer = publisher
                .filter(s -> s.startsWith("A") || s.startsWith("B"))
                .map(StringUtils::swapCase)
                .map(s -> {
                    System.out.println(s);
                    return Integer.parseInt(s.substring(3));
                });

        integer.subscribe(DemoApplication::consumePlateNumber);

        sleep(50000);
    }

    private static void consumePlateNumber(Integer integer) {
        System.out.println(integer);
        sleep(1000);
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