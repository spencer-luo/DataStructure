package datastructure.graph;

public class MatrixEdge extends Edge {
	private Object v1;
	private Object v2;

	public MatrixEdge(double weight) {
		this.v1 = null;
		this.v2 = null;
		this.info = null;
		this.weight = weight;
	}

	public MatrixEdge(Object v1, Object v2, Object info, double weight) {
		super(info, weight);
		this.v1 = v1;
		this.v2 = v2;
	}

	public Object getFirstVertex() {
		return this.v1;
	}

	public Object getSecondVertex() {
		return this.v2;
	}

	public int compareTo(Object o) {
		Edge e = (Edge) o;
		if (this.weight > e.getWeight())
			return 1;
		if (this.weight < e.getWeight())
			return -1;

		return 0;
	}

	public boolean equals(Object obj) {
		return ((((Edge) obj).info.equals(this.info)) && (((Edge) obj).getWeight() == this.weight));
	}

	public String toString() {
		return "from " + v1 + " to " + v2;
	}
}