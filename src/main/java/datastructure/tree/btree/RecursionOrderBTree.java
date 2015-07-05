package datastructure.tree.btree;

import datastructure.tree.Visit;

import java.io.PrintStream;

public class RecursionOrderBTree
		implements Visit {
	public void preOrder(BTree root) {
		visit(root);
		if (root.getLeftChild() != null)
			preOrder(root.getLeftChild());

		if (root.getRightChild() != null)
			preOrder(root.getRightChild());
	}

	public void inOrder(BTree root) {
		if (root.getLeftChild() != null)
			inOrder(root.getLeftChild());

		visit(root);
		if (root.getRightChild() != null)
			inOrder(root.getRightChild());
	}

	public void postOrder(BTree root) {
		if (root.getLeftChild() != null)
			postOrder(root.getLeftChild());
		if (root.getRightChild() != null)
			postOrder(root.getRightChild());
		visit(root);
	}

	public void visit(BTree btree) {
		System.out.print("\t" + btree.getRootData());
	}
}