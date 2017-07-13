package util;

public class Utils {
	public static void printArr(int a[]){
		for(int i=0; i < a.length ; i++){
			System.out.print(a[i]);
			if(i!=a.length-1)
				System.out.print(",");
		}
		System.out.println("");
	}
}
