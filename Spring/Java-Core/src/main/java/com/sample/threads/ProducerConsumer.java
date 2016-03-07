package com.sample.threads;

public class ProducerConsumer {
	public static void main(String[] args) {
		
		ThreadGroup tg=new ThreadGroup("naveen");
		System.out.println("Thread "+Thread.currentThread().getThreadGroup());
		CubbyHole c = new CubbyHole();
		Producer p1 = new Producer(tg,c, 1);
		Consumer c1 = new Consumer(tg,c, 1);
		p1.start();
		c1.start();
		//tg.list();
	}
}

class CubbyHole {
	private int contents;
	private boolean available = false;

	public synchronized int get() {
		while (available == false) {
			try {
				wait();
			} catch (InterruptedException e) {
			}
		}
		available = false;
		notifyAll();
		return contents;
	}

	public synchronized void put(int value) {
		while (available == true) {
			try {
				wait();
			} catch (InterruptedException e) {
			}
		}
		contents = value;
		available = true;
		notifyAll();
	}
}

class Consumer extends Thread {
	private CubbyHole cubbyhole;
	private int number;

	public Consumer(ThreadGroup tg,CubbyHole c, int number) {
		super(tg,Consumer.class.getSimpleName());
		cubbyhole = c;
		this.number = number;
		
	}

	public void run() {
		int value = 0;
		for (int i = 0; i < 10; i++) {
			value = cubbyhole.get();
			System.out.println(getName()+" #" + this.number + " got: " + value);
			System.out.println("Thread "+Thread.currentThread().getThreadGroup());
		}
		
	}
}

class Producer extends Thread {
	private CubbyHole cubbyhole;
	private int number;

	public Producer(ThreadGroup tg,CubbyHole c, int number) {
		super(tg,Producer.class.getSimpleName());
		cubbyhole = c;
		this.number = number;
	}

	public void run() {
		for (int i = 0; i < 10; i++) {
			cubbyhole.put(i);
			System.out.println(getName()+" #" + this.number + " put: " + i);
			try {
				sleep((int) (Math.random() * 1000));
			} catch (InterruptedException e) {
			}
		}
	}
}