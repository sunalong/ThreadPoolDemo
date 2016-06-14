package com.itcode.javaadv;

// 任务类
public class Task implements Runnable {
	String name;

	public String getName() {
		return name;
	}

	public Task(String name) {
		this.name = name;
	}

	@Override
	public void run() {// 执行任务
		for (int i = 0; i < 10; i++) {
			System.out.println("		任务" + name + "正在被執行" + Thread.currentThread().getName());
			try {Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();}
		}
	}
}