package com.company;

public class PrimeTester implements Runnable{

    Prime p;
    private long min;
    private long max;

    public PrimeTester(Prime p,long min, long max) {
        this.min = min;
        this.max = max;
        this.p = p;
    }

        private boolean findDivider() {
            for (long i = min; i < max; i++) {
                if (p.getNum() % i == 0) {
                    return true;
                }
                if (!p.isPrime()) return false;
            }
            return false;
        }

        public void run(){
            if(findDivider()){
                synchronized (p){
                p.setPrime(false);
                }
            }
        }
}

/*Készíts egy függvényt (findDivider), ami logikai értékkel tér vissza annak függvényében, hogy a p adattag prím-e (ez úgy valósul meg,
hogy az alsó és felső korlát közt futtatunk egy for ciklust, és teszteljük az osztókat, valamint ellenőrizzük, hogy a p szám időközben nem
lett-e isPrime igaz.
    - Implementáld a run metódust a következőképpen: ha az adott objekutm findPrime függvénye igazzal tér vissza, akkor a p adattag isPrime
    értékét állítsd szinkronizáltan igazra, hogy a párhuzamosan futó prímtesztek is leálljanak!
Collapse*/