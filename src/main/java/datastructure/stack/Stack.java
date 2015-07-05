package datastructure.stack;

public  interface Stack {
	public  void clear();

	public  void push(Object paramObject);

	public  Object pop();

	public  boolean isEmpty();

	public  int size();

	public  Object peek();
}