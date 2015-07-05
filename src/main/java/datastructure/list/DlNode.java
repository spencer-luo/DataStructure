package datastructure.list;

class DlNode {
	Object data;
	DlNode prior;
	DlNode next;

	public DlNode() {
		this(null);
	}

	public DlNode(Object data) {
		this.data = data;
		this.prior = null;
		this.next = null;
	}
}