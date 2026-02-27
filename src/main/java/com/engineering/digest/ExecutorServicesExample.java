package com.engineering.digest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServicesExample {


    static public void main(String[] s) {

        ExecutorService exeService = Executors.newFixedThreadPool(2);

        for (int i = 0; i < 10; i++) {
            int no = i;
            exeService.submit(() -> {
                System.out.println(Thread.currentThread().getName() + "-> I am thread " + no);
            });
        }

    }
}
