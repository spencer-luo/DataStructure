package datastructure.tree;

import java.io.PrintStream;
import java.util.Iterator;
import java.util.List;

public class Order {
	public void preOrder(Tree root) {
		if (!(root.isEmpty())) {
			visit(root);
			for (Iterator localIterator = root.getChilds().iterator(); localIterator.hasNext(); ) {
				Tree child = (Tree) localIterator.next();
				if (child == null)
					break;
				preOrder(child);
			}
		}
	}

	public void postOrder(Tree root) {
		if (!(root.isEmpty())) {
			for (Iterator localIterator = root.getChilds().iterator(); localIterator.hasNext(); ) {
				Tree child = (Tree) localIterator.next();
				if (child == null)
					break;
				preOrder(child);
			}

			visit(root);
		}
	}

	public void visit(Tree tree) {
		System.out.print("\t" + tree.getRootData());
	}
}