package datastructure.set;

import java.io.PrintStream;

public class Test {
	public static void main(String[] args) {
		Set a = new ArraySet();
		Set b = new ArraySet();
		Set c = new ArraySet();
		Set d = new ArraySet();
		a.add(Integer.valueOf(2));
		a.add(Integer.valueOf(3));
		a.add(Integer.valueOf(4));
		a.add(Integer.valueOf(8));
		b.add(Integer.valueOf(3));
		b.add(Integer.valueOf(4));
		b.add(Integer.valueOf(5));
		c.add(Integer.valueOf(3));
		c.add(Integer.valueOf(4));
		System.out.println(a.size());
		System.out.println(b.size());
		System.out.println(a);
		System.out.println(a.isEmpty());
		System.out.println(a.get(1));
		System.out.println(a.unionSet(b));
		System.out.println(a.intersection(b));
		System.out.println(a.differenceSet(b));
		System.out.println(a.include(b));
		System.out.println(a.include(c));
		a.remove(Integer.valueOf(8));
		System.out.println(a);
	}
}