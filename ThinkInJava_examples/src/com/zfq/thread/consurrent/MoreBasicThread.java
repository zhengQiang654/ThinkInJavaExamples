package com.zfq.thread.consurrent;

public class MoreBasicThread {
	public static void main(String args [] ){
		for (int i = 0; i < 5; i++) {
			//线程让步起到了作用
			new Thread(new LiftOff()).start();;
		}
	}
}
