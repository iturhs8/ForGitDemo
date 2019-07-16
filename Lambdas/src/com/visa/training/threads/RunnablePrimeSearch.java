package com.visa.training.threads;

public class RunnablePrimeSearch implements Runnable {
    
    long start,end;
    int count;
    volatile boolean resultReady;
    public RunnablePrimeSearch(long start, long end) {
        
        this.start = start;
        this.end = end;
    }
    
    @Override
    public void run() {
        for(long i=start;i<=end;i++) {
            if(isPrime(i)) {
                count++;
            }
        }
        resultReady = true;
    }

    private boolean isPrime(long num) {
        if(num <= 2) {
            return true;
        }
        for(long i=2;i<num;i++) {
            if((num % i) == 0) {
                return false;
            }
        }
        return true;
    }

}