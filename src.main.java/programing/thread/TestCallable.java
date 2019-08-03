package programing.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class TestCallable implements Callable<String>{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=0; i<10; i++) {
			FutureTask<String> ft = new FutureTask<>(new TestCallable());
			Thread t = new Thread(ft);
			t.start();
			try {
				System.out.println(ft.get() + ": hello");
			} catch (InterruptedException | ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	@Override
	public String call() throws Exception {
		// TODO Auto-generated method stub
		return Thread.currentThread().getName();
	}

}