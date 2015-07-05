package datastructure.str;

public class ArrayStr
		implements Str {
	private int len;
	private char[] s;

	public ArrayStr() {
		this.len = 0;
	}

	public ArrayStr(char[] ch) {
		this.len = ch.length;
		this.s = ch;
	}

	public ArrayStr(Str s) {
		this.len = s.length();
		for (int i = 0; i < this.len; ++i)
			this.s[i] = s.charAt(i);
	}

	public ArrayStr(String str) {
		this.len = str.length();
		this.s = new char[this.len];
		for (int i = 0; i < this.len; ++i)
			this.s[i] = str.charAt(i);
	}

	public char charAt(int index) {
		if ((index < 0) || (index > this.len))
			throw new StringIndexOutOfBoundsException(index);

		return this.s[index];
	}

	public int compareTo(Object o) {
		Str s2 = (Str) o;
		int n = Math.min(this.len, s2.length());
		int i = 0;
		while (i < n) {
			char c1 = this.s[i];
			char c2 = s2.charAt(i);
			if (c1 != c2)
				return (c1 - c2);

			++i;
		}
		return (this.len - s2.length());
	}

	public Str concat(Str str) {
		int n = this.len + str.length();
		expand(n);
		for (int i = 0; i < str.length(); ++i)
			this.s[(i + this.len)] = str.charAt(i);

		this.len = n;
		return this;
	}

	public Str delete(int begin, int end) {
		int n = end - begin;
		char[] c = new char[n];
		for (int i = end; i < this.len; ++i)
			this.s[(i - n)] = this.s[i];

		this.len -= n;
		return this;
	}

	private void expand(int size) {
		char[] c = new char[size];
		for (int i = 0; i < this.len; ++i)
			c[i] = this.s[i];

		this.s = c;
	}

	public int indexOf(char c) {
		return indexOf(c, 0);
	}

	public int indexOf(char c, int from) {
		int i = from;
		while (i < this.len) {
			if (c == this.s[i])
				return i;
			++i;
		}
		return -1;
	}

	public int indexOf(Str str) {
		return indexOf(str, 0);
	}

	public int indexOf(Str str, int from) {
		int i = from;
		int j = 0;
		int sLen = str.length();
		while ((i < this.len) && (j < sLen))
			if (this.s[i] == str.charAt(j)) {
				++i;
				++j;
			} else {
				i = i - j + 1;
				j = 0;
			}

		if (j == sLen)
			return (i - sLen);

		return -1;
	}

	public Str insert(int pos, Str str) {
		char[] c = (char[]) null;
		if ((pos < 0) || (pos > this.len))
			throw new StringIndexOutOfBoundsException(pos);

		Str s2 = substring(pos);
		delete(pos, this.len);
		concat(str);
		concat(s2);

		return this;
	}

	public int length() {
		return this.len;
	}

	public Str replace(Str target, Str replacement) {
		return replace(target, replacement, 0);
	}

	public Str replace(Str target, Str replacement, int from) {
		int tLen = target.length();
		int rLen = replacement.length();
		int k = 0;
		while (k < this.len) {
			int pos = indexOf(target, from);
			if (-1 == pos)
				break;

			delete(pos, pos + tLen);
			insert(pos, replacement);
			k = pos + rLen;
		}

		return this;
	}

	public Str substring(int strartIndex) {
		return substring(strartIndex, this.len);
	}

	public Str substring(int beginIndex, int endIndex) {
		int n = endIndex - beginIndex;
		char[] ss = new char[n];
		for (int i = 0; i < n; ++i)
			ss[i] = this.s[(i + beginIndex)];

		return new ArrayStr(ss);
	}

	public char[] toCharArray() {
		return this.s;
	}

	public String toString() {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < this.len; ++i)
			sb.append(this.s[i]);

		return sb.toString();
	}
}