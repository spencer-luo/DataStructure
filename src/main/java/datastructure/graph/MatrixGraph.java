package datastructure.graph;

import datastructure.list.ArrayList;
import datastructure.list.List;
import datastructure.queue.ArrayQueue;
import datastructure.queue.Queue;

public class MatrixGraph
		implements Graph {
	private static final int defaultSize = 10;
	private int maxLen;
	private int edgeNum;
	private List vertexs;
	private Edge[][] edges;

	public MatrixGraph() {
		this.maxLen = 10;
		this.vertexs = new ArrayList();
		this.edges = new MatrixEdge[this.maxLen][this.maxLen];
	}

	public MatrixGraph(Object[] vexs) {
		this.maxLen = vexs.length;
		this.vertexs = new ArrayList();
		this.edges = new MatrixEdge[this.maxLen][this.maxLen];
		for (int i = 0; i < this.maxLen; ++i)
			this.vertexs.add(vexs[i]);
	}

	public void addEdge(Object v1, Object v2, double weight) {
		int i1 = this.vertexs.indexOf(v1);
		int i2 = this.vertexs.indexOf(v2);

		if ((i1 >= 0) && (i1 < this.vertexs.size()) && (i2 >= 0) && (i2 < this.vertexs.size())) {
			this.edges[i1][i2] = new MatrixEdge(v1, v2, null, weight);
			this.edgeNum += 1;
		} else {
			throw new ArrayIndexOutOfBoundsException("顶点越界或对应的边不合法！");
		}
	}

	public void addEdge(Object v1, Object v2, Object info, double weight) {
		int i1 = this.vertexs.indexOf(v1);
		int i2 = this.vertexs.indexOf(v2);
		if ((i1 >= 0) && (i1 < this.vertexs.size()) && (i2 >= 0) && (i2 < this.vertexs.size())) {
			this.edges[i1][i2] = new MatrixEdge(v1, v2, info, weight);
			this.edgeNum += 1;
		} else {
			throw new ArrayIndexOutOfBoundsException("顶点越界或对应的边不合法！");
		}
	}

	public void addVex(Object v) {
		this.vertexs.add(v);
		if (this.vertexs.size() > this.maxLen)
			expand();
	}

	private void expand() {
		MatrixEdge[][] newEdges = new MatrixEdge[2 * this.maxLen][2 * this.maxLen];
		for (int i = 0; i < this.maxLen; ++i)
			for (int j = 0; j < this.maxLen; ++j)
				newEdges[i][j] = ((MatrixEdge) this.edges[i][j]);


		this.edges = newEdges;
	}

	public int getEdgeSize() {
		return this.edgeNum;
	}

	public int getVertexSize() {
		return this.vertexs.size();
	}

	public void removeEdge(Object v1, Object v2) {
		int i1 = this.vertexs.indexOf(v1);
		int i2 = this.vertexs.indexOf(v2);
		if ((i1 >= 0) && (i1 < this.vertexs.size()) && (i2 >= 0) && (i2 < this.vertexs.size()))
			if (this.edges[i1][i2] == null) {
				try {
					throw new Exception("该边不存在！");
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				this.edges[i1][i2] = null;
				this.edgeNum -= 1;
			}
		else
			throw new ArrayIndexOutOfBoundsException("顶点越界或对应的边不合法！");
	}

	public void removeVex(Object v) {
		int index = this.vertexs.indexOf(v);
		int n = this.vertexs.size();
		this.vertexs.remove(index);
		for (int i = 0; i < n; ++i) {
			this.edges[i][(n - 1)] = null;
			this.edges[(n - 1)][i] = null;
		}
	}

	public String printGraph() {
		StringBuilder sb = new StringBuilder();
		int n = getVertexSize();
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j)
				sb.append("  " + this.edges[i][j]);

			sb.append("\n");
		}
		return sb.toString();
	}

	public void clear() {
		this.maxLen = 10;
		this.vertexs.clear();
		this.edges = null;
	}

	public String bfs(Object o) {
		Visit[] visit = new Visit[this.vertexs.size()];
		for (int i = 0; i < this.vertexs.size(); ++i)
			visit[i] = Visit.unvisited;
		StringBuilder sb = new StringBuilder();
		bfs(o, visit, sb);
		return sb.toString();
	}

	private void bfs(Object o, Visit[] visit, StringBuilder sb) {
		Queue queue = new ArrayQueue();

		int n = this.vertexs.indexOf(o);
		sb.append(o + "\t");
		visit[n] = Visit.visited;

		queue.push(o);
		while (!(queue.isEmpty())) {
			Object u = queue.deQueue();
			Object v = getFirstVertex(u);
			while (v != null) {
				if (Visit.unvisited == visit[this.vertexs.indexOf(v)]) {
					sb.append(v + "\t");
					visit[this.vertexs.indexOf(v)] = Visit.visited;
					queue.push(v);
				}
				v = getNextVertex(u, v);
			}
		}
	}

	public String dfs(Object o) {
		Visit[] visit = new Visit[this.vertexs.size()];
		for (int i = 0; i < this.vertexs.size(); ++i)
			visit[i] = Visit.unvisited;
		StringBuilder sb = new StringBuilder();
		dfs(o, visit, sb);
		return sb.toString();
	}

	private void dfs(Object o, Visit[] visit, StringBuilder sb) {
		int n = this.vertexs.indexOf(o);
		sb.append(o + "\t");
		visit[n] = Visit.visited;

		Object v = getFirstVertex(o);
		while (v != null) {
			if (Visit.unvisited == visit[this.vertexs.indexOf(v)])
				dfs(v, visit, sb);
			v = getNextVertex(o, v);
		}
	}

	public Object getFirstVertex(Object v) {
		int i = this.vertexs.indexOf(v);
		if (i < 0)
			throw new ArrayIndexOutOfBoundsException("顶点v不存在！");
		for (int col = 0; col < this.vertexs.size(); ++col)
			if (this.edges[i][col] != null)
				return this.vertexs.get(col);
		return null;
	}

	public Object getNextVertex(Object v1, Object v2) {
		int i1 = this.vertexs.indexOf(v1);
		int i2 = this.vertexs.indexOf(v2);
		if ((i1 < 0) || (i2 < 0))
			throw new ArrayIndexOutOfBoundsException("顶点v不存在！");
		for (int col = i2 + 1; col < this.vertexs.size(); ++col)
			if (this.edges[i1][col] != null)
				return this.vertexs.get(col);
		return null;
	}

	private static enum Visit {
		unvisited, visited;
	}
}