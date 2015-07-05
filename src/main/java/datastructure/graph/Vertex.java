package datastructure.graph;

public class Vertex {
	private Object data;
	private ArcEdge firstArc;

	public Vertex() {
		this.data = null;
		this.firstArc = null;
	}

	public Vertex(Object data) {
		this.data = data;
		this.firstArc = null;
	}

	public Object getData() {
		return this.data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public ArcEdge getFirstArc() {
		return this.firstArc;
	}

	public void setFirstArc(ArcEdge firstArc) {
		this.firstArc = firstArc;
	}

	public boolean equals(Object obj) {
		Vertex v = (Vertex) obj;

		return (this.data.equals(v.getData()));
	}

	public String toString() {
		return this.data + "  " + this.firstArc;
	}
}