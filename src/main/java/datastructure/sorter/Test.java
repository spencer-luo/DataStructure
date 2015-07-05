package datastructure.sorter;

import java.io.PrintStream;

public class Test {
	public static void main(String[] args) {
		int[] a = {5, 6, 8, 1, 8, 88, 56, 78};
		Sorter sort = new Sorter();
		Integer[] b = sort.intToInteger(a);

		sort.mergeSort(b, 0, b.length - 1);
		for (int i = 0; i < b.length; ++i)
			System.out.print(b[i] + "  ");
	}
}