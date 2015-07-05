package datastructure.tree.btree;

public class BinTreeNode {
	private Object data;
	private BinTreeNode parent;
	private BinTreeNode lChild;
	private BinTreeNode rChild;
	private int height;
	private int size;

	public BinTreeNode() {
		this(null);
	}

	public BinTreeNode(Object e) {
		this.data = e;
		this.height = 0;
		this.size = 1;
		this.parent = (this.lChild = this.rChild = null);
	}

	public Object getData() {
		return this.data;
	}

	public void setData(Object obj) {
		this.data = obj;
	}

	public boolean hasParent() {
		return (this.parent != null);
	}

	public boolean hasLChild() {
		return (this.lChild != null);
	}

	public boolean hasRChild() {
		return (this.rChild != null);
	}

	public boolean isLeaf() {
		return ((!(hasLChild())) && (!(hasRChild())));
	}

	public boolean isLChild() {
		return ((hasParent()) && (this == this.parent.lChild));
	}

	public boolean isRChild() {
		return ((hasParent()) && (this == this.parent.rChild));
	}

	public int getHeight() {
		return this.height;
	}

	public void updateHeight() {
		int newH = 0;
		if (hasLChild())
			newH = Math.max(newH, this.lChild.getHeight() + 1);
		if (hasRChild())
			newH = Math.max(newH, this.rChild.getHeight() + 1);
		if (newH == this.height)
			return;
		this.height = newH;
		if (hasParent())
			this.parent.updateHeight();
	}

	public int getSize() {
		return this.size;
	}

	public void updateSize() {
		this.size = 1;
		if (hasLChild())
			this.size += this.lChild.getSize();
		if (hasRChild())
			this.size += this.rChild.getSize();
		if (hasParent())
			this.parent.updateSize();
	}

	public BinTreeNode getParent() {
		return this.parent;
	}

	public void sever() {
		if (!(hasParent()))
			return;
		if (isLChild())
			this.parent.lChild = null;
		else
			this.parent.rChild = null;
		this.parent.updateHeight();
		this.parent.updateSize();
		this.parent = null;
	}

	public BinTreeNode getLChild() {
		return this.lChild;
	}

	public BinTreeNode setLChild(BinTreeNode lc) {
		BinTreeNode oldLC = this.lChild;
		if (hasLChild())
			this.lChild.sever();

		if (lc != null) {
			lc.sever();
			this.lChild = lc;
			lc.parent = this;
			updateHeight();
			updateSize();
		}
		return oldLC;
	}

	public BinTreeNode getRChild() {
		return this.rChild;
	}

	public BinTreeNode setRChild(BinTreeNode rc) {
		BinTreeNode oldRC = this.rChild;
		if (hasRChild())
			this.rChild.sever();

		if (rc != null) {
			rc.sever();
			this.rChild = rc;
			rc.parent = this;
			updateHeight();
			updateSize();
		}
		return oldRC;
	}

	public String toString() {
		return this.data.toString();
	}
}