package eu.gebes;

import java.math.BigInteger;

public class Main {

    public static void main(String[] args) {
       infinityRecord();
    }

    private static void checkSpecificNumber(BigInteger i) {
        System.out.println(i + ": " + steps(i));
    }

    private static void infinityRecord() {
        int longest = 0;

        long start = System.currentTimeMillis();
        long last = System.currentTimeMillis();

        for (int i = 1; true; i++) {

            var steps = steps(BigInteger.valueOf(i));

            if (steps > longest) {
                longest = steps;

                float lastTime = ((System.currentTimeMillis() - last) / 1000f);
                float startTime = ((System.currentTimeMillis() - start) / 1000f);
                System.out.println("Found new record " + String.format("%10d", i) + ": " + String.format("%5d", steps) + "\t\tafter " + String.format("%2.3f", lastTime) + "s \t\ttime since start " + String.format("%2.3f", startTime) + "s");
                last = System.currentTimeMillis();
            }

            //  System.out.println(i);

        }


    }

    private static void record() {

        int longest = 0;

        for (int i = 1; i < 1000000; i++) {

            if (steps(BigInteger.valueOf(i)) > longest)
                longest = i;

            //  System.out.println(i);

        }

        System.out.println("Longest chain is " + longest);

    }

    private static int steps(BigInteger count) {

        int steps = 1;

        while (!count.equals(BigInteger.ONE)) {
            if (count.mod(BigInteger.TWO).equals(BigInteger.ZERO)) {
                count = count.divide(BigInteger.TWO);
            } else {
                count = count.multiply(BigInteger.valueOf(3)).add(BigInteger.ONE);
            }
            steps++;
        }

        return steps;

    }

}
