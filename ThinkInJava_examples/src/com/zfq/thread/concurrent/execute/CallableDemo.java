package com.zfq.thread.concurrent.execute;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/*
 * Runnable 是执行工作的独立任务；但是它不返回任何的值； 如果希望任务执行完成后有返回值
 * 那么实现Callable 接口而不是Runnable 接口
 * Callable 具有类型参数的泛型
 */

class TaskWithResult implements Callable<String>{
	private int id;
	public  TaskWithResult(int id) {
		this.id = id ;
	}
	@Override
	public String call() throws Exception {
		
		return "result of TaskWithResult id " + id;
	}
	
}

public class CallableDemo {
		public static void main(String[] args) {
		ExecutorService service = Executors.newCachedThreadPool();
//		Future<String> submit = service.submit(new TaskWithResult(1));
		ArrayList<Future<String>> list = new ArrayList<Future<String>>();
		for (int i = 0; i < 2; i++) {
			list.add(service.submit(new TaskWithResult(i)));
		}
		for (Future<String> s : list) {
			try {
				System.out.println(s.isDone());
				try {
					
				} catch (Exception e) {
					// TODO: handle exception
				}
				System.out.println(s.get());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				service.shutdown();
			}
		}
	}

}
