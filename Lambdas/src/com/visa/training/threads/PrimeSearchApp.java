package com.visa.training.threads;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PrimeSearchApp {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		RunnablePrimeSearch w1 = new RunnablePrimeSearch(1, 10000);
		RunnablePrimeSearch w2 = new RunnablePrimeSearch(10000,25000);
//		Thread t1 = new Thread(w1);
//		Thread t2 = new Thread(w2);
//		t1.start();
//		t2.start();
//		t1.join();
//		t2.join();
//		System.out.println("Primes between 1 and 10000 are "+w1.count);
//		System.out.println("Primes between 10000 and 25000 are "+w2.count);
//		
		
		ExecutorService pool = Executors.newFixedThreadPool(4);
		pool.execute(w1);
		pool.execute(w2);
		while(!(w1.resultReady && w2.resultReady) ){
			Thread.sleep(200);
		}
		System.out.println("Primes between 1 and 10000 are "+w1.count);
		System.out.println("Primes between 10000 and 25000 are "+w2.count);
		
		pool.shutdown();
	}

}
