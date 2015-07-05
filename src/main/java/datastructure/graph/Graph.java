package datastructure.graph;

public  interface Graph {
	public  void addVex(Object paramObject);

	public  void addEdge(Object paramObject1, Object paramObject2, double paramDouble);

	public  void addEdge(Object paramObject1, Object paramObject2, Object paramObject3, double paramDouble);

	public  void clear();

	public  Object getFirstVertex(Object paramObject);

	public  Object getNextVertex(Object paramObject1, Object paramObject2);

	public  int getVertexSize();

	public  int getEdgeSize();

	public  void removeVex(Object paramObject);

	public  void removeEdge(Object paramObject1, Object paramObject2);

	public  String dfs(Object paramObject);

	public  String bfs(Object paramObject);

	public  String printGraph();
}