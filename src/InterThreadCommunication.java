class Chat {
	private boolean flag;
	
	public Chat() {
		flag = false;
	}
	
	public synchronized void Question(String message) {
		if (flag) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println(message);
		flag = true;
		notify();
	}
	
	public synchronized void Answer(String message) {
		if (!flag) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println(message);
		flag = false;
		notify();
	}
}

class T1 implements Runnable {
	Chat chatObj;
	String[] s1 = {"Hi", "How are you doing?", "I'm OK", "How's your work?", "I gotta go then, see ya!"};
	
	public T1(Chat chatObj) {
		this.chatObj = chatObj;
		(new Thread(this, "Question")).start();
	}
	
	@Override
	public void run() {
		for (int i = 0; i < s1.length; i++) {
			chatObj.Question(s1[i]);
		}
	}
}

class T2 implements Runnable {
	Chat chatObj;
	String[] s2 = {"Hello", "I'm OK. You?", "Anything else?", "It's allright, there's a little bit trouble at first but i can find my way", "Have a nice day!"};
	
	public T2(Chat chatObj) {
		this.chatObj = chatObj;
		(new Thread(this, "Answer")).start();
	}
	
	@Override
	public void run() {
		for (int i = 0; i < s2.length; i++) {
			chatObj.Answer(s2[i]);
		}
	}
}

public class InterThreadCommunication {

	public static void main(String[] args) {
		Chat chatObj = new Chat();
		
		new T1(chatObj);
		new T2(chatObj);
	}
}
