package com.itcode.javaadv.callable;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
/**
 * Callable在ExecutorService中的简单用法
 * @author along
 *
 */
class MyCallable implements Callable<String> {
	private int id;

	public MyCallable(int id) {
		this.id = id;
	}

	@Override
	public String call() throws Exception {
		return "result of MyCallable " + id;
	}
}

public class CallableDemo {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService exec = Executors.newCachedThreadPool();
		ArrayList<Future<String>> results = new ArrayList<Future<String>>(); // Future
																				// 相当于是用来存放Executor执行的结果的一种容器
		for (int i = 0; i < 10; i++) {
			results.add(exec.submit(new MyCallable(i)));
		}
		for (Future<String> fs : results) {
			if (fs.isDone()) {
				System.out.println(fs.get());
			} else {
				System.out.println("Future result is not yet complete");
			}
		}
		exec.shutdown();
	}
}
