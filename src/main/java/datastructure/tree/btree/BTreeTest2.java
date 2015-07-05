package datastructure.tree.btree;

import java.io.PrintStream;
import java.util.Iterator;

public class BTreeTest2 {
	public static void main(String[] args) {
		BinTreeNode roots = new BinTreeNode();
		BinTreeNode node = new BinTreeNode();
		roots.setData(Character.valueOf('A'));
		roots.setLChild(new BinTreeNode(Character.valueOf('B')));
		roots.setRChild(new BinTreeNode(Character.valueOf('C')));
		node = roots.getLChild();
		node.setLChild(new BinTreeNode(Character.valueOf('D')));
		node.setRChild(new BinTreeNode(Character.valueOf('E')));
		node = roots.getRChild();
		node.setLChild(new BinTreeNode(Character.valueOf('F')));
		BinaryTreeOrder order = new BinaryTreeOrder(roots);

		Iterator iter1 = order.preOrder();
		System.out.println("前序遍历：");
		printIterator(iter1);

		Iterator iter2 = order.inOrder();
		System.out.println("中序遍历：");
		printIterator(iter2);

		Iterator iter3 = order.postOrder();
		System.out.println("后序遍历：");
		printIterator(iter3);

		Iterator iter4 = order.levelOrder();
		System.out.println("层次遍历：");
		printIterator(iter4);

		String str = order.printBinTree();
		System.out.println("打印二叉树：\n" + str);
		System.out.println("叶结点的个数：" + order.sizeLeaf());
		BinTreeNode nodeone = order.find(Character.valueOf('E'));
		System.out.println("根结点的数据元素：" + nodeone.getData());
	}

	public static void printIterator(Iterator<BinTreeNode> iter) {
		while (iter.hasNext())
			System.out.print("\t" + ((BinTreeNode) iter.next()).getData());

		System.out.println();
	}
}