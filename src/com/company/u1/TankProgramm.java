package com.company.u1;

import java.time.Duration;
import java.time.Instant;

public class TankProgramm {

    static final int LEN = 10;

    public static void main( String [ ] args ) throws InterruptedException {
        Tank t = new Tank(10000000);

        Pumpe[ ] p = new Pumpe[10];
        for( int i=0; i<LEN; i++ )
            p[i] = new Pumpe( "Pumpe-" + i , t, i+1);



        Instant start = Instant.now();

        for (Pumpe pumpe:
             p) {
            pumpe.start();
        }

        for (Pumpe pumpe:
             p) {
            pumpe.join();
        }


        Instant end = Instant.now();
        System.out.println("Inhalt: " + t.getInhalt());
        System.out.println("Execution time: " + Duration.between(start, end));

        // Vor Synchronisation: 0.0566 Sekunden
        // Nach Synchronsiation: 0.264 Sekunden

        // Mit Synchronisation viel langsamer

        int sum = 0;

        for (Pumpe pumpe:
             p) {
            sum += pumpe.getSum();
        }

        System.out.println("Summe: " + sum);


    }
}