package programing.thread;

public class TestThread extends Thread{
		
	@Override
	public void run() {
        System.out.println(Thread.currentThread().getName() + ": hello");
    }
	
	public  static  void  main(String[]  args) {
		for(int i=0; i<10; i++) {
			TestThread t = new TestThread();
	        t.start();
		}
    }
}
