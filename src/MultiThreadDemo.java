import java.util.*;

public class MultiThreadDemo implements Runnable {
	private String pthreadName;
	private Thread thread;

	public MultiThreadDemo() {
		pthreadName = "Original Thread";
		System.out.println("Creating " + pthreadName);
	}
	
	public MultiThreadDemo(String pthreadName) {
		this.pthreadName = pthreadName;
		System.out.println("Creating " + pthreadName);
	}
	
	//@Override
	public void run() {
		System.out.println("Running " + pthreadName);
		try {
			for (int i = 0; i < 4; i++) {
				System.out.println(pthreadName + ", " + i);
				Thread.sleep(1);
			}
		} catch (InterruptedException e) {
			System.out.println(pthreadName + " interrupted");
		}
		System.out.println("Terminated " + pthreadName);
	}


	public void start() {
		System.out.println("Starting " + pthreadName);
		if (thread == null) {
			thread = new Thread(this, pthreadName);
		}
		if (pthreadName == "1A") {
			thread.setPriority(10);
		}
		thread.start();
	}
	
	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			MultiThreadDemo multi = new MultiThreadDemo(i + "A");
			multi.start();
		}
	}
}
