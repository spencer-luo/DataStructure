package datastructure.find;

public class Find {
	public static int arraySearch(int[] s, int key) {
		for (int i = 0; i < s.length; ++i)
			if (key == s[i])
				return i;

		return -1;
	}

	public static int binSearch(int[] s, int low, int high, int key) {
		while (low <= high) {
			int mid = (low + high) / 2;
			if (s[mid] == key) return mid;
			if (s[mid] > key) high = mid - 1;
			else low = mid + 1;
		}
		return -1;
	}
}