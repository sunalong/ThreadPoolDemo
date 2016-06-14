package com.itcode.javaadv.callable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class RunnableTest implements Runnable {
    protected int countDown = 10;
    private static int taskCount = 0;
    private final int id = taskCount++;

    public RunnableTest() {
    }

    public String status() {
        return "#" + id + "(" + countDown + ")  ";
    }

    @Override
    public void run() {
        while (countDown-- > 0) {
            System.out.print(status());
            Thread.yield();
        }
        System.out.println();
    }
}

public class RunnableDemo {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newFixedThreadPool(1);
        for (int i = 0; i < 5; i++) {
            exec.execute(new RunnableTest());
        }
        exec.shutdown();
    }
}