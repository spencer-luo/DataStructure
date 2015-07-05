package datastructure.list;

public class ArrayList
		implements List {
	public static final int defLen = 10;
	private int maxLen;
	private Object[] array;
	private int size;

	public ArrayList() {
		this.size = 0;
		this.maxLen = 10;
		this.array = new Object[10];
	}

	public void clear() {
		this.size = 0;
	}

	public Object get(int i) {
		if ((i >= 0) && (i < this.size))
			return this.array[i];

		return null;
	}

	public int indexOf(Object e) {
		int i = 0;
		while ((i < this.size) && (!(this.array[i].equals(e))))
			++i;

		if (i < this.size)
			return i;

		return -1;
	}

	public void insert(int i, Object e) {
		if (i >= this.size) {
			i = this.size;
			if (this.size >= this.maxLen)
				expand();
		}
		for (int j = this.size; j > i + 1; --j)
			this.array[j] = this.array[(j - 1)];

		this.array[(i + 1)] = e;
		this.size += 1;
	}

	public boolean isEmpty() {
		return (this.size == 0);
	}

	public int lastIndexOf(Object e) {
		int i = this.size - 1;
		while ((i >= 0) && (!(this.array[i].equals(e))))
			--i;

		if (i >= 0)
			return i;

		return -1;
	}

	public void remove(int i) {
		if (i <= 0 || isEmpty())
			return;

		for (int j = i; j < this.size - 1; ++j)
			this.array[j] = this.array[(j + 1)];

		this.size -= 1;
	}

	public void set(int i, Object e) {
		this.array[i] = e;
	}

	public int size() {
		return this.size;
	}

	private void expand() {
		this.maxLen *= 2;
		Object[] newArray = new Object[this.maxLen];
		for (int i = 0; i < this.size; ++i)
			newArray[i] = this.array[i];

		this.array = newArray;
	}

	public void add(Object e) {
		if (this.size >= this.maxLen)
			expand();
		this.array[this.size] = e;
		this.size += 1;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for (int i = 0; i < this.size; ++i)
			sb.append(this.array[i] + ", ");

		sb.append("]");
		return sb.toString();
	}
}