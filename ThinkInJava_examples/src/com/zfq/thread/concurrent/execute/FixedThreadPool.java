package com.zfq.thread.concurrent.execute;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.zfq.thread.consurrent.LiftOff;

public class FixedThreadPool {
	/*
	 * 提供了有限的线程集来执行所提交的任务
	 * 可以一次性的预先执行代价高昂的线程分配
	 */
	public static void main(String[] args) {
		/*
		 * 在任何线程池中，现有的线程在可能的情况下会自动fuyoung
		 * 
		 */
		ExecutorService service = Executors.newFixedThreadPool(5);
		for (int i = 0; i < 10; i++) {
			service.execute(new LiftOff());
		}
		service.shutdown();
	}

}
