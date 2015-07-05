package datastructure.find;

import java.io.PrintStream;

public class Test {
	public static void main(String[] args) {
		int[] a = {6, 11, 4, 3, 52, 5, 7, 0, 25, 9};

		int n = Find.arraySearch(a, 5);

		System.out.println(n);
	}
}