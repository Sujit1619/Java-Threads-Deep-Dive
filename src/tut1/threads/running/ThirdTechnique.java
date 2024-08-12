package tut1.threads.running;

import java.util.concurrent.TimeUnit;

public class ThirdTechnique {

	public static void main(String[] args) {
		System.out.println("Main Thread starts here ThirdTechnique....");
		new ThirdTask();
		new ThirdTask();
		System.out.println("Main Thread ends here ThirdTechnique....");
	}
}

class ThirdTask implements Runnable {
	// This class implements runnable interface instead of extending the thread class
	private static int count = 0;
	private int id;

	public void run() {
		for (int i = 10; i > 0; i--) {
			System.out.println("<" + id + "> TICK TICK - " + i);
			try {
				TimeUnit.MILLISECONDS.sleep(250);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	public ThirdTask() {
		this.id = ++count;
		new Thread(this).start();
	}
}
