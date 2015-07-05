package datastructure.set;

public class ArraySet
		implements Set {
	public static final int defLen = 10;
	private int maxLen;
	private int size;
	private Object[] e;

	public ArraySet() {
		this.maxLen = 10;
		this.e = new Object[this.maxLen];
		this.size = 0;
	}

	public ArraySet(int len) {
		this.maxLen = len;
		this.e = new Object[this.maxLen];
		this.size = 0;
	}

	public ArraySet(Set set) {
		this.size = (this.maxLen = set.size());
		for (int i = 0; i < this.size; ++i)
			this.e[i] = set.get(i);
	}

	private void clear() {
		this.size = 0;
	}

	private void expand() {
		this.maxLen *= 2;
		Object[] newArray = new Object[this.maxLen];
		for (int i = 0; i < this.size; ++i)
			newArray[i] = this.e[i];

		this.e = newArray;
	}

	public int size() {
		return this.size;
	}

	public void add(Object o) {
		if (!(contain(o))) {
			if (this.size >= this.maxLen)
				expand();

			this.e[this.size] = o;
			this.size += 1;
		}
	}

	public void remove(Object o) {
		if (!(contain(o)))
			throw new IllegalArgumentException("this set is not contain o element!");

		int k = index(o);
		for (int i = k; i < this.size - 1; ++i)
			this.e[i] = this.e[(i + 1)];

		this.size -= 1;
	}

	private int index(Object o) {
		int i = 0;
		while (i < this.size) {
			if (this.e[i] == o)
				return i;
			++i;
		}
		return -1;
	}

	public boolean contain(Object o) {
		int i = 0;
		while (i < this.size) {
			if (this.e[i] == o)
				return true;
			++i;
		}
		return false;
	}

	public boolean include(Set set) {
		if (set.size() > this.size)
			return false;
		if (set.size() == 0)
			return true;

		boolean b = true;
		for (int i = 0; i < set.size(); ++i) {
			b = (b) && (contain(set.get(i)));
			if (!(b))
				return false;
		}
		return b;
	}

	public Set unionSet(Set set) {
		int len = this.size + set.size();
		Set rSet = new ArraySet(len);

		for (int i = 0; i < this.size; ++i)
			rSet.add(this.e[i]);

		for (int i = 0; i < set.size(); ++i) {
			Object obj = set.get(i);
			if (!(contain(obj)))
				rSet.add(obj);
		}
		return rSet;
	}

	public Set intersection(Set set) {
		int len = (this.size < set.size()) ? this.size : set.size();
		Set rSet = new ArraySet(len);
		for (int i = 0; i < set.size(); ++i) {
			Object obj = set.get(i);
			if (contain(obj))
				rSet.add(obj);
		}
		return rSet;
	}

	public boolean isEmpty() {
		return (this.size == 0);
	}

	public Object get(int i) {
		if ((i < 0) && (i >= this.size))
			throw new ArrayIndexOutOfBoundsException(i);

		return this.e[i];
	}

	public Set differenceSet(Set set) {
		Set rSet = new ArraySet(this.size);
		for (int i = 0; i < this.size; ++i)
			if (!(set.contain(this.e[i])))
				rSet.add(this.e[i]);

		return rSet;
	}

	public boolean equals(Object obj) {
		return super.equals(obj);
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		for (int i = 0; i < this.size; ++i)
			if (i == this.size - 1)
				sb.append(this.e[i]);
			else
				sb.append(this.e[i] + ", ");

		sb.append("}");
		return sb.toString();
	}
}