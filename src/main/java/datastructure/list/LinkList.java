package datastructure.list;

public class LinkList
		implements List {
	Node head;
	int size;

	public LinkList() {
		this.head = new Node();
		this.size = 0;
	}

	public LinkList(Object[] datas) {
		int n = datas.length;
		this.head = new Node();
		Node p = this.head;
		for (int i = 0; i < n; ++i) {
			p.next = new Node(datas[i]);
			p = p.next;
		}
		this.size = n;
	}

	public void add(Object e) {
		Node p;
		if (this.size == 0)
			p = this.head;
		else
			p = index(this.size - 1);

		p.next = new Node(e);
		this.size += 1;
	}

	public void clear() {
		this.head.next = null;
		this.size = 0;
	}

	public Object get(int i) {
		Node p = index(i);
		return p.data;
	}

	private Node index(int i) {
		Node p = null;
		if ((i >= 0) && (i < this.size)) {
			p = this.head;
			for (int j = 0; j <= i; ++j)
				p = p.next;
		}

		return p;
	}

	public int indexOf(Object e) {
		Node p = this.head.next;
		int i = 0;
		while (!(p.data.equals(e))) {
			p = p.next;
			++i;
		}
		if (i < this.size)
			return i;

		return -1;
	}

	public void insert(int i, Object e) {
		Node p = index(i);
		Node p2 = new Node(e);
		p2.next = p.next;
		p.next = p2;
		this.size += 1;
	}

	public boolean isEmpty() {
		return (this.size == 0);
	}

	public int lastIndexOf(Object e) {
		int i = this.size - 1;
		while (!(get(i).equals(e)))
			--i;

		if (i >= 0)
			return i;

		return -1;
	}

	public void remove(int i) {
		if ((i >= 0) && (i < this.size)) {
			Node p = null;
			if (i == 0)
				p = this.head;
			else
				p = index(i - 1);

			p.next = index(i).next;
		}
		this.size -= 1;
	}

	public void set(int i, Object e) {
		Node p = index(i);
		p.data = e;
	}

	public int size() {
		return this.size;
	}
}