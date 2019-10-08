package com.example.demo;

import com.example.demo.evenodd.EvenOdd;
import com.example.demo.evenodd.ReactiveNumber;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}

@RestController
class ReactiveController {

    @GetMapping(value = "/", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> getEvenOdd() {
        return Flux.interval(Duration.ofSeconds(1))
                .map(l -> {
                    ReactiveNumber rn = new ReactiveNumber(l);
                    rn.setEvenOdd(
                            l % 2 == 0 ? EvenOdd.EVEN : EvenOdd.ODD
                    );
                    return rn;
                })
                .map(ReactiveNumber::toString);
    }

}