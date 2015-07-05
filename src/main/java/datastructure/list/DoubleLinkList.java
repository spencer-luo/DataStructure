package datastructure.list;

public class DoubleLinkList
		implements List {
	DlNode head;
	int size;

	public DoubleLinkList() {
		this.head = new DlNode();
		this.head.prior = this.head;
		this.head.next = this.head;
		this.size = 0;
	}

	public DoubleLinkList(Object[] datas) {
		int n = datas.length;
		this.head = new DlNode();
		DlNode p = this.head;
		DlNode p2 = null;
		for (int i = 0; i < n; ++i) {
			p2 = new DlNode(datas[i]);
			p.next = p2;
			p2.prior = p;
			p = p.next;
		}
		p2.next = this.head;
		this.head.prior = p2;
		this.size = n;
	}

	public void add(Object e) {
		DlNode p;
		if (this.size == 0)
			p = this.head;
		else
			p = index(this.size - 1);

		DlNode p2 = new DlNode(e);
		p.next = p2;
		p2.prior = p;
		p2.next = this.head;
		this.head.prior = p2;
		this.size += 1;
	}

	public void clear() {
		this.head.prior = this.head;
		this.head.next = this.head;
		this.size = 0;
	}

	public Object get(int i) {
		DlNode p = index(i);
		return p.data;
	}

	private DlNode index(int i) {
		DlNode p = null;
		if ((i >= 0) && (i < this.size)) {
			p = this.head;
			for (int j = 0; j <= i; ++j)
				p = p.next;
		}

		return p;
	}

	public int indexOf(Object e) {
		DlNode p = this.head.next;
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
		DlNode p = index(i);
		DlNode p2 = new DlNode(e);
		p2.next = p.next;
		p2.prior = p;
		p.next = p2;
		this.size += 1;
	}

	public boolean isEmpty() {
		return (this.size == 0);
	}

	public int lastIndexOf(Object e) {
		DlNode p = this.head.prior;
		int i = this.size - 1;
		while (!(p.data.equals(e))) {
			p = p.prior;
			--i;
		}
		if (i >= 0)
			return i;

		return -1;
	}

	public void remove(int i) {
		if ((i >= 0) && (i < this.size)) {
			DlNode p = null;
			if (i == 0)
				p = this.head;
			else
				p = index(i - 1);

			DlNode p2 = index(i).next;
			p.next = p2.next;
			p2.next.prior = p;
		}
		this.size -= 1;
	}

	public void set(int i, Object e) {
		DlNode p = index(i);
		p.data = e;
	}

	public int size() {
		return this.size;
	}
}