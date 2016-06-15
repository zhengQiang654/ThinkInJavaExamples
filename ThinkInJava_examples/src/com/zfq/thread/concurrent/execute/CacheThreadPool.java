package com.zfq.thread.concurrent.execute;

import java.security.Signature;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.zfq.thread.consurrent.LiftOff;

public class CacheThreadPool {
	/*
	 * Java SE5引入了java.util.concurrent.Execute执行器；
	 * 用来管理thread对象，简化了thread编程
	 * 允许管理一步的任务的执行
	 * 无需显示的管理线程的生命周期
	 * 
	 */
	public static void main(String[] args) {
		ExecutorService  executor = Executors.newCachedThreadPool();
		for(int i = 0 ; i  < 5 ; i ++ )
		{
			//线程让步基本不起作用了
			executor.execute(new LiftOff());
		}
		//防止新的任务呗提交给executor
		executor.shutdown();
	}

}
