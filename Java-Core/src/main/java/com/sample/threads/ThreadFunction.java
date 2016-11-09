package com.sample.threads;

public class ThreadFunction{

	public static void main(String[] args) throws InterruptedException {
		SimpleThread t=new SimpleThread("simple-thread");
		//t.setDaemon(true);
		t.start();
		t.join();
		//t.wait();
		Thread.dumpStack();
		System.out.println("Main thread end");
	}
	
}
class SimpleThread extends Thread{
	
	public SimpleThread(String threadName) {
		super(threadName);
	}
	@Override
	public void run() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Child thread");
	}
}