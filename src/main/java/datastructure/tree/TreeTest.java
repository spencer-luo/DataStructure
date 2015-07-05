package datastructure.tree;

import java.io.PrintStream;

public class TreeTest {
	public static void main(String[] args) {
		Tree root = new Tree("A");
		root.addNode(new Tree("B"));
		root.addNode(new Tree("C"));
		root.addNode(new Tree("D"));
		Tree t = null;
		t = root.getChild(0);
		t.addNode(new Tree("L"));
		t.addNode(new Tree("E"));
		t = root.getChild(1);
		t.addNode(new Tree("F"));
		t = root.getChild(2);
		t.addNode(new Tree("I"));
		t.addNode(new Tree("H"));
		t = t.getFirstChild();
		t.addNode(new Tree("L"));

		System.out.println("first node:" + root.getRootData());

		System.out.println("is left:" + root.isLeaf());
		System.out.println("data:" + root.getRootData());

		Order order = new Order();
		System.out.println("前根遍历：");
		order.preOrder(root);
		System.out.println("\n后根遍历：");
		order.postOrder(root);
	}
}