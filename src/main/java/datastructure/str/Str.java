package datastructure.str;

public  interface Str extends Comparable {
	public  int length();

	public  char charAt(int paramInt);

	public  int indexOf(char paramChar);

	public  int indexOf(char paramChar, int paramInt);

	public  int indexOf(Str paramStr);

	public  int indexOf(Str paramStr, int paramInt);

	public  Str substring(int paramInt);

	public  Str substring(int paramInt1, int paramInt2);

	public  Str insert(int paramInt, Str paramStr);

	public  Str delete(int paramInt1, int paramInt2);

	public  Str replace(Str paramStr1, Str paramStr2);

	public  Str replace(Str paramStr1, Str paramStr2, int paramInt);

	public  Str concat(Str paramStr);

	public  char[] toCharArray();
}