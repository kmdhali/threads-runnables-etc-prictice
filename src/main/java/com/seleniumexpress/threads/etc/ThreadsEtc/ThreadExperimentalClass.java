package com.seleniumexpress.threads.etc.ThreadsEtc;

public class ThreadExperimentalClass {

    public static void main(String[] argc) {

        //using runnable
        Thread t1 = new Thread(new MyRunnable());
        Thread t2 = new Thread(new MyRunnable());
        Thread t3 = new Thread(new MyRunnable());
        t1.start();
        t2.start();

        //extending thread
        MyThread t11= new MyThread();
        MyThread t12= new MyThread();
        t11.start();
        t12.start();


        //create thread using lamda expression
        //this works because the Runnable interface is functional interface now
        Thread t10 = new Thread(() ->
        {
            for (int i = 0; i < 10; i++)
                System.out.println(Thread.currentThread().getName() +" hi...");

        });
        t10.start();

    }
}

/**
 * Creating thread using Runnable interface
 */
class MyRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " Hello there ..." + i);
        }
    }
}

/**
 * Creating thread extending Tread class
 */

class MyThread extends Thread {
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " Hello there ..." + i);
        }
    }
}
