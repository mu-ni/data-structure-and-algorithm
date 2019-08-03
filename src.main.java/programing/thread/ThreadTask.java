package programing.thread;

public class ThreadTask implements Runnable{
	
	int index;
	
	ThreadTask(int i){
		index = i;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Thread-" + Thread.currentThread().getId() + "-: Hello World! " + index);
	}

}
