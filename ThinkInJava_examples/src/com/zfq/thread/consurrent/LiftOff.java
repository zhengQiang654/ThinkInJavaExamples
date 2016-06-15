package com.zfq.thread.consurrent;

import javax.net.ssl.SSLEngineResult.Status;
import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

import org.omg.PortableServer.ID_ASSIGNMENT_POLICY_ID;

public class LiftOff implements Runnable {
	protected  int  countDown = 10;
	private static int taskCount = 0;
	private final int id = taskCount++;
	public LiftOff(){}
	public  LiftOff(int countDown) {
		this.countDown = countDown;
	} 
	public String  Status(){
		return "#" + id + "(" + (countDown > 0 ? countDown : "LiftOff") + ")" ;
	}
	@Override
	public void run() {
		while (countDown-- >0) {
			System.out.println(Status());
			//对线程调度器的一种建议； 线程让步
			Thread.yield();
		}
	}

}
