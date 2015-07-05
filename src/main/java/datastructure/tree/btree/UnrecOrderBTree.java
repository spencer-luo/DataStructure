package datastructure.tree.btree;

import datastructure.stack.ArrayStack;
import datastructure.stack.Stack;
import datastructure.tree.Visit;

import java.io.PrintStream;

public class UnrecOrderBTree
		implements Visit {
	private Stack stack = new ArrayStack();
	private BTree bt;

	public void visit(BTree btree) {
		System.out.print("\t" + btree.getRootData());
	}

	public void inOrder(BTree boot) {
		this.stack.clear();
		this.stack.push(boot);
		//break label193:

		this.stack.push(this.bt);
		do {
			if ((this.bt = ((BTree) this.stack.peek()).getLeftChild()) != null) ;
			while ((!(this.stack.isEmpty())) && (!(((BTree) this.stack.peek()).hasRightTree()))) {
				this.bt = ((BTree) this.stack.pop());
				visit(this.bt);
			}

			if ((!(this.stack.isEmpty())) && (((BTree) this.stack.peek()).hasRightTree())) {
				this.bt = ((BTree) this.stack.pop());
				visit(this.bt);
				label193:
				this.stack.push(this.bt.getRightChild());
			}
		}
		while (!(this.stack.isEmpty()));
	}
}