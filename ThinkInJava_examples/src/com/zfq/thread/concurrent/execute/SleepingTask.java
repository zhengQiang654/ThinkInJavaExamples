package com.zfq.thread.concurrent.execute;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import com.zfq.thread.consurrent.LiftOff;

public class SleepingTask extends LiftOff {
	
	public void run(){
		try {
			while (countDown -- > 0){
				System.out.println(Status());
				/*Thread.sleep(1000);
				 * 旧的方式
				 * 
				 * */
				TimeUnit.SECONDS.sleep(1);
			}
		} catch (InterruptedException e) {
			System.err.println("Interrupted");
		}
	}
	public static void main(String[] args) {
		ExecutorService service = Executors.newCachedThreadPool();
		service.execute(new SleepingTask());
		service.shutdown();
	}

}
