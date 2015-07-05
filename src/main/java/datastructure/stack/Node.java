package datastructure.stack;

class Node {
	Object data;
	Node next;

	public Node() {
		this(null);
	}

	public Node(Object data) {
		this.data = data;
		this.next = null;
	}
}