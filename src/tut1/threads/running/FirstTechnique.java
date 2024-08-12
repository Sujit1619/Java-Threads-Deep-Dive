package tut1.threads.running;

import java.util.concurrent.TimeUnit;

public class FirstTechnique {
//	For this example we are going to create the task by 
//	extending the Thread Class
	public static void main(String[] args) {
		System.out.println("Main Thread starts here FirstTechnique....");

// Here the main method will only spawn the FirstTask but the FirstTask 
// will execute after the main method ends
		new FirstTask();
		Thread t = new FirstTask();
		
		System.out.println("Main Thread ends here FirstTechnique....");
	}
}

// So I am Creating another class below
class FirstTask extends Thread {
	private static int count = 0;
	private int id;
//	Thread by default already implements a runnable interface
//	so we can override run() method in this class 
//  to provide task definition to this thread
	@Override
	public void run() {
// as a part of task definition I am just going to prnt a statement in a loop
		for (int i = 10; i > 0; i--) {
			System.out.println("<" + id + "> TICK TICK - " + i);
// Let us introduce a small delay below so that we can witness the 
// statements coming in the console one at a time
			try {
				TimeUnit.MILLISECONDS.sleep(250);
// The sleep methods throws checked exception so we need to surround 
// it with try catch block
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 

		}

	}
// now we need to call the start methd of thread class also to 
// start thread of execution
// for this example we are going to call the start() method in
	// the constructor of FirstTask
	public FirstTask() {
// below line will count the number of times the FirstTask 
// has been called so each new task instance will get a new id
		this.id = ++count;
// when we create object of this class it will call the constructor 
// first and it will call the start method which will start the Thread immediately
		this.start();
	}
}