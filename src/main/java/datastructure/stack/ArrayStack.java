package datastructure.stack;

public class ArrayStack
		implements Stack {
	private static int DEFAULT_SIZE = 100;
	private int Top;
	Object[] array;

	public ArrayStack() {
		this.Top = 0;
		this.array = new Object[DEFAULT_SIZE];
	}

	public boolean isEmpty() {
		return (this.Top == 0);
	}

	public void expand() {
		Object[] newArray = new Object[2 * this.array.length];
		for (int i = 0; i < this.array.length; ++i)
			newArray[i] = this.array[i];

		this.array = newArray;
	}

	public void push(Object obj) {
		if (this.Top == this.array.length)
			expand();

		this.array[this.Top] = obj;
		this.Top += 1;
	}

	public Object pop() {
		if (this.Top == 0) throw new IllegalStateException();
		Object val = this.array[(--this.Top)];
		this.array[this.Top] = null;
		return val;
	}

	public void clear() {
		for (int i = 0; i < this.array.length; ++i) {
			this.array[i] = null;
			this.Top = 0;
		}
	}

	public Object peek() {
		if (this.Top == 0) throw new IllegalStateException();
		return this.array[(this.Top - 1)];
	}

	public int size() {
		return this.Top;
	}

	public String toString() {
		String s = "[";
		for (int i = this.Top - 1; i >= 0; --i) {
			s = s + this.array[i];
			s = s + ",  ";
		}
		s = s + "]";
		return s;
	}
}