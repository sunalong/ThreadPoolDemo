package com.itcode.javaadv.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * Callable与Future的联合用法
 */
class CallableTask implements Callable {
    private int flag = 0;
    private String name;

    public CallableTask(String name, int flag) {
        this.name = name;
        this.flag = flag;
    }

    public String getName() {
        return name;
    }

    public String call() throws Exception {
        if (this.flag == 0) {
            return "flag = 0";
        }
        if (this.flag == 1) {
            try {
                while (true) {
                    System.out.println(name + ": looping...");
                    Thread.sleep(2000);
                }
            } catch (InterruptedException e) {
                System.out.println(name + ":Interrupted");
            }
            return "false";
        } else {
            throw new Exception(name + ":Bad flag value!");
        }
    }
}

public class CallableAndFuture {

    public static void main(String[] args) {

        // 定义3个Callable类型的任务
        CallableTask task1 = new CallableTask("FirstTask", 0);
        CallableTask task2 = new CallableTask("SecondTask", 1);
        CallableTask task3 = new CallableTask("ThirdTask", 2);

        FutureTask futureTask1 = new FutureTask(task1);
        // 创建一个执行任务的线程池
        ExecutorService es = Executors.newFixedThreadPool(3);
        try {
            Future future1 = es.submit(task1);
            System.out.println(task1.getName() + ":的执行结果Future调用get方法:" + future1.get());

            es.submit(futureTask1);
            System.out.println(task1.getName() + ":的执行结果Future调用get方法:" + futureTask1.get());
          
            //FutureTask的第二种使用方式
            FutureTask<String> futureTask = new FutureTask<>(task1);
            Thread thread = new Thread(futureTask);
            thread.start();

            Future future2 = es.submit(task2);
            Thread.sleep(5000);
            System.out.println(task2.getName() + "：的执行结果Future调用cancel方法：" + future2.cancel(true));

            Future future3 = es.submit(task3);
            System.out.println(task3.getName() + "：的执行结果Future调用get方法：" + future3.get());
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        // 停止任务执行服务
        es.shutdownNow();

    }
}
