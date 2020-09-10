package edu.eci.arsw.primefinder;

import edu.eci.arsw.math.MathUtilities;

import java.math.BigInteger;

public class PrimeFinderThread extends Thread {

    private BigInteger a;
    private BigInteger b;
    private PrimesResultSet prs;


    public PrimeFinderThread(BigInteger a, BigInteger b, PrimesResultSet prs) {
        this.a = a;
        this.b = b;
        this.prs = prs;
    }


    @Override
    public void run() {
        MathUtilities mt = new MathUtilities();
        int itCount = 0;
        BigInteger i = a;
        while (i.compareTo(b) <= 0) {
            itCount++;
            if (mt.isPrime(i)) {
                prs.addPrime(i);
            }
            i = i.add(BigInteger.ONE);
        }
    }


}
