package _04_Thread_Pool;

import java.util.concurrent.ConcurrentLinkedQueue;

public class ThreadPool {
	Thread[] threads;
	ConcurrentLinkedQueue<Task> taskQueue = new ConcurrentLinkedQueue<Task>();
	public ThreadPool(int totalThreads)
	{
		threads = new Thread[totalThreads];
		for (int i = 0; i < threads.length; i++)
		{
			threads[i] = new Thread(new Worker(taskQueue));
		}
		taskQueue = new ConcurrentLinkedQueue<Task>();
	}
	public void addTask(Task t)
	{
		taskQueue.add(t);
	}
	public void start()
	{
		for (Thread t : threads)
		{
			t.start();
		}
		for (Thread t : threads)
		{
			try {
				t.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
