package datastructure.tree.btree;

import datastructure.common.Strategy;

public class StrategyEqual
		implements Strategy {
	public boolean equal(Object obj1, Object obj2) {
		Character ch1 = (Character) obj1;
		Character ch2 = (Character) obj2;
		return ch1.equals(ch2);
	}

	public int compare(Object obj1, Object obj2) {
		return 0;
	}
}