package datastructure.queue;

public class ArrayQueue
		implements Queue {
	private static int DEFAULT_SIZE = 10;
	private Object[] array = null;
	private int front;
	private int rear;
	private int count;

	public ArrayQueue() {
		this.array = new Object[DEFAULT_SIZE];
		this.front = (this.rear = this.count = 0);
	}

	public boolean isEmpty() {
		return ((this.rear == this.front) && (this.count == 0));
	}

	public int size() {
		return this.count;
	}

	public void push(Object obj) {
		if ((this.rear == this.front) && (this.count > 0))
			expand();
		this.array[this.rear] = obj;
		this.rear = ((this.rear + 1) % DEFAULT_SIZE);
		this.count += 1;
	}

	public Object deQueue() {
		if (this.count == 0)
			throw new IllegalStateException("队列已空，无数据元素可出队列！");

		Object obj = this.array[this.front];
		this.front = ((this.front + 1) % DEFAULT_SIZE);
		this.count -= 1;
		return obj;
	}

	public Object peek() {
		if (this.count == 0)
			throw new IllegalStateException("队列已空，无数据元素可出队列！");
		return this.array[this.front];
	}

	public void clear() {
		for (int i = 0; i < DEFAULT_SIZE; ++i)
			this.array[i] = null;

		this.front = (this.rear = this.count = 0);
	}

	private void expand() {
		Object[] newArray = new Object[2 * DEFAULT_SIZE];
		for (int i = 0; i < this.count; ++i)
			newArray[i] = this.array[((this.front + i) % DEFAULT_SIZE)];

		this.array = newArray;
		this.front = 0;
		this.rear = this.count;
		DEFAULT_SIZE *= 2;
	}

	public String toString() {
		String str = "[";
		for (int i = 0; i < this.count; ++i) {
			str = str + this.array[((this.front + i) % DEFAULT_SIZE)];
			str = str + ",  ";
		}
		str = str + "]";
		return str;
	}
}