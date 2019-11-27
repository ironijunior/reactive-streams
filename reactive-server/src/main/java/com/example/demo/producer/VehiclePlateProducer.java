package com.example.demo.producer;

import reactor.core.publisher.FluxSink;

public class VehiclePlateProducer {

    private VehiclePlateProducer() {}

    public static void generate(FluxSink<String> fluxSink) {
        var count = 0;

        while (count < Integer.MAX_VALUE) {
            count++;
            String plate = getPlate();
            System.out.println("Generated plate..." + plate);

            fluxSink.next(plate);
            sleep(500);
        }
        fluxSink.complete();
    }

    private static String getPlate() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            char ch = (char) (Math.random() * 26 + 'A');
            s.append(ch);
        }
        for (int i = 0; i < 4; i++) {
            char digit1 = (char) (Math.random() * 10 + '0');
            s.append(digit1);
        }
        return s.toString();
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
