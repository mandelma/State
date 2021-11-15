package model;

import controller.Controller;

public class Activator extends Thread {
	
	public static final int RUNNING_TIME = 65;
	public static final int SPEED = 400;
	public static int STEP = 0;
	private Controller controller;
	
	public Activator(Controller controller) {
		super();
		this.controller = controller;
	}

	public void run() {
		
		for (int i=0; i<= RUNNING_TIME; i++) {
			System.out.println("step " + STEP);
			controller.actor(STEP);
		
			STEP++;
		
			try {
				Thread.sleep(SPEED);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
