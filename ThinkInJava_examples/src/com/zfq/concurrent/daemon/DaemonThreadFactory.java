package com.zfq.concurrent.daemon;

import java.util.concurrent.ThreadFactory;

public class DaemonThreadFactory implements ThreadFactory {

	@Override
	public Thread newThread(Runnable r) {
		Thread t = new Thread(r);
		//将其设置为守护线程
		t.setDaemon(true);
		return t;
	}

}
