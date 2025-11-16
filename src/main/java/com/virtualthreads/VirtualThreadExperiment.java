package com.virtualthreads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class VirtualThreadExperiment {

    public static void main(String... argc) {

        //int noOfThread = 100_000;

        int noOfThread = 1000000;
        System.out.println("Start , no threads : " + noOfThread);

         //ExecutorService executorService = Executors.newFixedThreadPool(noOfThread);
        ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor();

        for (int i = 0; i < noOfThread; i++) {
            executorService.submit(new MyJibs());
        }

        executorService.shutdown();
        System.out.println("\nDone , no threads : " + noOfThread);

    }
}

class MyJibs implements Runnable {

    // Volatile black-hole to prevent JIT optimization
    private static volatile long sink = 0;

    @Override
    public void run() {
        long x = 0;
        for (int i = 0; i < 1_000; i++) {
            x += i;      // some CPU work
        }
        sink = x;        // prevents optimization
        System.out.print(".");
    }
}
