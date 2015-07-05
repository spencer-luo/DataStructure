package datastructure.list;

import java.io.PrintStream;

public class Test {
	public static void main(String[] args) {
		List list = new ArrayList();
		for (int i = 0; i < 10; i ++) {
			list.add(i);
		}

		list.remove(9);
		System.out.print("size;" + list.size() + "\n");
		System.out.println("isEmpty:" + list.isEmpty());
		System.out.print("第7个位置的元素：" + list.get(7) + "\n");
		for (int i = 0; i < list.size(); ++i)
			System.out.print(list.get(i) + "    ");

		list.add(Integer.valueOf(31));
		list.add(Integer.valueOf(32));
		list.insert(3, new Integer(5));
		System.out.print("\n size:" + list.size() + "\n");
		System.out.print("第一次出现5的索引：" + list.indexOf(Integer.valueOf(5)) + "\n");
		System.out.print("最后一次出现5的索引：" + list.lastIndexOf(Integer.valueOf(5)) + "\n");

		for (int i = 0; i < list.size(); ++i)
			System.out.print(list.get(i) + "    ");
	}
}