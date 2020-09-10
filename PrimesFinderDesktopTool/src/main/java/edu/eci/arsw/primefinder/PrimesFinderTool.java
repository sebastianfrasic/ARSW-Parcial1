package edu.eci.arsw.primefinder;

import java.math.BigInteger;

public class PrimesFinderTool {

    public static void main(String[] args) {

        int maxPrim = 100;
        int numberOfThreads = 4;

        PrimesResultSet prs = new PrimesResultSet("john");
        PrimeFinderThread[] threads = new PrimeFinderThread[numberOfThreads];

        int cantidad = maxPrim / numberOfThreads;
        int inicio = 0;

        for (int i = 0; i < numberOfThreads; i++) {
            threads[i] = new PrimeFinderThread(new BigInteger(Integer.toString(inicio)), new BigInteger(Integer.toString(inicio + cantidad)), prs);
            threads[i].start();
            inicio += cantidad;
        }

        for (int i = 0; i < numberOfThreads; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Prime numbers found:");
        System.out.println(prs.getPrimes());
            
            
            /*while(task_not_finished){
                try {
                    //check every 10ms if the idle status (10 seconds without mouse
                    //activity) was reached. 
                    Thread.sleep(10);
                    if (MouseMovementMonitor.getInstance().getTimeSinceLastMouseMovement()>10000){
                        System.out.println("Idle CPU ");
                    }
                    else{
                        System.out.println("User working again!");
                    }
                } catch (InterruptedException ex) {
                    Logger.getLogger(PrimesFinderTool.class.getName()).log(Level.SEVERE, null, ex);
                }
            }*/


    }

}


