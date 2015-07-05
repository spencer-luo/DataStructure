package datastructure.stack;

public class LinkStack
		implements Stack {
	private Node top;
	private int size;

	public LinkStack() {
		this.top = null;
		this.size = 0;
	}

	public void clear() {
		this.top = null;
		this.size = 0;
	}

	public void push(Object obj) {
		Node p = new Node(obj);
		if (this.top == null) {
			this.top = p;
		} else {
			p.next = this.top;
			this.top = p;
		}
		this.size += 1;
	}

	public Object pop() {
		Node p = this.top;
		this.top = this.top.next;
		this.size -= 1;
		return p.data;
	}

	public boolean isEmpty() {
		return (this.size == 0);
	}

	public int size() {
		return this.size;
	}

	public Object peek() {
		return this.top.data;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		Node p = this.top;
		if (p == null)
			sb.append("");
		else
			do
				sb.append(p.data + ",  ");
			while ((p = p.next) != null);

		sb.append("]");
		return sb.toString();
	}
}