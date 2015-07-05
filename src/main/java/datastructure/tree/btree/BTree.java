package datastructure.tree.btree;

public interface BTree {
	  void addLeftTree(BTree paramBTree);

	  void addRightTree(BTree paramBTree);

	  void clearTree();

	  int dept();

	  BTree getLeftChild();

	  BTree getRightChild();

	  Object getRootData();

	  boolean hasLeftTree();

	  boolean hasRightTree();

	  boolean isEmpty();

	  boolean isLeaf();

	  void removeLeftChild();

	  void removeRightChild();

	  BTree root();

	  void setRootData(Object paramObject);

	  int size();
}