package com.itcode.javaadv.threadNest;

/**
 * 运行于线程内部的线程
 * 
 * @author along
 *
 */
public class ThreadInner extends Thread {
	private String name;

	public ThreadInner(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		super.run();
		for (int i = 0; i < 10; i++) {
			System.out.println(name + "正在执行任务" + Thread.currentThread().getName());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
