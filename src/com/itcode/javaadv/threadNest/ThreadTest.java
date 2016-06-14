package com.itcode.javaadv.threadNest;
/**
 * 用于测试线程嵌套时的运行顺序
 * @author along
 *
 */
public class ThreadTest {
	public static void main(String[] args) {
		new ThreadOut().run();
	}

}