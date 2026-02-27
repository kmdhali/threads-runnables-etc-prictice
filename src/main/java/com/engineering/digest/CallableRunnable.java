package com.engineering.digest;

import java.util.concurrent.*;

public class CallableRunnable {


    public static void main(String[] s) throws ExecutionException, InterruptedException, TimeoutException {

        /* Classic Callable */
        Callable<Integer> callableTask1 = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return 12;
            }
        };

        ExecutorService exService = Executors.newFixedThreadPool(5);
        Future<Integer> future1 = exService.submit(callableTask1);

        Integer i = future1.get();
        System.out.println("Result = " + i);


        /* Lamda Callable */
        Callable<Integer> callableTask2 = () -> 15;

        Future<Integer> future2=exService.submit(callableTask2);
        Integer res1=future2.get(10, TimeUnit.SECONDS);
        System.out.println("Result = "+res1);

        //Runnable Task
        Runnable runnableTask3= ()-> System.out.println("Runnable running ");

        Future<?> runnableFutureTask = exService.submit(runnableTask3);
        Object o = runnableFutureTask.get();
        System.out.println("Completed runnableTask123");

        exService.shutdown();
        System.out.println("Terminated = "+exService.isTerminated());

    }
}
