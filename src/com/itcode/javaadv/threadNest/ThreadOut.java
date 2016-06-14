package com.itcode.javaadv.threadNest;
/**
 * run方法内有线程运行的线程
 * @author along
 *
 */
public class ThreadOut extends Thread {
    @Override
    public void run() {
        super.run();
        System.out.println("---ThreadOut run方法执行ThreadInner.run()方法之前---");
        new ThreadInner("==ThreadInner===").run();
        System.out.println("---ThreadOut run方法执行ThreadInner.run()方法之后---");
    }
}
