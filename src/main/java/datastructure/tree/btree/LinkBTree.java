package datastructure.tree.btree;

public class LinkBTree
		implements BTree {
	private Object data;
	private BTree lChild;
	private BTree rChild;

	public LinkBTree() {
		clearTree();
	}

	public LinkBTree(Object data) {
		this.data = data;
		this.lChild = null;
		this.rChild = null;
	}

	public void addLeftTree(BTree lChild) {
		this.lChild = lChild;
	}

	public void addRightTree(BTree rChild) {
		this.rChild = rChild;
	}

	public void clearTree() {
		this.data = null;
		this.lChild = null;
		this.rChild = null;
	}

	public int dept() {
		return dept(this);
	}

	private int dept(BTree btree) {
		if (btree.isEmpty())
			return 0;
		if (btree.isLeaf())
			return 1;

		if (btree.getLeftChild() == null)
			return (dept(btree.getRightChild()) + 1);
		if (btree.getRightChild() == null)
			return (dept(btree.getLeftChild()) + 1);

		return (Math.max(dept(btree.getLeftChild()), dept(btree.getRightChild())) + 1);
	}

	public BTree getLeftChild() {
		return this.lChild;
	}

	public BTree getRightChild() {
		return this.rChild;
	}

	public Object getRootData() {
		return this.data;
	}

	public boolean hasLeftTree() {
		return (this.lChild != null);
	}

	public boolean hasRightTree() {
		return (this.rChild != null);
	}

	public boolean isEmpty() {
		return (((this.lChild == null) && (this.rChild == null) && (this.data == null)) || (this == null));
	}

	public boolean isLeaf() {
		return ((this.lChild == null) && (this.rChild == null));
	}

	public void removeLeftChild() {
		this.lChild = null;
	}

	public void removeRightChild() {
		this.rChild = null;
	}

	public BTree root() {
		return this;
	}

	public void setRootData(Object data) {
		this.data = data;
	}

	public int size() {
		return size(this);
	}

	private int size(BTree btree) {
		if (btree == null)
			return 0;
		if (btree.isLeaf())
			return 1;

		if (btree.getLeftChild() == null)
			return (size(btree.getRightChild()) + 1);
		if (btree.getRightChild() == null)
			return (size(btree.getLeftChild()) + 1);

		return (size(btree.getLeftChild()) + size(btree.getRightChild()) + 1);
	}
}