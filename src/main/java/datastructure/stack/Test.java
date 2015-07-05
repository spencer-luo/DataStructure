package datastructure.stack;

import java.io.PrintStream;

public class Test {
	public static void main(String[] args) {
		Stack stack = new LinkStack();
		for (int i = 0; i < 10; ++i)
			stack.push(Integer.valueOf(i));

		System.out.println(stack.toString());
		Object a = stack.pop();
		System.out.println(a + stack.toString());
		stack.push(Integer.valueOf(20));
		Object b = stack.peek();
		System.out.println(b + stack.toString());
		stack.clear();
		System.out.println("数据数量：" + stack.size() +
				"  isEmpty? " + stack.isEmpty() + "  数据为：" + stack.toString());
	}
}