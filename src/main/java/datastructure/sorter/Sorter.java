package datastructure.sorter;

import datastructure.common.Strategy;

public class Sorter
		implements Strategy {
	public void insertSort(Object[] r, int low, int high) {
		for (int i = low + 1; i <= high; ++i) {
			if (compare(r[i], r[(i - 1)]) < 0) {
				Object temp = r[i];
				r[i] = r[(i - 1)];
				int j = i - 2;
				for (; (j >= low) && (compare(temp, r[j]) < 0); --j)
					r[(j + 1)] = r[j];
				r[(j + 1)] = temp;
			}
		}
	}

	public void binInsetSort(Object[] r, int low, int high) {
		for (int i = low + 1; i <= high; ++i) {
			Object temp = r[i];
			int hi = i - 1;
			int lo = low;
			while (lo <= hi) {
				int mid = (lo + hi) / 2;
				if (compare(temp, r[mid]) < 0)
					hi = mid - 1;
				else lo = mid + 1;
			}
			for (int j = i - 1; j > hi; ) {
				r[(j + 1)] = r[j];
				--j;
			}
			r[(hi + 1)] = temp;
		}
	}

	public void shellSort(Object[] r, int low, int high, int[] delta) {
		for (int k = 0; k < delta.length; ++k)
			shellInsert(r, low, high, delta[k]);
	}

	private void shellInsert(Object[] r, int low, int high, int deltaK) {
		for (int i = low + deltaK; i <= high; ++i)
			if (compare(r[i], r[(i - deltaK)]) < 0) {
				Object temp = r[i];
				int j = i - deltaK;
				for (; (j >= low) && (compare(temp, r[j]) < 0); j -= deltaK)
					r[(j + deltaK)] = r[j];
				r[(j + deltaK)] = temp;
			}
	}

	public void bubbleSort(Object[] r, int low, int high) {
		int n = high - low + 1;
		for (int i = 1; i < n; ++i)
			for (int j = low; j <= high - i; ++j)
				if (compare(r[j], r[(j + 1)]) > 0) {
					Object temp = r[j];
					r[j] = r[(j + 1)];
					r[(j + 1)] = temp;
				}
	}

	public void quickSort(Object[] r, int low, int high) {
		if (low < high) {
			int pa = partition(r, low, high);
			quickSort(r, low, pa - 1);
			quickSort(r, pa + 1, high);
		}
	}

	private int partition(Object[] r, int low, int high) {
		Object pivot = r[low];
		while (low < high) {
			if ((low < --high) && (compare(r[high], pivot) >= 0)) ;
			r[low] = r[high];
			for (; (low < high) && (compare(r[low], pivot) <= 0); ++low) ;
			r[high] = r[low];
		}
		r[low] = pivot;
		return low;
	}

	public void selectSort(Object[] r, int low, int high) {
		for (int k = low; k < high; ++k) {
			int min = k;
			for (int i = min + 1; i <= high; ++i)
				if (compare(r[i], r[min]) < 0) min = i;
			if (k != min) {
				Object temp = r[k];
				r[k] = r[min];
				r[min] = temp;
			}
		}
	}

	public void heapSort(Object[] r) {
		int n = r.length - 1;
		for (int i = n / 2; i >= 1; --i)
			heapAdjust(r, i, n);
		for (int i = n; i > 1; --i) {
			Object temp = r[1];
			r[1] = r[i];
			r[i] = temp;
			heapAdjust(r, 1, i - 1);
		}
	}

	private void heapAdjust(Object[] r, int low, int high) {
		Object temp = r[low];
		for (int j = 2 * low; j <= high; j *= 2) {
			if ((j < high) && (compare(r[j], r[(j + 1)]) < 0)) ++j;

			if (compare(temp, r[j]) >= 0) break;
			r[low] = r[j];
			low = j;
		}
		r[low] = temp;
	}

	public void mergeSort(Object[] r, int low, int high) {
		if (low < high) {
			mergeSort(r, low, (high + low) / 2);
			mergeSort(r, (high + low) / 2 + 1, high);
			merge(r, low, (high + low) / 2, high);
		}
	}

	private void merge(Object[] a, int p, int q, int r) {
		Object[] b = new Object[r - p + 1];
		int s = p;
		int t = q + 1;
		int k = 0;
		do {
			if (compare(a[s], a[t]) < 0)
				b[(k++)] = a[(s++)];
			else
				b[(k++)] = a[(t++)];
			if (s > q) break;
		}
		while (t <= r);

		while (s <= q)
			b[(k++)] = a[(s++)];
		while (t <= r)
			b[(k++)] = a[(t++)];
		for (int i = 0; i < b.length; ++i)
			a[(p + i)] = b[i];
	}

	public Integer[] intToInteger(int[] a) {
		Integer[] b = new Integer[a.length];
		for (int i = 0; i < a.length; ++i)
			b[i] = Integer.valueOf(a[i]);

		return b;
	}

	public boolean equal(Object obj1, Object obj2) {
		return false;
	}

	public int compare(Object obj1, Object obj2) {
		Integer a = (Integer) obj1;
		Integer b = (Integer) obj2;
		if (a.compareTo(b) < 0) return -1;
		if (a.compareTo(b) == 0) return 0;
		return 1;
	}
}