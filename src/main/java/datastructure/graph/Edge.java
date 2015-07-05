package datastructure.graph;

public abstract class Edge
		implements Comparable {
	protected double weight;
	protected Object info;

	public Edge() {
		this.weight = 0D;
	}

	public Edge(double weight) {
		this.weight = weight;
	}

	public Edge(Object info, double weight) {
		this.weight = weight;
		this.info = info;
	}

	public double getWeight() {
		return this.weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public Object getInfo() {
		return this.info;
	}

	public void setInfo(Object info) {
		this.info = info;
	}

	public abstract Object getFirstVertex();

	public abstract Object getSecondVertex();
}