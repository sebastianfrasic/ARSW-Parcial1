package edu.eci.arsw.primefinder;

import edu.eci.arsw.mouseutils.MouseMovementMonitor;

import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicInteger;

public class PrimesFinderTool {

    private static boolean paused;

    public static void main(String[] args) {

        int maxPrim = 100000;
        int numberOfThreads = 4;

        PrimesResultSet prs = new PrimesResultSet("john");
        PrimeFinderThread[] threads = new PrimeFinderThread[numberOfThreads];

        //Contador global de threads corriendo
        AtomicInteger num = new AtomicInteger(numberOfThreads);

        int cantidad = maxPrim / numberOfThreads;
        int inicio = 0;

        for (int i = 0; i < numberOfThreads; i++) {
            threads[i] = new PrimeFinderThread(new BigInteger(Integer.toString(inicio)), new BigInteger(Integer.toString(inicio + cantidad)), prs, num);
            threads[i].start();
            inicio += cantidad;
        }


        while (num.get() > 0) {
            paused = MouseMovementMonitor.getInstance().getTimeSinceLastMouseMovement() >= 10000;
        }

        System.out.println("Prime numbers found:");
        System.out.println(prs.getPrimes());
    }

    public static boolean isPaused() {
        return paused;
    }

}


