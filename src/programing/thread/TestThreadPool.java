package programing.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TestThreadPool {

	public static void main(String[] args) {

//		TestCachedThreadPool();
		TestFixedThreadPool();
//		TestScheduledThreadPool();
//		TestSingleThreadPool();

	}

	public static void TestCachedThreadPool() {
		System.out.println("TestCachedThreadPool()");

		ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
		ExecutorService cachedThreadPool1 = new ThreadPoolExecutor(1,5,0, TimeUnit.SECONDS,new LinkedBlockingDeque<Runnable>());

		for (int i = 0; i < 100; i++) {
			final int index = i;

//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}

			cachedThreadPool.execute(new ThreadTask(index));

		}
	}

	public static void TestFixedThreadPool() {
		System.out.println("TestFixedThreadPool()");

		ExecutorService fixedThreadPool = Executors.newFixedThreadPool(5);

		for (int i = 0; i < 10; i++) {
			final int index = i;

			fixedThreadPool.execute(new ThreadTask(index));
		}

	}

	public static void TestScheduledThreadPool() {
		System.out.println("TestScheduledThreadPool()");

		ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(2);

		for (int i = 0; i < 10; i++) {
			final int index = i;
			
			scheduledThreadPool.schedule(new ThreadTask(index), 3, TimeUnit.SECONDS);
		}

	}

	public static void TestSingleThreadPool() {
		System.out.println("TestSingleThreadPool()");
		
		ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
		
		for (int i = 0; i < 10; i++) {
			final int index = i;
			
			singleThreadExecutor.execute(new ThreadTask(index));
		}
		
	}

}
