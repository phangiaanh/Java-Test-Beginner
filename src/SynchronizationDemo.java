
public class SynchronizationDemo extends Thread {
	private int counter;
	InnerTask task;
	private Thread thread;
	private String threadName;
	
	
	public SynchronizationDemo() {
		counter = 0;
		threadName = "Original Thread";
		task = new InnerTask();
	}
	
	public SynchronizationDemo(int counter, String threadName, InnerTask task) {
		this.counter = counter;
		this.threadName = threadName;
		this.task = task;
	}
	
	@Override
	public void run() {
		synchronized (task) {
			task.modify();
		}
	}
	
	public void start() {
		if (thread == null) {
			thread = new Thread(this, threadName);
			thread.start();
		}
	}
	
	public static void main(String[] args) {
		InnerTask task = new InnerTask();
		SynchronizationDemo R1 = new SynchronizationDemo(0, "A", task);
		SynchronizationDemo R2 = new SynchronizationDemo(0, "B", task);
		
		R1.start();
		R2.start();
	}
}


class InnerTask {
	public void modify() {
		for (int i = 0; i < 10; i++) {
			System.out.println("Counter: " + i);
		}
	}
}
