package com.company;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        final long startTime1 = System.nanoTime();
        System.out.println(prim(2542313003l));
        final long duration1 = System.nanoTime() - startTime1;
        final double res1 = (double)duration1/ 1000000000;
        System.out.println(res1 + " s alatt futott le");
        System.out.println("Current thread is:" + Thread.currentThread().getName());

        final long startTime = System.nanoTime();
        Prime prime = new Prime(2542313003l);
        PrimeTester p1 = new PrimeTester(prime,2, prime.getNum()/4);
        Thread t= new Thread(p1);
        t.start();
        PrimeTester p2 = new PrimeTester(prime,prime.getNum()/4, prime.getNum()/2);
        Thread t2= new Thread(p2);
        t2.start();

        t.join();
        t2.join();
        System.out.println(prime);
        final long duration = System.nanoTime() - startTime;
        final double res = (double)duration / 1000000000;
        System.out.println(res + " s alatt futott le");
    }

    public static boolean prim(long num){
        boolean isPrime = true;
        for(int i = 2; i <= num/2; i++){
            if(num % i == 0) {
                isPrime = false;
                return isPrime;
            }
        }
        isPrime = true;
        return isPrime;
    }
}