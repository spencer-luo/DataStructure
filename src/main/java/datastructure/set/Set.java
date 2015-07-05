package datastructure.set;

public  interface Set {
	public  int size();

	public  void add(Object paramObject);

	public  Object get(int paramInt);

	public  void remove(Object paramObject);

	public  boolean contain(Object paramObject);

	public  boolean include(Set paramSet);

	public  Set unionSet(Set paramSet);

	public  Set intersection(Set paramSet);

	public  Set differenceSet(Set paramSet);

	public  boolean isEmpty();
}