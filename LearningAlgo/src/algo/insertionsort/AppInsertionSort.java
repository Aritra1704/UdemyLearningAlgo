package algo.insertionsort;

public class AppInsertionSort {

	public static void main(String[] args) {
		int[] myarray = insertionSort(new int[] {9,8,5,20,56,1});
		for(int i = 0; i < myarray.length; i++) {
			System.out.print(myarray[i] + " ");
		}
	}

	public static int[] insertionSort(int[] a) {
		int element = -1;
		for(int i = 1; i < a.length; i++) {
			element = a[i];
			
			int j = i - 1;
			while(j >= 0 && a[j] > element) {
				a[j + 1] = a[j];
				j--;
			}
			a[j + 1] = element;
//			for(int j = i - 1; j >= 0; j--) {
//				if(a[j] > element) {
//					swap(a, j, j + 1);
//				}
//			}
		}
		return a;
	}
	
	public static void swap(int o[], int initial, int actual) {
		int temp = o[initial];
		o[initial] = o[actual];
		o[actual] = temp;
	}
}
