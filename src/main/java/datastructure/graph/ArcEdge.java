package datastructure.graph;

public class ArcEdge extends Edge {
	private Vertex vertex;
	private ArcEdge prior;
	private ArcEdge next;

	public ArcEdge() {
	}

	public ArcEdge(double weight) {
		super(weight);
		this.prior = null;
		this.next = null;
	}

	public ArcEdge(Object info, double weight) {
		super(info, weight);
		this.prior = null;
		this.next = null;
	}

	public ArcEdge(Object info, double weight, Vertex vertex) {
		this(info, weight);
		this.vertex = vertex;
		this.prior = null;
		this.next = null;
	}

	public Vertex getVertex() {
		return this.vertex;
	}

	public void setVertex(Vertex vertex) {
		this.vertex = vertex;
	}

	public ArcEdge getPrior() {
		return this.prior;
	}

	public void setPrior(ArcEdge prior) {
		this.prior = prior;
	}

	public ArcEdge getNext() {
		return this.next;
	}

	public void setNext(ArcEdge next) {
		this.next = next;
	}

	public int compareTo(Object o) {
		double w2 = ((Edge) o).getWeight();
		if (this.weight < w2)
			return -1;
		if (this.weight > w2)
			return 1;
		return 0;
	}

	public boolean equals(Object obj) {
		ArcEdge arc = (ArcEdge) obj;

		return ((this.next == arc.next) && (this.weight == arc.weight));
	}

	public Object getFirstVertex() {
		return this.prior.vertex.getData();
	}

	public Object getSecondVertex() {
		return this.vertex.getData();
	}
}