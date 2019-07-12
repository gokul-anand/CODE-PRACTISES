
public class ThreadExample {

	public static void main(String[] args) {
		Numbers t1 = new Numbers(1,100);
		Numbers t2 = new Numbers(200,300);
		
		Chars c = new Chars();
		Thread t3 = new Thread(c);
		t3.start();
		t1.start();
		t2.start();
//		c.run();
		doTask();
	}

	private static void doTask() {
		Thread t = Thread.currentThread();
		System.out.println("Name :" +t.getName());
		System.out.println("Priority :"+t.getPriority());
		System.out.println("Group :"+t.getThreadGroup().getName());
		/*
		 * JRE waits for the status for last demon thread before it temrinate
		 */
		System.out.println("Demon :"+t.isDaemon());
		
	}

}
