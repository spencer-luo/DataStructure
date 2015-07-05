package datastructure.find;

import datastructure.common.Strategy;

public class StrategyCompare
		implements Strategy {
	public boolean equal(Object obj1, Object obj2) {
		return false;
	}

	public int compare(Object obj1, Object obj2) {
		Integer n1 = (Integer) obj1;
		Integer n2 = (Integer) obj2;
		return n1.compareTo(n2);
	}
}