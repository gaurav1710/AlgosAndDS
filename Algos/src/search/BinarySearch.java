package search;

import util.Utils;

public class BinarySearch {

	public static void main(String[] args) {
		int a[] = { 1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 20, 24, 56, 78, 99, 697 };
		System.out.println("Finding 11..");
		System.out.println("Found:" + binarySrch(a, 11, 0, a.length));
		System.out.println("Finding 177..");
		System.out.println("Found:" + binarySrch(a, 177, 0, a.length));
		System.out.println("Rotating "+ a.length/3+" times..");
		rotate(a,  a.length/3, true);
		Utils.printArr(a);
		System.out.println("Verifying rotation..");
		System.out.println("Rotation count="+rotationCount(a));
		System.out.println("Finding 7 in rotated array..");
		System.out.println("Found:" +binarySrchRotated(a, 7));
		System.out.println("Rotating "+ a.length/3+" times back..");
		rotate(a,  a.length/3, false);
		Utils.printArr(a);
	}

	private static int binarySrch(int a[], int x, int l, int h) {
		if (l >= h)
			return -1;
		int mid = (l + h) / 2;
		if (a[mid] == x)
			return mid;
		if (a[mid] > x)
			return binarySrch(a, x, l, mid - 1);
		else
			return binarySrch(a, x, mid + 1, h);
	}

	private static void rotate(int a[], int k, boolean clockwise) {
		if (clockwise) {
			for (int i = 0; i < k; i++) {
				int cur, last = a[0];
				for (int j = a.length-1; j >= 0; j--) {
					cur = a[j];
					a[j] = last;
					last = cur;
				}
			}
		} else{
			for (int i = 0; i < k; i++) {
				int cur, last = a[a.length-1];
				for (int j = 0; j < a.length; j++) {
					cur = a[j];
					a[j] = last;
					last = cur;
					
				}
			}
		}
	}
	
	private static int binarySrchRotated(int a[], int x){
		int l = 0, h = a.length-1, m;
		while(l<=h){
			m = (l+h)/2;
			if(a[m] == x)
				return m;
			if(a[m] > x){
				if(a[m]>a[l] && a[l]<x){
					h = m-1;
				} else{
					l=m+1;
				}
			} else{
				if(a[m]<a[h] && a[h]>x){
					l = m+1;
				} else{
					h = m-1;
				}
			}
		}
		return -1;
	}
	
	private static int rotationCount(int a[]){
		int k = 0, l = 0, h = a.length - 1, m, n = a.length;
		while(l<=h){
			m=(l+h)/2;
			if(m-1>=0 && m+1<n){
				if(a[m]>a[m+1]){
					k = n-m;
					break;
				}
				if(a[m]<a[m-1]){
					k = n-m;
					break;
				}
			}
			if(a[l]<=a[m])
				l = m+1;
			if(a[h]>=a[m])
				h=m-1;
		}
		return k;
	}
}
