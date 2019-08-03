package programing.thread;

public class TestRunnable implements Runnable{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=0; i<10; i++) {
			Thread t = new Thread(new TestRunnable());
			t.start();
		}
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(Thread.currentThread().getName() + ": hello");
	}

}
