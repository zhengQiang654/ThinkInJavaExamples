package com.zfq.concurrent.daemon;

import java.util.concurrent.TimeUnit;

import javax.sound.midi.VoiceStatus;

public class SimpleDaemons  implements Runnable{

	@Override
	public void run() {
		try {
			while (true){
				TimeUnit.SECONDS.sleep(1);
				System.out.println((Thread.currentThread() + " " + this));
			
			}
		} catch (InterruptedException e) {
			System.out.println("sleep is interrupted");
		}
	}
	public static void  main(String args [] ){
		Thread thread = new Thread(new SimpleDaemons());
		//设置当前线程为守护线程
		//必须在线程启动之前将其设置为守护线程
		thread.setDaemon(true);
		thread.start();
		System.out.println("All  daemon start ");
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
