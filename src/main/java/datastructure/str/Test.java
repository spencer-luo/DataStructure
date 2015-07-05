package datastructure.str;

import java.io.PrintStream;

public class Test {
	public static void main(String[] args) {
		Str s = new ArrayStr("data structure!");
		Str s2 = new ArrayStr("hello world");
		System.out.println("len:" + s.length());
		System.out.println(s.compareTo(s2));
		System.out.println(s.charAt(5));
		System.out.println(s.indexOf(new ArrayStr("ture"), 3));
		System.out.println(s.indexOf('t', 3));
		System.out.println(s.delete(2, 5));
		System.out.println(s.length());
		System.out.println(s.concat(s2));
		System.out.println(s.substring(12, s.length()));
		System.out.println(s);
		System.out.println(s.delete(0, 12));
		System.out.println(s.replace(new ArrayStr("world"), new ArrayStr("animal ")));
		System.out.println(s.length());
		System.out.println(s.insert(13, new ArrayStr("world")));
	}
}