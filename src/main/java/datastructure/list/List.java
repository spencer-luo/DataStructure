package datastructure.list;

public  interface List<E> {
	public  void add(Object paramObject);

	public  void clear();

	public  Object get(int paramInt);

	public  int indexOf(Object paramObject);

	public  void insert(int paramInt, Object paramObject);

	public  boolean isEmpty();

	public  int lastIndexOf(Object paramObject);

	public  void remove(int paramInt);

	public  void set(int paramInt, Object paramObject);

	public  int size();
}