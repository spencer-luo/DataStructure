package datastructure.graph;

import java.io.PrintStream;

public class Test {
	public static void main(String[] args) {
		Object[] obj = {Character.valueOf('A'), Character.valueOf('B'), Character.valueOf('C'), Character.valueOf('D'), Character.valueOf('E'), Character.valueOf('F')};

		Graph graph = new MatrixGraph(obj);

		graph.addEdge(Character.valueOf('A'), Character.valueOf('C'), 5.0D);
		graph.addEdge(Character.valueOf('B'), Character.valueOf('A'), 2.0D);
		graph.addEdge(Character.valueOf('C'), Character.valueOf('B'), 15.0D);
		graph.addEdge(Character.valueOf('E'), Character.valueOf('D'), 4.0D);
		graph.addEdge(Character.valueOf('F'), Character.valueOf('E'), 18.0D);
		graph.addEdge(Character.valueOf('A'), Character.valueOf('F'), 60.0D);
		graph.addEdge(Character.valueOf('C'), Character.valueOf('F'), 70.0D);
		System.out.println(graph.printGraph());

		System.out.println(graph.dfs(Character.valueOf('A')));
		System.out.println(graph.bfs(Character.valueOf('A')));
	}
}