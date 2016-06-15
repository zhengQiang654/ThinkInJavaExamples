package com.zfq.concurrent.daemon;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class DaemonFromFactory  implements Runnable {
//这道程序还没有完成， 关于daemon的只是理解的还是不清楚 ，  特别是与threadfactory结合后的守护线程
	@Override
	public void run() {
		while (true ){
			try {
				TimeUnit.SECONDS.sleep(2);
				System.out.println(Thread.currentThread() + " " +  this);
			} catch (InterruptedException e) {
				System.out.println("sleep  is  interrupted");
				e.printStackTrace();
			}
		}
		
	}
	public static void main (String  args [] ){
		ExecutorService service = Executors.newCachedThreadPool( new DaemonThreadFactory());
		service.execute(new DaemonFromFactory());
		System.out.println("a");
		service.shutdown();
	}

}
