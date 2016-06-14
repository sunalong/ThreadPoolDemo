package com.itcode.javaadv;

/**
 * 测试线程池的执行
 * 
 * @author along
 */
public class TestThreadPool {
	public static void main(String[] args) {
		// 创建3个线程的线程池
		ThreadPool t = ThreadPool.getThreadPool(5);
		t.execute(new Task[] { new Task("A"), new Task("B"), new Task("C") });
		t.execute(new Task[] { new Task("D"), new Task("E"), new Task("F") });
		System.out.println(t);
		t.destroy();// 所有线程都执行完成才destory
		System.out.println(t);
	}
}
