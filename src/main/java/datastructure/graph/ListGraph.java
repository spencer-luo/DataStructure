package datastructure.graph;

import datastructure.list.ArrayList;
import datastructure.list.List;
import datastructure.queue.ArrayQueue;
import datastructure.queue.Queue;

import java.io.PrintStream;

public class ListGraph
		implements Graph {
	private List<Vertex> vertexs;
	private int edgeNum;

	public ListGraph() {
		this.vertexs = new ArrayList();
	}

	public List getVertexs() {
		return this.vertexs;
	}

	public ListGraph(Object[] vexs) {
		for (int i = 0; i < vexs.length; ++i)
			this.vertexs.add(new Vertex(vexs[i]));
	}

	private Vertex find(Object v) {
		Vertex vex = new Vertex(v);
		int i = this.vertexs.indexOf(vex);
		if (i < 0) {
			return null;
		}

		return ((Vertex) this.vertexs.get(i));
	}

	public void addEdge(Object v1, Object v2, double weight) {
		Vertex vex1 = find(v1);
		Vertex vex2 = find(v2);
		if ((vex1 != null) && (vex2 != null)) {
			ArcEdge e = new ArcEdge(null, weight, vex2);
			if (vex1.getFirstArc() == null) {
				vex1.setFirstArc(e);
			} else {
				ArcEdge arc = vex1.getFirstArc();
				while (arc.getNext() != null)
					arc = arc.getNext();

				arc.setNext(e);
				e.setPrior(arc);
			}
			this.edgeNum += 1;
		} else {
			throw new ArrayIndexOutOfBoundsException("顶点" + v1 + "或" + v2 + "不存在！");
		}
	}

	public void addEdge(Object v1, Object v2, Object info, double weight) {
		Vertex vex1 = find(v1);
		Vertex vex2 = find(v2);
		if ((vex1 != null) && (vex2 != null)) {
			ArcEdge e = new ArcEdge(info, weight, vex2);
			if (vex1.getFirstArc() == null) {
				vex1.setFirstArc(e);
			} else {
				ArcEdge arc = vex1.getFirstArc();
				while (arc.getNext() != null)
					arc = arc.getNext();

				arc.setNext(e);
				e.setPrior(arc);
			}
			this.edgeNum += 1;
		} else {
			throw new ArrayIndexOutOfBoundsException("顶点" + v1 + "或" + v2 + "不存在！");
		}
	}

	public void addVex(Object v) {
		this.vertexs.add(new Vertex(v));
	}

	public String bfs(Object o) {
		Visit[] visit = new Visit[this.vertexs.size()];
		for (int i = 0; i < this.vertexs.size(); ++i)
			visit[i] = Visit.unvisited;
		StringBuilder sb = new StringBuilder();
		Vertex vex = new Vertex(o);
		bfs(vex, visit, sb);
		return sb.toString();
	}

	private void bfs(Vertex vex, Visit[] visit, StringBuilder sb) {
		Queue queue = new ArrayQueue();

		int n = this.vertexs.indexOf(vex);
		sb.append(vex.getData() + "\t");
		visit[n] = Visit.visited;

		queue.push(vex);
		while (!(queue.isEmpty())) {
			Vertex u = (Vertex) queue.deQueue();
			Vertex v = getFirstVertex(u);
			while (v != null) {
				if (Visit.unvisited == visit[this.vertexs.indexOf(v)]) {
					sb.append(v.getData() + "\t");
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
		Vertex vex = new Vertex(o);
		dfs(vex, visit, sb);
		return sb.toString();
	}

	private void dfs(Vertex vex, Visit[] visit, StringBuilder sb) {
		int n = this.vertexs.indexOf(vex);
		sb.append(vex.getData() + "\t");
		visit[n] = Visit.visited;

		Vertex v = getFirstVertex(vex);
		while (v != null) {
			if (Visit.unvisited == visit[this.vertexs.indexOf(v)])
				dfs(v, visit, sb);
			v = getNextVertex(vex, v);
		}
	}

	public void clear() {
		this.vertexs.clear();
	}

	public int getEdgeSize() {
		return this.edgeNum;
	}

	public Object getFirstVertex(Object v) {
		Vertex vex = find(v);
		return getFirstVertex(vex).getData();
	}

	private Vertex getFirstVertex(Vertex v) {
		if ((v.getFirstArc() != null) && (v.getFirstArc().getVertex() != null))
			return v.getFirstArc().getVertex();
		return null;
	}

	public Object getNextVertex(Object v1, Object v2) {
		Vertex vex1 = find(v1);
		Vertex vex2 = find(v2);
		System.out.println("v1:" + v1);
		System.out.println("v2:" + v2);
		System.out.println("vex1:" + vex1);
		System.out.println("vex2:" + vex2);
		return getNextVertex(vex1, vex2);
	}

	private Vertex getNextVertex(Vertex vex1, Vertex vex2) {
		ArcEdge arc = vex1.getFirstArc();
		while ((arc.getNext() != null) && (arc.getVertex() != vex2))
			arc = arc.getNext();

		if (arc.getVertex() != null) {
			return arc.getNext().getVertex();
		}
		return null;
	}

	public int getVertexSize() {
		return this.vertexs.size();
	}

	public void removeEdge(Object v1, Object v2) {
		Vertex vex1 = find(v1);
		Vertex vex2 = find(v2);
		if ((vex1 != null) && (vex2 != null)) {
			ArcEdge arc = vex1.getFirstArc();
			while ((arc.getNext() != null) && (arc.getVertex() != vex2))
				arc = arc.getNext();

			if (arc.getVertex() == vex2) {
				ArcEdge priEdge = arc.getPrior();
				ArcEdge nextEdge = arc.getNext();
				priEdge.setNext(nextEdge);
				nextEdge.setPrior(priEdge);
				this.edgeNum -= 1;
				return;
			}
			throw new ArrayIndexOutOfBoundsException("边" + v1 + "到" + v2 + "不存在！");
		}

		throw new ArrayIndexOutOfBoundsException("顶点" + v1 + "或" + v2 + "不存在！");
	}

	public void removeVex(Object v) {
		for (int i = 0; i < this.vertexs.size(); ++i) {
			Vertex vex1 = (Vertex) this.vertexs.get(i);
			ArcEdge arc = vex1.getFirstArc();
			if (arc != null)
				while (arc.getNext() != null)
					if (arc.getVertex().getData() == v)
						removeEdge(vex1, v);


		}

		Vertex vex = find(v);
		if (vex != null) {
			int i = this.vertexs.indexOf(vex);
			this.vertexs.remove(i);
		}
	}

	public String printGraph() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < this.vertexs.size(); ++i) {
			Vertex vex = (Vertex) this.vertexs.get(i);
			sb.append("\n顶点：" + vex.getData() + "\t");
			ArcEdge arc = vex.getFirstArc();
			if (arc != null) {
				sb.append("孤，" + arc.getVertex().getData());
				while (arc.getNext() != null) {
					sb.append("\t" + arc.getNext().getVertex().getData());
					arc = arc.getNext();
				}
			}
		}
		return sb.toString();
	}

	private static enum Visit {
		unvisited, visited;
	}
}