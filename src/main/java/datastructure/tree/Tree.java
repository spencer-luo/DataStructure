package datastructure.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tree {
	private Object data;
	private List<Tree> childs;

	public Tree() {
		this.data = null;
		this.childs = new ArrayList();
		this.childs.clear();
	}

	public Tree(Object data) {
		this.data = data;
		this.childs = new ArrayList();
		this.childs.clear();
	}

	public void addNode(Tree tree) {
		this.childs.add(tree);
	}

	public void clearTree() {
		this.data = null;
		this.childs.clear();
	}

	public int dept() {
		return dept(this);
	}

	private int dept(Tree tree) {
		if (tree.isEmpty())
			return 0;
		if (tree.isLeaf())
			return 1;

		int n = this.childs.size();
		int[] a = new int[n];
		for (int i = 0; i < n; ++i)
			if (((Tree) this.childs.get(i)).isEmpty())
				a[i] = 1;
			else
				a[i] = (dept((Tree) this.childs.get(i)) + 1);


		Arrays.sort(a);
		return a[(n - 1)];
	}

	public Tree getChild(int i) {
		return ((Tree) this.childs.get(i));
	}

	public Tree getFirstChild() {
		return ((Tree) this.childs.get(0));
	}

	public Tree getLastChild() {
		return ((Tree) this.childs.get(this.childs.size() - 1));
	}

	public List<Tree> getChilds() {
		return this.childs;
	}

	public Object getRootData() {
		return this.data;
	}

	public boolean isEmpty() {
		return ((this.childs.isEmpty()) && (this.data == null));
	}

	public boolean isLeaf() {
		return (this.childs.isEmpty());
	}

	public Tree root() {
		return this;
	}

	public void setRootData(Object data) {
		this.data = data;
	}

	public int size() {
		return size(this);
	}

	private int size(Tree tree) {
		if (tree.isEmpty())
			return 0;
		if (tree.isLeaf())
			return 1;

		int count = 1;
		int n = this.childs.size();
		for (int i = 0; i < n; ++i)
			if (!(((Tree) this.childs.get(i)).isEmpty()))
				count += size((Tree) this.childs.get(i));


		return count;
	}
}