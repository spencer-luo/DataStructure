package datastructure.tree.btree;

import datastructure.common.Strategy;
import datastructure.queue.ArrayQueue;
import datastructure.queue.Queue;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeOrder {
	private int leafSize = 0;
	private BinTreeNode root = null;
	Strategy strategy = new StrategyEqual();

	public BinaryTreeOrder(BinTreeNode node) {
		this.root = node;
		Strategy strategy = new StrategyEqual();
	}

	public BinTreeNode getRoot() {
		return this.root;
	}

	public Iterator preOrder() {
		List list = new LinkedList();
		preOrderRecursion(this.root, list);
		return list.iterator();
	}

	private void preOrderRecursion(BinTreeNode rt, List list) {
		if (rt == null)
			return;
		list.add(rt);
		preOrderRecursion(rt.getLChild(), list);
		preOrderRecursion(rt.getRChild(), list);
	}

	public Iterator inOrder() {
		List list = new LinkedList();
		inOrderRecursion(this.root, list);
		return list.iterator();
	}

	private void inOrderRecursion(BinTreeNode rt, List list) {
		if (rt == null)
			return;
		inOrderRecursion(rt.getLChild(), list);
		list.add(rt);
		inOrderRecursion(rt.getRChild(), list);
	}

	public Iterator postOrder() {
		List list = new LinkedList();
		postOrderRecursion(this.root, list);
		return list.iterator();
	}

	private void postOrderRecursion(BinTreeNode rt, List list) {
		if (rt == null)
			return;
		postOrderRecursion(rt.getLChild(), list);
		postOrderRecursion(rt.getRChild(), list);
		list.add(rt);
	}

	public Iterator levelOrder() {
		List list = new LinkedList();
		levelOrderTraverse(this.root, list);
		return list.iterator();
	}

	private void levelOrderTraverse(BinTreeNode rt, List list) {
		if (rt == null)
			return;
		Queue q = new ArrayQueue();
		q.push(rt);
		while (!(q.isEmpty())) {
			BinTreeNode p = (BinTreeNode) q.deQueue();
			list.add(p);
			if (p.hasLChild())
				q.push(p.getLChild());
			if (p.hasRChild())
				q.push(p.getRChild());
		}
	}

	public BinTreeNode find(Object e) {
		return searchE(this.root, e);
	}

	private BinTreeNode searchE(BinTreeNode rt, Object e) {
		if (rt == null)
			return null;
		if (this.strategy.equal(rt.getData(), e))
			return rt;
		BinTreeNode v = searchE(rt.getLChild(), e);
		if (v == null)
			v = searchE(rt.getRChild(), e);
		return v;
	}

	public String printBinTree() {
		StringBuilder sb = new StringBuilder();
		printBinTree(this.root, 0, sb);
		return sb.toString();
	}

	private void printBinTree(BinTreeNode btree, int n, StringBuilder sb) {
		if (btree == null)
			return;
		printBinTree(btree.getRChild(), n + 1, sb);
		for (int i = 0; i < n; ++i)
			sb.append("\t");
		if (n >= 0)
			sb.append(btree.getData() + "\n");
		printBinTree(btree.getLChild(), n + 1, sb);
	}

	public int sizeLeaf() {
		searchLeaf(this.root);
		return this.leafSize;
	}

	private void searchLeaf(BinTreeNode rt) {
		if (rt == null)
			return;
		if (rt.isLeaf()) {
			this.leafSize += 1;
		} else {
			searchLeaf(rt.getLChild());
			searchLeaf(rt.getRChild());
		}
	}
}