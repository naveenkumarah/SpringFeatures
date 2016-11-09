package com.sample.threads;

import java.util.Timer;
import java.util.TimerTask;

public class TimerReminder {
	Timer timer;

	public TimerReminder(int seconds) {
		timer = new Timer();
		timer.schedule(new RemindTask(), seconds * 1000);
		TimerTask a=new TimerTask() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
			}
		};
	}

	class RemindTask extends TimerTask { 
		public void run() {
			System.out.format("Time's up!%n");
			timer.cancel(); //Terminate the timer thread }
		}
	}
	public static void main(String args[]) { 
		System.out.format("About to schedule task.%n"); 
		//new TimerReminder(5); 
		System.out.format("Task scheduled.%n");
	}
}
