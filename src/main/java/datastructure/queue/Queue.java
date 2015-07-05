package datastructure.queue;

public  interface Queue {
	public  void clear();

	public  Object deQueue();

	public  boolean isEmpty();

	public  Object peek();

	public  void push(Object paramObject);

	public  int size();
}