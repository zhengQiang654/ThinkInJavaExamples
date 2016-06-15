package com.zfq.thread.concurrent.execute;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.zfq.thread.consurrent.LiftOff;

public class SingleThreadPool {

	public static void main(String[] args) {
		ExecutorService service = Executors.newSingleThreadExecutor();
		for (int i = 0; i < 2; i++) {
			service.execute(new LiftOff());
		}
		//service 执行过程中又向其添加了新的任务
		service.execute(new Thread(){

			@Override
			public void run() {
				System.out.println("中间插一脚");
			}
			
		});
		service.shutdown();
		
	}

}
