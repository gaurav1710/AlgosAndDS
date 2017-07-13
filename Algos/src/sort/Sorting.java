package sort;

import java.util.Arrays;

import util.Utils;

public class Sorting {
	public static void main(String[] args) {
		int a[] = { 9, 8, 6, 5, 7, 10, 1, 3, 2, 4 };
		int b[] = { 9, 8, 6, 5, 7, 10, 1, 3, 2, 4, 11, 1, 0 };
		Utils.printArr(a);
		a = mergeSort(a);
		Utils.printArr(a);
		Utils.printArr(b);
		qsort(b, 0, b.length);
		Utils.printArr(b);
	}

	private static int[] mergeSort(int a[]) {
		int n = a.length;
		if (n <= 1)
			return a;
		int[] larr = mergeSort(Arrays.copyOfRange(a, 0, n / 2));
		int[] rarr = mergeSort(Arrays.copyOfRange(a, n / 2, n));
		int[] sarr = merge(larr, rarr);
		return sarr;
	}

	private static int[] merge(int a[], int b[]) {
		int[] c = new int[a.length + b.length];
		int i = 0, j = 0, k = 0;
		while (i < a.length && j < b.length) {
			if (a[i] <= b[j]) {
				c[k] = a[i];
				k++;
				i++;
			} else {
				c[k] = b[j];
				k++;
				j++;
			}
		}
		while (i < a.length) {
			c[k] = a[i];
			k++;
			i++;
		}
		while (j < b.length) {
			c[k] = b[j];
			k++;
			j++;
		}
		return c;
	}
	
	private static void qsort(int a[], int l, int r){
		if(r-l<=1)
			return;
		int i, j, t, k=l;
		int p = (l+r)/2;
		for(i=l;i<r;i++){
			if(a[p]>=a[i])
				k++;
		}
		k = (k==l)?l:k-1;
		t = a[k];
		a[k] = a[p];
		a[p] = t;
		p = k;
		for(i=l, j=r-1; i<=j; ){
			if((a[i]>=a[p]) && (a[j]<=a[p])){
				t = a[i];
				a[i] = a[j];
				a[j] = t;
				i++;
				j--;
			} else{
				if(a[i]<=a[p]){
					i++;
				}
				if(a[j]>=a[p]){
					j--;
				}
			}
		}
		qsort(a, l, p);
		qsort(a, p+1, r);
	}
}
